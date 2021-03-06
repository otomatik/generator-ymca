/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package <%= appPackage %>.tasks.domain.usecase;

import <%= appPackage %>.UseCase;
import <%= appPackage %>.base.domain.error.DataNotAvailableError;
import <%= appPackage %>.data.Task;
import <%= appPackage %>.data.source.TasksDataSource;
import <%= appPackage %>.data.source.TasksRepository;
import <%= appPackage %>.tasks.TasksFilterType;
import <%= appPackage %>.tasks.domain.filter.FilterFactory;
import <%= appPackage %>.tasks.domain.filter.TaskFilter;

import java.util.List;

/**
 * Fetches the list of tasks.
 */
public class GetTasks extends UseCase<GetTasks.RequestValues, GetTasks.ResponseValue> {

    private final TasksRepository mTasksRepository;
    private final FilterFactory mFilterFactory;

    public GetTasks(TasksRepository tasksRepository, FilterFactory filterFactory) {
        mTasksRepository = tasksRepository;
        mFilterFactory = filterFactory;
    }

    @Override
    protected void executeUseCase(final RequestValues values) {
        if (values.isForceUpdate()) {
            mTasksRepository.refreshTasks();
        }

        mTasksRepository.getTasks(new TasksDataSource.LoadTasksCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                TasksFilterType currentFiltering = values.getCurrentFiltering();
                TaskFilter taskFilter = mFilterFactory.create(currentFiltering);

                List<Task> tasksFiltered = taskFilter.filter(tasks);
                ResponseValue responseValue = new ResponseValue(tasksFiltered);
                getUseCaseCallback().onSuccess(responseValue);
            }

            @Override
            public void onDataNotAvailable() {
                getUseCaseCallback().onError(new DataNotAvailableError());
            }
        });

    }

    public static class RequestValues extends UseCase.RequestValues {
        private final TasksFilterType mCurrentFiltering;
        private final boolean mForceUpdate;

        public RequestValues(boolean forceUpdate, TasksFilterType currentFiltering) {
            this.mForceUpdate = forceUpdate;
            mCurrentFiltering = currentFiltering;
        }

        public boolean isForceUpdate() {
            return mForceUpdate;
        }

        public TasksFilterType getCurrentFiltering() {
            return mCurrentFiltering;
        }
    }

    public static class ResponseValue extends UseCase.ResponseValue {
        private List<Task> mTasks;

        public ResponseValue(List<Task> tasks) {
            mTasks = tasks;
        }

        public List<Task> getTasks() {
            return mTasks;
        }
    }
}
