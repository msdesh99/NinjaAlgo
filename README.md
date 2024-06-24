# Automation Framework using Selenium, Cucumber, TestNG, Allure & Extent Reports, Jenkins, and JIRA

## Overview

This repository contains a robust automation framework built from scratch using Selenium WebDriver, Cucumber, TestNG, Allure for detailed test reporting, Extent Reports for comprehensive test summaries, Jenkins for continuous integration, and JIRA for Agile project management. The framework supports parallel testing and cross-browser testing to ensure thorough validation of web applications across different environments.

## Technologies Used

- **Selenium WebDriver**: Automation tool for web applications.
- **Cucumber**: Behavior-Driven Development (BDD) framework for writing acceptance tests.
- **TestNG**: Testing framework for organizing and running tests.
- **Allure**: Framework for generating detailed and interactive test reports.
- **Extent Reports**: Java-based reporting library for creating rich HTML reports.
- **Jenkins**: CI/CD tool for automating builds, tests, and deployments.
- **JIRA**: Project management tool for Agile teams, used for tracking tasks and issues.

## Features

### 1. Framework Structure
- **Page Object Model (POM)**: Modular design pattern for maintaining separate page classes.
- **Configuration Management**: Centralized configuration files for easy maintenance and scalability.
- **Utilities**: Reusable functions for actions like reading test data, handling screenshots, etc.

### 2. Test Execution
- **Cross-browser Testing**: Support for testing across multiple browsers (Chrome, Firefox, etc.) for compatibility validation.

### 3. Reporting
- **Allure Reports**: Detailed test execution reports with graphs, charts, and test history.
- **Extent Reports**: Enhanced HTML reports with screenshots and detailed logs for in-depth analysis.

### 4. Integration
- **Jenkins Integration**: Automated build and test execution triggered by commits or scheduled jobs.
- **Version Control**: Git repository for source code management and collaboration.

### 5. Agile Methodology
- **JIRA Integration**: Linking user stories and defects to test cases for traceability and visibility.
- **Feature Files**: Writing Cucumber feature files in Gherkin syntax to define acceptance criteria.

## Project Structure

```
- src/test/java
  - com.company.project
    - driverfactory
      - DriverFactory.java (Initialization of WebDriver, Configuration)
    - pages
      - LoginPage.java
      - HomePage.java
    - steps
      - LoginStep.java (Cucumber step definitions)
    - runner
      - Login.java (TestNG test cases)
    - utils
      - XLUtility.java (Utility for file operations to read TestData)
      - AllActions.java (Utility for driver action operations)
      - ConfigReader.java (Utility to read property file)
      - LoggerLoad.java (Utility for Logging the output)
  - resources
    - features
      - login.feature (Cucumber feature file)
  - config
    - config.properties (Configuration for URLs, timeouts, etc.)
- reports
  - SparkReport (Generated Extent reports)
- allure-results (Generated Allure results using Jenkins)
- target
  - surefire-reports (TestNG reports)
- pom.xml (Maven dependencies and plugins)
```

## Usage

1. **Clone the Repository**: `git clone https://github.com/msdesh99/NinjaAlgo.git`
2. **Set Up Environment**: Ensure JDK, Maven, and necessary browser drivers (ChromeDriver, GeckoDriver) are configured.
3. **Run Tests Locally**: Execute tests using `mvn clean test`.
4. **View Reports**:
   - Allure Reports: Access at `target/site/allure-maven/index.html`.
   - Extent Reports: View at `reports/SparkReport/index.html`.
5. **Integrate with Jenkins**: Set up Jenkins jobs for automated builds and test executions triggered by commits.

## Future Enhancements

- **API Testing**: Integration with RestAssured for API testing within the same framework.
- **Mobile Testing**: Extending the framework to support mobile automation using Appium.
- **Cloud Testing**: Implementing cloud-based testing solutions for scalability and parallel execution.
