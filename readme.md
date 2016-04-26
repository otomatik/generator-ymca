# YMCA : Yeoman MVP Clean Architecture for Android
YMCA is a [Yeoman](http://yeoman.io) generator to scaffold an Android application based on the [Google's sample ToDo list](https://github.com/googlesamples/android-architecture/tree/todo-mvp/) which illustrates the [MVP pattern](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) and clean architecture principles.

You can use it to bootstrap an application project to save time for instance. It may also help if you consider diving into the ToDo sample and familiarize with the MVP pattern or the Clean Architecture concepts.

## Installation
### Install Yeoman

Not every new computer comes with a Yeoman pre-installed. He lives in the [npm](https://npmjs.org) package repository. You only have to ask for him once, then he packs up and moves into your hard drive.

```bash
npm install -g yo
```

### Install the generator

Yeoman travels light. He didn't pack any generators when he moved in. You can think of a generator like a plug-in.

To install generator-ymca from npm, run:

```bash
npm install -g generator-ymca
```

## Usage
Create the folder for your project and move into:
```bash
mkdir my-awesome-app && cd $_
```
Then initiate the generator:

```bash
yo ymca
```

This will create a MVP structured ToDo list Android app skeleton based on the clean architecture principles. Once you ran it, you are free to remove any part of that wouldn't fit your needs (ie. you may not be interested in creating a ToDo list application).

## History
v1.0: simple MVP generator inside

## Road map
* Adding support for others [Google's samples](https://github.com/googlesamples/android-architecture/)
* Adding more configurable fields in the generator

## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Make sure all tests still pass `mocha test/test-app.js`
5. Push to the branch: `git push origin my-new-feature`
6. Submit a pull request :D

## Spread the word (and love)
If you found YMCA useful you can tweet just by clicking [here](https://goo.gl/lsIE8D)!

## Credits
Inspired by the [generator-android-square-stack](https://raw.githubusercontent.com/kuhnza/generator-android-square-stack)
& made with the [yeoman generator-generator](https://github.com/yeoman/generator-generator)
while listening to [the village people tube](https://www.youtube.com/watch?v=CS9OO0S5w2k) (if you didn't have the song in your head yet, you do now).

![Cop](https://raw.githubusercontent.com/otomatik/generator-ymca/master/village-people/cop.gif)![Worker](https://raw.githubusercontent.com/otomatik/generator-ymca/master/village-people/worker.gif)![Indian](https://raw.githubusercontent.com/otomatik/generator-ymca/master/village-people/indian.gif)![GI](https://raw.githubusercontent.com/otomatik/generator-ymca/master/village-people/gi.gif)![Leather](https://raw.githubusercontent.com/otomatik/generator-ymca/master/village-people/leather.gif)

## License
```
The MIT License (MIT)

Copyright (c) 2016 Thomas Dalous

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
