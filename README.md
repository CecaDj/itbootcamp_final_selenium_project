# itbootcamp_final_selenium_project

This repository contains a Java project for automating tests using Selenium WebDriver, Maven, and TestNG to test the web application [Vue Demo Automated Tests] (https://vue-demo.daniel-avellaneda.com/). The project follows the Page Object Model (POM) design pattern, providing a structured and maintainable framework for automating UI tests. The tests are categorized into the following sections:

- **Login Tests:** Verify user login functionality. 
- **Signup Tests:** Verify user signup functionality.
- **Admin Cities Tests:** Verify create/edit city process.
- **Auth Routes Tests:** Verify forbidden visits to pages without authentication.
- **Locale Tests:** Verify locale functionality. 

## Prerequisites

Before running the tests, ensure you have the following dependencies installed:

- Java Development Kit (JDK)
- Maven
- TestNG
- WebDriver compatible with your preferred browser (Chrome, Firefox, etc.)

## Test Reports

TestNG generates HTML reports that provide detailed information on test results. These reports can be found in the `test-output` directory.

## Page Objects

The project follows the Page Object Model (POM) design pattern. Page objects are located in the `src/main/java/pages` directory. You can extend or modify them to accommodate changes in the application.
