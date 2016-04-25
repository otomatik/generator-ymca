'use strict';

var path = require('path');
var assert = require('yeoman-generator').assert;
var helpers = require('yeoman-generator').test;
var os = require('os');

describe('ymca:app', function () {
  before(function (done) {
    helpers.run(path.join(__dirname, '../app'))
      .inDir(path.join(os.tmpdir(), './temp-test'))
      .withPrompts({
        name: 'test',
        package: 'org.example.testapp',
        targetSdk: '21',
        minSdk: '14'
      })
      .on('end', done);
  });

  it('creates project files', function () {
    assert.file([
      '.gitignore',
      'build.gradle',
      'gradle.properties',
      'gradlew',
      'gradlew.bat',
      'settings.gradle'
    ]);
  });

  it('creates core app files', function () {
    assert.file([
      'app/.gitignore',
      'app/build.gradle',
      'app/proguard-rules.pro',
      'app/src/main/AndroidManifest.xml'
    ]);
  });

  it('copies gradle wrapper', function () {
    assert.file([
      'gradle/wrapper/gradle-wrapper.jar',
      'gradle/wrapper/gradle-wrapper.properties'
    ]);
  });

  it('copies androidTest, androidTestMock, mock, prod, test files', function () {
    assert.file([
      'app/src/androidTest/java/org/example/testapp/TestUtils.java',
      'app/src/mock/java/org/example/testapp/Injection.java',
      'app/src/prod/java/org/example/testapp/Injection.java',
      'app/src/test/java/org/example/testapp/TestUseCaseScheduler.java',
      'app/src/androidTestMock/java/org/example/testapp/taskdetail'
    ]);
  });
});
