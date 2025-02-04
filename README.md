# Roadsurfer Booking Automation

Automated Testing of the Roadsurfer Booking System using Selenium, TestNG, and Allure for reporting.

---

## Project Overview

This project automates the testing of the Roadsurfer booking system to ensure that the booking flow is working as expected. Key functionalities include:
- Accepting cookies on the homepage.
- Selecting pickup and drop-off locations.
- Choosing start and end dates for the booking.
- Verifying camper search results.

## Technology Stack
- **Java**: Programming language for test implementation.
- **TestNG**: Test framework for structuring and executing tests.
- **Maven**: Build tool for dependency management and test execution.

---

## 🏁 Folder Structure

```plaintext
roadsurfer-hometest/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/
│   │   │   │   └── BookingPage.java          # Page object for the booking page
│   │   │   ├── resources/
│   │   │   │   ├── Constants.java            # Constants used in the project (e.g., URLs)
│   │   │   │   └── Language.java             # Language-related data and hardcoded texts
│   │   │   └── steps/
│   │   │       └── BookingSteps.java         # BDD steps for the booking process
│   │   └── resources/
│   │       └── allure.properties             # Allure reporting configuration
│   │
│   └── test/
│       ├── java/
│       │   ├── utils/
│       │   │   └── BaseTest.java             # Base test class for common setup/teardown
│       │   └── BookingTest.java              # Test runner for executing the tests
│       └── resources/
│           └── allure.properties             # Allure configuration for test reports
│
├── pom.xml                                  # Maven build file
└── README.md                                # Project documentation
```

---

## 💻 Installation

### Prerequisites

To get started, ensure you have the following installed:
- **Java 21** or later
- **Maven 3.8.1** or later
- **Selenium WebDriver**
- **TestNG**
- **Allure** for generating test reports

### Steps to Install

1. Clone the repository:
    ```bash
    git clone https://github.com/your-repository/roadsurfer-hometest.git
    ```

2. Navigate to the project directory:
    ```bash
    cd roadsurfer-hometest
    ```

3. Install the project dependencies using Maven:
    ```bash
    mvn clean install
    ```
---

## ▶️ Running the Tests

Once you have installed the project, you can run the tests using Maven.

1. Execute the tests:
    ```bash
    mvn test
    ```

2. To generate Allure reports:
    ```bash
    allure serve target/allure-results
    ```

This command will launch the Allure report in your default web browser for easy viewing.

---