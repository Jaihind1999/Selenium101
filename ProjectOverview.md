# LambdaTest Automation Framework Overview

This is a Selenium-based test automation framework designed to run tests on LambdaTest platform. The framework is built using Java with TestNG and follows the Page Object Model (POM) design pattern.

## Tech Stack
- Java 8
- Selenium WebDriver 4.29.0
- TestNG 7.10.2
- Maven
- Lombok
- Extent Reports

## Project Structure

```
LambdaTestFramework/
├── src/
│   └── test/
│       ├── java/
│       │   ├── pageObjects/          # Page Object classes
│       │   │   ├── BasePage.java     # Base page with common methods
│       │   │   ├── HomePage.java     # Home page elements and methods
│       │   │   ├── InputFormPage.java
│       │   │   ├── SimpleFormDemoPage.java
│       │   │   └── SliderPage.java
│       │   ├── testBase/
│       │   │   └── BaseClass.java    # Test initialization and configuration
│       │   ├── testCases/
│       │   │   ├── Scenario1.java
│       │   │   ├── Scenario2.java
│       │   │   └── Scenario3.java
│       │   └── utilities/
│       │       └── ExtentReportsUtility.java
├── logs/                             # Test execution logs
├── reports/                          # Extent Reports output
├── testData/                         # Test data files
├── pom.xml                           # Maven configuration
├── testOnLambdaTest.xml             # TestNG configuration
└── parallelTest.xml                  # Parallel execution configuration
```

## Key Components

1. **Page Objects (`pageObjects/`)**
   - Contains classes representing web pages
   - Each page class contains element locators and methods to interact with the page
   - `BasePage.java` provides common functionality for all pages

2. **Test Cases (`testCases/`)**
   - `Scenario1.java`, `Scenario2.java`, `Scenario3.java` contain actual test cases
   - Tests are written using TestNG framework
   - Each scenario tests different functionality of the application

3. **Base Class (`testBase/BaseClass.java`)**
   - Handles test setup and teardown
   - Manages driver initialization
   - Contains common test configurations

4. **Utilities (`utilities/`)**
   - `ExtentReportsUtility.java` - Handles test reporting
   - Generates detailed HTML reports for test execution

## Running Tests

1. **Single Test Execution**
   ```bash
   mvn test -DsuiteXmlFile=testOnLambdaTest.xml
   ```

2. **Parallel Test Execution**
   ```bash
   mvn test -DsuiteXmlFile=parallelTest.xml
   ```

## Reports and Logs
- Test reports are generated in the `reports/` directory
- Execution logs are stored in the `logs/` directory
- Reports include detailed test steps, screenshots, and execution status

## Best Practices
1. Follow Page Object Model pattern
2. Use meaningful names for methods and variables
3. Keep test data separate from test code
4. Maintain proper documentation
5. Use TestNG annotations appropriately
6. Implement proper logging and reporting

This framework is designed to be scalable, maintainable, and easy to understand. It follows industry best practices and can be extended based on project requirements.
