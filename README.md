# Demo Store Automation Project
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Examples](#examples)
* [Author](#author)


## General info
This Selenium Web automation project navigates to [MADISON ISLAND](http://demo-store.seleniumacademy.com/) demo store to buy a product.

## Technologies
Project was created using:
* Java version: 11
* IntelliJ IDEA 2019.3
* Selenium 3.141.59
* Appium 1.17
* Maven version: 3.6.3
* JUnit version 5.6
* TestNG 6.11
* Platform OS: Windows 10


## Setup
The project requires Java and Maven to be installed on your machine. 
To run this project simply clone this git repository and open the **pom.xml** file as project.

## Examples

>### Test Case 1 
>>Log in to the demo website and place an order.


The following is the sequence of steps that the test case perfoms:
1. Log into the [MADISON ISLAND](http://demo-store.seleniumacademy.com/) demo website.
2. Search for a Book.
3. Add a book to **Cart**
4. Proceed to **Checkout**
5. Fill in Billing Information.
6. Place Order.
7. Logout.

Run the **DemoStoreSuite.java** file
```java 
 @Test
 public void placeOrderTest() {
    String book = "Alice"; 
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

## Author
This project was created by [smlungwana](https://www.linkedin.com/in/smlungwana/)  