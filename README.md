[![Tests with Full Report](https://github.com/RoyalAholdDelhaize/commerce-red-testautomation/actions/workflows/scheduled.yml/badge.svg)](https://github.com/RoyalAholdDelhaize/commerce-red-testautomation/actions/workflows/scheduled.yml)

## Table of Contents
1. [Introduction](#1-introduction)
2. [Test Plan](#2-test-plan)
3. [How to run tests on local](#3-how-to-run-the-tests-on-local)
4. [View the reports](#4-view-the-reports)
5. [How to run the test in a CI/CD](#5-how-to-run-the-test-in-a-cicd-github)
6. [Test Environment and Tech Stack](#6-test-environment-and-tech-stack)

## 1. Introduction
This repository is about the E2E automated tests. It stores the smoke tests so that seeing
the AIS is good enough for the further testing. It consists of a minimal set of tests run 
on each build to test AIS functionalities. In simple terms, we are verifying whether 
the important features are working and there are no showstoppers in the build that is under testing.

## 2. Test Plan
All details about the object, approach, features to be tested and more in [Test Plan](docs/test_plan.md)

## 3. How to run the tests on local
1. Clone the repository
```
https://github.com/RoyalAholdDelhaize/commerce-red-testautomation.git
```

2. The project supports both Maven and Gradle build scripts. To run the tests with Maven, open a command window and run:
```
mvn clean verify
```

## 4. View the reports
The command provided above will produce a Serenity test report in the `target/site/serenity/index.html` directory.
After running the tests, Serenity will provide you the report link automatically. Just click!

## 5. How to run the test in a CI/CD (GitHub)
1. Follow this link below to see the workflows
```
https://github.com/RoyalAholdDelhaize/commerce-red-testautomation/actions
```


## 6. Test Environment and Tech Stack
* https://outsystems-commerce-tst.ah.nl/AIS/
* Google Chrome
* Serenity BDD is main framework 
* Cucumber 6 
* Selenium Webdriver for Java bindings
* JUnit 4 test framework
* IntelliJ IDEA for development

## Important Note
The JAVA and MAVEN must be installed and set the environment variable depends on your OS
