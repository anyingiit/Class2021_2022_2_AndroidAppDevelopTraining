[English](README.md) · **简体中文**

> 英文版是规范版本。本页与 [README.md](README.md) 不一致时，以英文版为准。

<!-- translation-of: README.md sha256:bae8f591beb158ce -->

<!-- Source: Best-README-Template BLANK_README (Unlicense) — https://github.com/othneildrew/Best-README-Template -->
<a id="readme-top"></a>

# Class2021_2022_2_AndroidAppDevelopTraining

一个用 Java 编写、以 Gradle 构建的 Android 课程作业应用：用户登录后可以浏览一个包含两道菜的菜单，把菜品加入购物车，并在三个互相关联的界面之间下单。

[![CI](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/actions/workflows/ci.yml/badge.svg)](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/actions/workflows/ci.yml)
[![License](https://img.shields.io/github/license/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining)](LICENSE)

[报告问题](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/issues/new?template=bug_report.yml) · [提出需求](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/issues/new?template=feature_request.yml)

<details>
  <summary>目录</summary>
  <ol>
    <li><a href="#about-the-project">关于本项目</a></li>
    <li><a href="#getting-started">开始使用</a></li>
    <li><a href="#usage">用法</a></li>
    <li><a href="#contributing">参与贡献</a></li>
    <li><a href="#license">许可证</a></li>
    <li><a href="#contact">联系方式</a></li>
  </ol>
</details>

## 关于本项目

Class2021_2022_2_AndroidAppDevelopTraining 是一门 Android 开发课程的 Java 课程作业应用。`MainActivity` 提供登录、点餐、外卖和个人中心的入口，`OrderAndShoppingActivity` 则承载一个两个标签页的点餐与购物车界面，其数据来自内存中的菜品目录（`entity/Dishes.java`）以及少量预置的演示账号。

计划中的功能与已知问题，见 [open issues](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining/issues)。

## 开始使用

### 环境要求

- JDK 11
- Android SDK Platform 31 及对应的 Build-Tools（`app/build.gradle` 中的 `compileSdk 31`），例如通过 Android Studio 安装
- Git

### 安装

```sh
git clone https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining.git
cd Class2021_2022_2_AndroidAppDevelopTraining
./gradlew assembleDebug
```

Gradle 包装脚本（`gradlew`）已固定使用 Gradle 7.3.3，并会在首次运行时自动下载，无需单独安装 Gradle。

## 用法

连接一台设备或启动一个模拟器，然后通过命令行安装并启动调试版本：

```sh
./gradlew installDebug
```

也可以在 Android Studio 中打开本项目并运行 `app` 配置。应用启动后，先用 `MyApplication` 中预置的某个演示账号登录（或注册一个新账号），再进入点餐界面把菜品加入购物车并下单。

## 参与贡献

欢迎参与。[CONTRIBUTING.md](CONTRIBUTING.md) 说明如何提交 issue 或 pull request，[CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) 说明对所有参与者的行为要求。

请不要在公开的 issue 或 pull request 中报告安全问题。[SECURITY.md](SECURITY.md) 说明了私下报告的方式。

## 许可证

以 MIT 许可证分发。详见 [LICENSE](LICENSE)。

## 联系方式

项目地址：[https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining](https://github.com/anyingiit/Class2021_2022_2_AndroidAppDevelopTraining)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
