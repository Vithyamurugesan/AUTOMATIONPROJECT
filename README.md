AUTOMATIONPROJECT

AUTOMATIONPROJECT is a web automation testing project developed using Selenium WebDriver, Java, TestNG, and Cucumber BDD for automating the Demo Web Shop application.
The framework automates important web application functionalities such as registration, login, shopping cart operations, and catalog navigation using reusable automation components and Page Object Model design.

About the Project

Manual testing takes more time when the same test cases are executed repeatedly. This project helps reduce manual effort by automating test execution.

The framework follows industry standard automation practices such as:

* Page Object Model (POM)
* Data Driven Testing
* Cucumber BDD Framework
* Maven Dependency Management

The project is useful for:

* Learning Selenium automation
* Understanding framework design
* Practicing automation interview concepts
* Improving reusable test automation skills


Objectives of the Project

The main objectives of this project are:

* Automate web application testing
* Reduce manual testing effort
* Create reusable automation components
* Improve test execution speed
* Maintain clean project structure
* Generate reliable test results


Technologies Used

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java               | Programming language            |
| Selenium WebDriver | Browser automation              |
| TestNG             | Test execution and assertions   |
| Cucumber BDD       | Behavior Driven Development     |
| Maven              | Build and dependency management |
| Apache POI         | Excel file handling             |
| Git & GitHub       | Version control                 |


Framework Design

This project follows a layered automation framework structure.

Page Object Model (POM)

Page Object Model helps separate web elements and test logic.

Advantages:

* Better code maintenance
* Reusable methods
* Cleaner test scripts
* Easy to update locators

Cucumber BDD

Cucumber allows writing test cases in simple English using feature files.

Example:

gherkin
Scenario: Verify successful login
Given the user is on login page
When the user enters valid credentials
Then the user should login successfully


Data Driven Testing

Test data is read from Excel files using Apache POI.

Advantages:

* Reusable test data
* Easy data management
* Supports multiple test scenarios


Modules Covered

1. Registration Module

Features:

* User registration automation
* Reading user data from Excel
* Form submission validation
* Successful registration message validation

Implemented Components:

* Registration Page
* Registration Actions
* Registration Step Definitions
* Registration Feature File


2. Login Module

Features:

* Valid login testing
* Invalid login testing
* Error message validation
* Login field validation

Implemented Components:

* Login Page
* Login Actions
* Login Step Definitions
* Login Feature File


3. Shopping Cart Module

Features:

* Add products to cart
* Add multiple products using DataTable
* Verify cart items
* Validate cart functionality

Implemented Components:

* Cart Page
* Cart Actions
* Cart Step Definitions
* Cart Feature File


Implemented Components:

* Navigation Page
* Navigation Actions
* Navigation Step Definitions
* Navigation Feature File

Folder Structure

AUTOMATIONPROJECT
│
├── src/test/java
│   │
│   ├── com.actions
│   │     └── Contains reusable action classes
│   │
│   ├── com.pages
│   │     └── Contains page object classes
│   │
│   ├── com.stepdefinitions
│   │     └── Contains Cucumber step definitions
│   │
│   ├── com.runner
│   │     └── Contains Test Runner class
│   │
│   └── com.utilities
│         └── Contains utility classes
│
├── src/test/resources
│   │
│   ├── features
│   │     └── Contains feature files
│   │
│   └── testdata
│         └── Contains Excel test data
│
├── pom.xml
│     └── Maven dependencies
│
└── README.md


Utilities Used

ExcelReader
     Used for reading test data from Excel files.

ConfigReader
     Used for reading configuration values.

HelperClass
     Used for common reusable methods.


Prerequisites
Before running the project, install the following software:

* Java JDK
* Eclipse IDE or IntelliJ IDEA
* Maven
* Google Chrome Browser
* Git

Installation Steps

Step 1: Clone the Repository

bash
git clone https://github.com/Vithyamurugesan/AUTOMATIONPROJECT.git


Step 2: Open the Project

Open the project using:

Eclipse

Step 3: Update Maven Dependencies

In Eclipse:

Right Click Project → Maven → Update Project

Step 4: Install Required Plugins

Install:

* TestNG Plugin
* Cucumber Plugin


How to Execute Tests

Run Using Test Runner

Run Using Maven Command

mvn test


Test Execution Flow

1. Open browser
2. Navigate to Demo Web Shop website
3. Read test data from Excel
4. Execute test scenarios
5. Validate results
6. Generate reports

Reports and Logs

After test execution:

* Console logs will display execution details
* Passed and failed test cases can be verified
* Test reports will be generated automatically

Advantages of This Framework

* Simple and easy to understand
* Beginner friendly structure
* Reusable automation components
* Easy maintenance
* Supports Data Driven Testing
* Supports BDD framework
* Scalable project design
* Good for learning automation concepts

Future Enhancements

Future improvements can include:

* Cross browser testing
* Screenshot capture for failed tests
* Jenkins CI/CD integration
* Extent Reports integration


Learning Outcomes

This project helps understand:

* Selenium WebDriver concepts
* Automation framework design
* Cucumber BDD implementation
* TestNG execution flow
* Maven dependency management
* Excel data handling
* Git and GitHub workflow

Repository
AUTOMATIONPROJECT GitHub Repository
