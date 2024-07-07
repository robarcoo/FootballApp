<p align="center">
    <h1 align="center">FOOTBALLAPP</h1>
</p>
<p align="center">
	<img src="https://img.shields.io/github/languages/top/robarcoo/FootballApp?style=flat&color=0080ff" alt="repo-top-language">
<p>
<p align="center">
		<em>Developed with the software and tools below.</em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/Kotlin-7F52FF.svg?style=flat&logo=Kotlin&logoColor=white" alt="Kotlin">
	<img src="https://img.shields.io/badge/Org-77AA99.svg?style=flat&logo=Org&logoColor=white" alt="Org">
	<img src="https://img.shields.io/badge/Google-4285F4.svg?style=flat&logo=Google&logoColor=white" alt="Google">
	<img src="https://img.shields.io/badge/Android-3DDC84.svg?style=flat&logo=Android&logoColor=white" alt="Android">
	<img src="https://img.shields.io/badge/GitHub-181717.svg?style=flat&logo=GitHub&logoColor=white" alt="GitHub">
	<img src="https://img.shields.io/badge/JetBrains-000000.svg?style=flat&logo=JetBrains&logoColor=white" alt="JetBrains">
</p>
<hr>

##  Quick Links

> - [ Overview](#-overview)
> - [ Features](#-features)
> - [ Repository Structure](#-repository-structure)
> - [ Modules](#-modules)
> - [ Getting Started](#-getting-started)
>   - [ Installation](#-installation)
>   - [ Running FootballApp](#-running-FootballApp)
>   - [ Tests](#-tests)


---

##  Overview

Project I was working on during my internship, however all our team was laid off, so I'll at least post it here. I'm not going to finish it.

---

##  Features

- Fully implemented UI using Jetpack Compose that adapatable to different font and display sizes
- Almost finished work with API using Ktor
- Local caching (with different policies and expire time)
- MVVM implemented with repository pattern, corouintes, flow and usecases

UI implementation (without functionality):

https://github.com/robarcoo/FootballApp/assets/111498279/06374fa8-b677-4e3d-88ba-b65d628b9ab7

https://github.com/robarcoo/FootballApp/assets/111498279/6b52d7f8-f5e4-4042-88b0-40019d486bc2

https://github.com/robarcoo/FootballApp/assets/111498279/fa282eaa-42c6-471f-8f62-df9d7717f361

https://github.com/robarcoo/FootballApp/assets/111498279/6a07738c-dd26-43db-a973-820d6e821d78


---

##  Repository Structure

```sh
└── FootballApp/
    ├── app
    │   ├── .gitignore
    │   ├── build.gradle.kts
    │   ├── proguard-rules.pro
    │   └── src
    │       ├── androidTest
    │       │   └── java
    │       │       └── com
    │       ├── main
    │       │   ├── AndroidManifest.xml
    │       │   ├── java
    │       │   │   └── com
    │       │   └── res
    │       │       ├── drawable
    │       │       ├── font
    │       │       ├── mipmap-anydpi-v26
    │       │       ├── mipmap-hdpi
    │       │       ├── mipmap-mdpi
    │       │       ├── mipmap-xhdpi
    │       │       ├── mipmap-xxhdpi
    │       │       ├── mipmap-xxxhdpi
    │       │       ├── values
    │       │       └── xml
    │       └── test
    │           └── java
    │               └── com
    ├── build.gradle.kts
    ├── data
    │   ├── .gitignore
    │   ├── build.gradle.kts
    │   ├── consumer-rules.pro
    │   ├── proguard-rules.pro
    │   └── src
    │       ├── androidTest
    │       │   └── java
    │       │       └── com
    │       ├── main
    │       │   ├── AndroidManifest.xml
    │       │   └── java
    │       │       └── com
    │       └── test
    │           └── java
    │               └── com
    ├── domain
    │   ├── .gitignore
    │   ├── build.gradle.kts
    │   └── src
    │       └── main
    │           └── java
    │               └── com
    ├── gradle
    │   └── wrapper
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── gradle.properties
    ├── gradlew
    ├── gradlew.bat
    └── settings.gradle.kts
```

---

##  Modules
<details open><summary>App</summary>
Main module of the app, contains:
 - all configuration data 
 - dependenct injection using Koin 
 - UI using Jetpack Compose 
 - Navigation using Jetpack Navigation
 - ViewModels
</details>

<details open><summary>Data</summary>
Module that works with data, contains:
 - Repositories implementation
 - Client using Ktor
 - Local cache storing that includes different cache policies, after 5 minutes cache is automatically renewed when sending a server request. 
</details>

<details open><summary>Domain</summary>
Module that implements business logic, contains:
 - Repositories interfaces
 - Data classes 
 - Usecases
</details>

##  Getting Started

###  Installation

1. Clone the FootballApp repository:

```sh
git clone https://github.com/robarcoo/FootballApp
```

2. Change to the project directory:

```sh
cd FootballApp
```

3. Install the dependencies:

```sh
gradle build
```

###  Running FootballApp

Use the following command to run FootballApp:

```sh
java -jar build/libs/myapp.jar
```

###  Tests

To execute tests, run:

```sh
gradle test
```

