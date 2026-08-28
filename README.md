# Selenium TestNG Automation Framework

A scalable **Web UI Automation Framework** built using **Selenium WebDriver, Java, TestNG, Maven, and Page Object Model (POM)**.

This framework demonstrates a maintainable and reusable approach to automating web applications with structured test execution, reusable utilities, test data management, screenshots, and reporting.

---

## 🚀 Tech Stack

| Technology             | Purpose                       |
| ---------------------- | ----------------------------- |
| **Java**               | Programming Language          |
| **Selenium WebDriver** | Web UI Automation             |
| **TestNG**             | Test Execution & Assertions   |
| **Maven**              | Dependency & Build Management |
| **Page Object Model**  | Framework Design Pattern      |
| **Extent Reports**     | Test Reporting                |
| **Apache POI**         | Excel-based Test Data         |
| **Git & GitHub**       | Version Control               |

---

## ✨ Framework Features

* Page Object Model (POM) design
* Reusable page classes and utility methods
* Selenium WebDriver-based UI automation
* TestNG test execution
* Data-driven testing using Excel
* Cross-browser execution support
* Screenshot capture during test execution
* Extent HTML reports
* Maven-based project structure
* TestNG XML suite execution
* Centralized configuration and reusable components
* Organized test data, reports, and screenshots

---

## 📁 Project Structure

```text
Selenium-TestNG-Framework
│
├── src
│   ├── main
│   │   └── java
│   │       ├── pages
│   │       └── utilities
│   │
│   └── test
│       ├── java
│       │   ├── tests
│       │   └── testData
│       │
│       └── resources
│
├── reports
│   └── Extent Reports
│
├── screenshots
│   └── Test execution screenshots
│
├── test-output
│   └── TestNG reports
│
├── pom.xml
├── testng.xml
└── README.md
```

> The exact package structure may vary as the framework evolves.

---

## 🏗️ Framework Architecture

The framework follows the **Page Object Model (POM)** approach.

```text
                TestNG Test Classes
                        │
                        ▼
                Page Object Classes
                        │
                        ▼
                 Selenium WebDriver
                        │
                        ▼
                  Web Application
                        │
                        ▼
              Reports / Screenshots
```
---

### Page Object Model

Each application page is represented by a dedicated Java class containing:

* Web element locators
* Page-specific actions
* Reusable methods

This keeps test classes focused on **test scenarios rather than implementation details**, making the framework easier to maintain.

---

## 🧪 Test Execution

### Run using Maven

Clone the repository:

```bash
git clone https://github.com/harshashanamshet/Selenium-TestNG-Framework.git
```

Navigate to the project:

```bash
cd Selenium-TestNG-Framework
```

Run the test suite:

```bash
mvn test
```

---

### Run using TestNG XML

The framework also supports execution through `testng.xml`.

From an IDE such as Eclipse or IntelliJ:

```text
Right Click → testng.xml → Run As → TestNG Suite
```

---

## 📊 Reporting

The framework generates test execution reports to help analyze:

* Passed tests
* Failed tests
* Skipped tests
* Execution details
* Screenshots for debugging

Reports are generated under:

```text
reports/
test-output/
```
---

## 📸 Screenshots

Screenshots are captured during test execution and stored under:

```text
screenshots/
```

They can be used to investigate failed scenarios and understand the application state at the time of failure.

---

## 🛠️ Prerequisites

Make sure the following are installed:

* Java JDK
* Maven
* Git
* Chrome / Firefox / Edge
* Eclipse or IntelliJ IDEA

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

## 🔮 Future Enhancements

The framework can be further extended with:

* Jenkins CI/CD integration
* Parallel execution
* Docker/Grid execution
* API automation integration
* Allure reporting
* Retry mechanism
* Environment-specific configuration
* Cloud execution using Selenium Grid providers

---

## 🎯 What This Project Demonstrates

This project demonstrates practical experience in building a maintainable Selenium automation framework rather than simply writing individual Selenium scripts.

Key concepts demonstrated:

**Selenium WebDriver • Java • TestNG • Maven • POM • Data-Driven Testing • Reusable Utilities • Reporting • Screenshot Capture • Test Automation Architecture**

---

## 👨‍💻 Author

**Harsha Hanamshet**

QA Automation Engineer | Selenium | Java | TestNG | Playwright


---

⭐ If you find this project useful, feel free to star the repository.
