# Demo Store Automation Project
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Examples](#examples)
* [References](#references)
* [Author](#author)


## General info
This Selenium Web automation project navigates to the [MADISON ISLAND](http://demo-store.seleniumacademy.com/) demo web application and performs user operations.

## Technologies
Project was created using:
* Java version: 11
* IntelliJ IDEA 2020.3
* Selenium 3.141.59
* Appium 1.17
* Maven version: 3.6.3
* JUnit version 5.6
* TestNG 6.11
* Platform OS: Windows 10


## Setup
The project requires Java JDK 8+ and Maven to be correctly installed on the system.
The application is configured with maven plugin for unit tests. 

### Unit Tests
The `maven-surefire` plugin is installed and designed to run unit tests.
To run the application unit tests from the directory with the POM file, type the following command:

```shell
mvn clean test
```

## Examples

>### Test Case 1 
>>Log in to the demo website and place an order.


The following is the sequence of steps that the test case performs:
1. Log into the [MADISON ISLAND](http://demo-store.seleniumacademy.com/) demo website.
2. Search for a Book.
3. Add a book to **Cart**
4. Proceed to **Checkout**
5. Fill in Billing Information.
6. Place Order.
7. Logout.

Project was tested using *Google Chrome* and *Mozilla Firefox* browsers and you can simply switch browsers before runtime by changing the Global variable.

**MadisonIslandWebSuite.java** file

```java 
 @BeforeEach
 public void setup() {
    SeleniumDriver driver = SeleniumDriver.getInstance();
    driver.setBrowser(Global_VARS.CHROME); //Global_VARS.FIREFOX 
}
```

Test data is extracted from **JSON** and **CSV** files.

## References
* https://maven.apache.org/surefire/maven-surefire-plugin

## Author
This project was created with ❤ by [smlungwana](https://www.linkedin.com/in/smlungwana/)  