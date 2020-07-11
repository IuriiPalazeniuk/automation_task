# Automation test framework

**BDD automation test framework**  - logIn feature is covered by automation scripts with @UI tags, also there are four scripts which cover create, get, update and delete
user API functionality which is marked by @API tags. 

Table of contents
=================
   * [Key features](#key-features)
   * [Technologies and frameworks](#technologies-and-frameworks)
   * [Test scenario example](#test-scenario-example)
   * [Test step example](#test-step-example)   
   * [Test runner](#test-runner)
   * [Run options](#run-options)
   * [Report](#report)

## Key features
  * BDD (Cucumber framework) is used for readability and extensibility of tests
  * Tests are independent from each other, so can be run in any sequence

    
## Technologies and frameworks
 * Java programming language ([Java](https://www.java.com)) 
 * Cucumber BDD framework ([Cucumber](https://cucumber.io/docs))
 * Maven build tool ([Maven](https://maven.apache.org))

## Test scenario example

```java
 Scenario: Verifying LogIn/LogOut functionality by link
    Given user opens main 'URL' of Wikipedia
    When click Sign in button
    And fill in 'mail' and 'password'
    Then check logged in 'user'
    When log out by link
    Then check that user successfuly logged out
```

## Test step example

```java
    @And("fill in {string} and {string}")
    public void fillInCredentals(String mail, String password) {
        loginPage.fillInputFieldByName(getSystemPropertyByName(mail), getSystemPropertyByName(password));
    }
```

## Test runner

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "stepDefs",
    plugin = {"pretty", "html:target/cucumber"})
public class RunCucumberTest {

}
```

## Run options
 * Locally via IDE (To run separate scenario you need Cucumber Java plugin to be installed)
 * Maven (possible to run tests separately by @tags):
 
```bash
   'mvn clean test mvn clean test -Dcucumber.options="--tags @API"' or 'mvn clean test mvn clean test -Dcucumber.options="--tags @UI"'
   'mvn clean test' - will run all tests
   'mvn clean test Ddriver="firefox"' - will run Firefox browser (chrome by default)
```
## Report
 * Report is located in target/cucumber/index.html