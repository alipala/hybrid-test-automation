## Table of Contents
1. [Test Plan Introduction](#1-test-plan-introduction)
2. [Test Objects](#2-test-objects)
3. [Tested Features](#3-tested-features)
4. [Test Type](#4-test-type)
5. [Test Objectives](#5-test-objectives)
6. [Test Model](#6-test-model)

## 1. Test Plan Introduction
This test plan describes required test activities

## 2. Test Objects
[AIS](https://outsystems-commerce-tst.ah.nl/AIS/) is a web application that handles item changes as published by suppliers.
This test suite is related critical functionalities, pages and page elements.

## 3. Tested Features
It can be tracked the tested feature via the link below.
[Find Tests via Link](https://jira-eu-aholddelhaize.atlassian.net/projects/CRFC?selectedItem=com.thed.zephyr.je__test-cases) OR
[Search Tests with Filter](https://jira-eu-aholddelhaize.atlassian.net/issues/?jql=project%3DCRFC%20AND%20issueType%3DTEST%20AND%20assignee%20in%20(61ae23f0fe9f300068f52255)%20ORDER%20BY%20created%20DESC)

> ![Tests](https://github.com/RoyalAholdDelhaize/commerce-red-testautomation/blob/master/docs/test_cases.png?raw=true)


## 4. Test Type
It is a functional UI testing which each feature is tested as E2E. There is no dependency between tests!

## 5. Test Objectives
To verify the requirements which I specified in the "Tested Feautures" have been fulfilled.
Also to validate whether test object works as the user expects.

# 6. Test Model
The functional tests in this project follow "Arrange-Act-Assert" model:

* Arrange, or set up: Pre conditions for the test
* Act: Calling controller functions or methods
* Assert: Verify that conditions are true