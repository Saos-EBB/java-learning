# Person Management (PM)

A Java module for managing persons across multiple locations — focused on OOP design, encapsulation, custom exceptions, and Java Streams.

![Java](https://img.shields.io/badge/Java-21-orange) ![Status](https://img.shields.io/badge/Status-Tested-green) ![Type](https://img.shields.io/badge/Type-OOP%20Module-blue)

---

## About the Project

A text-based person management system written in Java.  
The main goal was to practice object-oriented design — building clean data models, separating concerns across packages, validating input through custom exceptions, and querying data with Java Streams.

---

## Features

- Multi-location management — create and manage separate PM instances per location
- Person creation — with optional gender, address, and birth date
- Name validation — first and last name checked against a regex on every set
- Stream-based search — find persons by last name with `findPersonByLastName()`
- Custom exceptions — `InvalidPersonNameException` and `ItemNotFoundException`
- Defensive data handling — null-safe setters throughout `Address`
- JUnit 5 test coverage — for person validation, PM operations, and exception handling

---

## Project Structure

```
src/
└── PM/
    ├── Management/
    │   ├── PM.java                     # Manages a list of persons per location
    │   ├── PM_Appl.java                # Multi-location management layer
    │   ├── Person.java                 # Person model with name validation
    │   ├── Address.java                # Address model with null-safe setters
    │   └── Gender.java                 # Enum: MAN, WOMAN, OTHER
    └── Exceptions/
        ├── ItemNotFoundException.java       # Thrown when a person is not found
        └── InvalidPersonNameException.java  # Thrown on invalid name input

test/
└── PM/
    ├── PersonTest.java     # Name validation tests
    ├── PMTest.java         # Create, remove, list persons
    └── PMExTest.java       # Exception handling
```

---

## Getting Started

**Requirements**
- Java 21 or higher
- JUnit 5 (for running tests)

**Compile**
```bash
javac -d out src/PM/**/*.java
```

**Run tests** (with JUnit on classpath)
```bash
java -cp out:junit.jar org.junit.platform.console.ConsoleLauncher --scan-classpath
```

---

## OOP Concepts Used

- **Encapsulation** — private fields with controlled access through getters and setters
- **Constructor delegation** — all `Person` constructors chain to one main constructor
- **Custom exceptions** — `RuntimeException` subclasses for domain-specific errors
- **Java Streams** — `filter()`, `findFirst()`, `orElseThrow()` for clean search logic
- **Enums** — `Gender` as a type-safe value
- **Collections** — `ArrayList` for persons, `HashMap` for location lookup
- **Defensive programming** — null checks and trim() throughout all setters

---

## Author Kevin SCHABERL / SAOS-EBB

Built as a learning project to practice Java OOP and clean code principles.
