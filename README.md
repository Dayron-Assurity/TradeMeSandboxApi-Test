# TradeMeSandboxApi-Test

Automated test for the Trade-Me sandbox API response
 to validate a given list of acceptance criterias.


## Installation

You will need to install

```bash
  Java - At leats 1.8
  Gradle - Any above version 7
```
    
## Running Test

For each test execution, an individual html report is generated and 
aggregated at the end of the test into a single report.

To build test, run the following command.
```bash
  gradle clean
```
To run test
```bash
  gradle test
```
These commands can be run together to build and run test
```bash
  gradle clean test
```
# Report

You will be able to locate the report on the folder named report.
or the target folder created after the build. This test will also, give you the exact location of index.html file on the command line, once the report has been
built, ran and aggregated.

```bash
index.html
```


## Implementations
```bash
Java
Groovy
RestAssured
Serenity RestAssured
Junit
Logback
serenity-bdd
cucumber
```
## Future implementations
Serenity-bdd and cucumber will be implemented in the next update. This will allow
the ability to write executable specifications, run them and produce better comprehensive reports.
