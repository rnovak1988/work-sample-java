# Work Sample Project - Java

This project is intended to give us insight into your abilities.
This project should work for both Software Developers and for
the Software Developer in Test Roles, please find information
below as to what is expected for each role.

- [Getting Started](#getting-started)
    - [Task - Software Developer](#task-software-developer)
    - [Task - Software Developer in Test](#task-software-developer-in-test)
- [Documentation](#documentation)
- [License](#license)
- [Author](#author)

## Introduction

Please see [Apache Maven](https://maven.apache.org/) for an introduction to Apache Maven 
or [Oracle Java](https://java.com/en/) for an introduction to Java.

## Getting Started

The java class `WorkSample` is the main entry point into the application. Execution (as well as running of tests) is accomplished
by building the project and running

```bash
mvn clean install
java -jar target/work-sample.jar
```

Within this class is an implementation to a **naive** solution to the problem as described [here](https://www.hackerrank.com/challenges/angry-professor). All
of the code is isolated to this class as-is (which is obviously not ideal, there are no abstractions).

### Task - Software Developer
Your task, as a developer, is to move the logic actually related to the solution out of the main class
and into a separate class, and to write unit tests associated with that new class

### Task - Software Developer in Test
Your task is to develop a set of unit/integration tests for the `WorkSample` class, using JUnit (or whatever test-harness you prefer). 
Naive test cases (that only test against the sample output from the problem description) exist as-is.

## Documentation

Please see the original [problem description](https://www.hackerrank.com/challenges/angry-professor) for more information 
regarding the actual problem. (They have an editorial section for logged in users that explains an optimal solution).


## License

This project is licensed under the [Apache 2.0 License](/LICENSE)

## Author

This project was written by [Robert Novak](mailto:robertn@ccbill.com)
