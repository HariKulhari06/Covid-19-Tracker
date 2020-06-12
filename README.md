
<p align="center">
    <a>
    <img src="app/src/main/ic_launcher-playstore.png" width="200" height="200"/>
    </a>
    <h1 align="center">COVID-19 Tracker</h1>
</p>

[![GitHub license](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
![Github Followers](https://img.shields.io/github/followers/HariKulhari06?label=Follow&style=social)
![GitHub stars](https://img.shields.io/github/stars/HariKulhari06/Covid-19-Tracker?style=social)
![GitHub forks](https://img.shields.io/github/forks/HariKulhari06/Covid-19-Tracker?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/HariKulhari06/Covid-19-Tracker?style=social)
![GitHub Issues](https://img.shields.io/github/issues/HariKulhari06/Covid-19-Tracker?style=social)

## ✨ Screenshots
| Main Screen | Statistics |  Preventions |
|:-:|:-:|:-:|
| ![Fist](media/screen_1.png?raw=true) | ![3](media/screen_2.png?raw=true) | ![3](media/screen_3.png?raw=true) |
| Main Screen Dark | Statistics Dark |  FAQ |
| ![4](media/screen_dark_1.png?raw=true) | ![5](media/screen_dark_2.png?raw=true) | ![6](media/screen_dark_3.png?raw=true) |

## 🌟 About
It simply loads data from API and stores it in persistence storage (i.e. SQLite Database). Data will be always loaded from local database. Remote data (from API) and Local data is always synchronized.
- This makes it offline capable 😃. 
- Clean and Simple Material UI.
- It supports dark theme too 🌗.

## 🚀 Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
*   Android Studio 3.2+
*   Java JDK

### Installing
Follow these steps if you want to get a local copy of the project on your machine.

#### 1. Clone or fork the repository by running the command below	
```
git https://github.com/HariKulhari06/Covid-19-Tracker
```

#### 2. Import the project in AndroidStudio, and add API Key
1.  In Android Studio, go to File -> New -> Import project
2.  Follew the dialog wizard to choose the folder where you cloned the project and click on open.
3.  Android Studio imports the projects and builds it for you


## 🤝 How to Contribute
1.  Fork it
2.  Create your feature branch (git checkout -b my-new-feature)
3.  Commit your changes (git commit -am 'Add some feature')
4.  Push to the branch (git push origin my-new-feature)
5.  Create new Pull Request

## 📃 Libraries used
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Jetpack Dependency Injection Framework
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
  - [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager) - WorkManager is an API that makes it easy to schedule deferrable, asynchronous tasks that are expected to run even if the app exits or the device restarts.
- [Dagger 2](https://dagger.dev/) - Dependency Injection Framework
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Coil-kt](https://coil-kt.github.io/coil/) - An image loading library for Android backed by Kotlin Coroutines.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.

## 📝 License
This project is released under the MIT license.
See [LICENSE](./LICENSE) for details.

```
MIT License

Copyright (c) 2020 Hari Choudhary

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
