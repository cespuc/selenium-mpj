# DemoWebShop Automation Framework

[![Java](https://img.shields.io/badge/Java-11+-blue)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.21.0-green)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-8.11.0-orange)](https://cucumber.io/)
[![Maven](https://img.shields.io/badge/Maven-3.9.2-red)](https://maven.apache.org/)
[![Browser](https://img.shields.io/badge/Browser-Chrome%2FFirefox%2FEdge-yellow)](#)

---

## Project Overview

This framework automates testing for [DemoWebShop](https://demowebshop.tricentis.com/) using:

- **Selenium WebDriver** for browser automation
- **Cucumber BDD** for readable feature files and step definitions
- **Java** programming language
- **Maven** for dependency management
- **JUnit** as test runner
- **WebDriverManager** for automatic browser driver management

The framework is designed to be:

- Modular (Steps, Hooks, Utilities)
- Configurable via `config.properties`
- Capable of generating **HTML & JSON reports**
- Supports **tagged execution** (e.g., `@smoke`, `@regression`)
- Runs **single browser session per test suite**

---

## Project Structure

![img.png](img.png)
├─ README.md → This documentation


---

## Prerequisites

- Java JDK 11+ installed and `JAVA_HOME` set
- Maven installed and `MAVEN_HOME` set
- Supported browsers installed: Chrome, Firefox, Edge

---

## Configuration

Edit `src/test/resources/config.properties`:

```properties
browser=chrome
baseUrl=https://demowebshop.tricentis.com/
implicitWait=10
explicitWait=10

```
- browser → chrome | firefox | edge
- baseUrl → URL of the application under test


You can override the browser from the command line:

## Running Tests
### Run from IDE
- Right-click TestRunner.java → Run as JUnit Test
### Run from Maven


#### Running Tagged Scenarios examples
+ Run only @smoke tests:
``` mvn test -Dcucumber.filter.tags="@smoke" ```
+ Run @smoke AND @critical:
  ``` mvn test -Dcucumber.filter.tags="@smoke and @critical" ```
+ Run only @smoke tests:
    ``` mvn test -Dcucumber.filter.tags="@smoke or @regression" ```
+ Run only @smoke tests:
    ``` mvn test -Dcucumber.filter.tags="not @wip" ```

## Reports
+ HTML report → target/cucumber-report.html+ 
+ JSON report → target/cucumber.json
+ Screenshots → captured automatically for failed scenarios

## Reports
#### DriverFactory
+ Creates single WebDriver instance
+ Supports Chrome, Firefox, Edge
+ Maximizes browser window

#### ConfigReader
+ Reads properties from config.properties
+ Centralizes configuration

#### Hooks
+ @BeforeAll → Browser setup
+ @After → Screenshot on failure
+ @AfterAll → Browser teardown

## Feature Files & Steps
Feature files: src/test/resources/features/*.feature

+ Step definitions: src/test/java/steps/*.java
+ Supports actions like: Click links, Enter text in input fields, Click Continue / Register buttons, 
Verify messages

## Dependencies
![img_1.png](img_1.png)--- <!-- Selenium -->
