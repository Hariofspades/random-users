# Random Users (random-users)
Android app, to implement Random Users API from [RandomUsers](https://randomuser.me/)

# How to setup
1. Just clone or download
2. configure minSDK, compileSDK and targetSDK based on your setup 
3. create a file `appconfig.properties` under root folder and add your 
[RandomUsers](https://randomuser.me/) endpoint. Look up for `appconfig.properties.sample`
file for syntax and example.
4. Run, should be fine.

# ScreenShots
Mobile Screenshots
<p align="center">
<img src="https://github.com/Hariofspades/random-users/blob/master/art/app_screenshot_1.png" alt="Drawing" style="width: 10px;"/>
</p>
<p align="center">
<img src="https://github.com/Hariofspades/random-users/blob/master/art/app_screenshot_2.png" alt="Drawing" style="width: 10px;"/>
</p>
Tablet screenshot
<p align="center">
<img src="https://github.com/Hariofspades/random-users/blob/master/art/tablet_screenshot.png" alt="Drawing" style="width: 10px;"/>

# Architecture
1. The app uses an Architecture, inspired from clean architecture.
2. Layers - `app`(UI) - `domain` - `data` - `remote`, `storage`
3. `data` layer is the single source of truth.
4. Few unit test and instrumentation tests are written for each layer

# Language, tools and libraries
* [Kotlin](https://kotlinlang.org/)
* [kodein](http://kodein.org)
* Android Support Libraries
* [RxJava2](https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0)
* [Glide](https://github.com/bumptech/glide)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Gson](https://github.com/google/gson)
* [Timber](https://github.com/JakeWharton/timber)
* [mockito](https://github.com/nhaarman/mockito-kotlin)



