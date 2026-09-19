<!-- Source: Best-README-Template BLANK_README (Unlicense) — https://github.com/othneildrew/Best-README-Template -->
<a id="readme-top"></a>

# Class2021_2022_2_AndroidAppDevelopTraining

A Java Android coursework app, built with Gradle, in which a user logs in, browses a two-item menu, adds dishes to a shopping cart, and places an order across three linked activities.

**English** · [简体中文](README.zh-CN.md)

[![CI](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/actions/workflows/ci.yml/badge.svg)](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/actions/workflows/ci.yml)
[![License](https://img.shields.io/github/license/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining)](LICENSE)

[Report a bug](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/issues/new?template=bug_report.yml) · [Request a feature](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/issues/new?template=feature_request.yml)

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

## About The Project

Class2021_2022_2_AndroidAppDevelopTraining is a Java Android app built for an Android development course assignment. `MainActivity` offers login, order, takeout and account entry points, and `OrderAndShoppingActivity` hosts a two-tab menu and shopping cart backed by an in-memory dish catalog (`entity/Dishes.java`) and a small set of seeded demo accounts.

See the [open issues](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/issues) for planned features and known issues.

## Getting Started

### Prerequisites

- JDK 11
- Android SDK Platform 31 and the matching Build-Tools (`compileSdk 31` in `app/build.gradle`), for example via Android Studio
- Git

### Installation

```sh
git clone https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining.git
cd Class2021_2022_2_AndroidAppDevelopTraining
./gradlew assembleDebug
```

The Gradle wrapper (`gradlew`) pins Gradle 7.3.3 and downloads it on first run, so no separate Gradle install is required.

## Usage

Connect a device or start an emulator, then install and launch the debug build from the command line:

```sh
./gradlew installDebug
```

Or open the project in Android Studio and run the `app` configuration. Once it launches, sign in with one of the demo accounts seeded in `MyApplication` (or register a new one), then open the ordering screen to add dishes to the cart and check out.

## Contributing

Contributions are welcome. Read [CONTRIBUTING.md](CONTRIBUTING.md) for how to open an issue or a pull request, and [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) for the standards expected of everyone taking part.

Please do not report security issues in public issues or pull requests. [SECURITY.md](SECURITY.md) explains how to report them privately.

## License

Distributed under the MIT License. See [LICENSE](LICENSE) for details.

## Contact

Project link: [https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
