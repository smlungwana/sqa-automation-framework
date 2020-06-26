# QA Automation Assessment
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Bugs](#bugs)
* [Author](#author)


## General info
This automation project navigates to [User List Table](http://www.way2automation.com/angularjs-protractor/webtables/) and adds a new user to the table list.

## Technologies
Project was created using:
* Java version: 8
* IntelliJ IDEA 2019.3
* Selenium 3.141.59
* Maven version: 3.6.3
* JUnit version 5.6
* Platform OS: Windows 8.1

## Setup
The project requires Java and Maven to be installed on your machine. 
To run this project simply clone this git repository and open the **pom.xml** file as project.

### Example
Run the **WebSuite.java** file
```java
 @Test
 public void automationAssessment_JSON_Test() {
    Global_VARS.isJSON_Test = true;
    Reporting.createTest("QA Automation Assessment -  JSON Test"); 
 }
```

Project was tested using *Google Chrome* and *Mozilla Firefox* browsers and you can simply switch browsers before runtime by changing the Global variable.

```java
 @BeforeEach
    public void setup() {
        SeleniumDriver driver = SeleniumDriver.getInstance();
        driver.setBrowser(Global_VARS.CHROME); //Global_VARS.FIREFOX
    }
```

Test data is extracted from **JSON** and **CSV** files.


## Bugs
Customer value is not inserted on [User List Table](http://www.way2automation.com/angularjs-protractor/webtables/) after clicking **Save**

## Author
This project was created by [smlungwana](https://www.linkedin.com/in/smlungwana/)  