# TrustedShopsTask

The challenge for the current task is to generate automated tests for the following 5 different test scenarios and perform the necessary assertions:
1. Check if the page title exists
2. Check if the grade is visible and is above zero (e.g. 4.81/5.00)
3. Check if the “Wie berechnet sich die Note?” link opens the window with
   additional information and check if the provided information is relevant
4. Click on "2 Stars" to filter all "two stars" reviews - ensure that every review in
   the entire list has only two stars
5. Create the sum of all star percentage values. The sum must be equal or below


### How to Execute the Test

* The setups at the bottom of the page are followed to run the project.
* The dependencies in the Maven pom.xml file are checked.
* Related test cases are accessed from TestChrome.xml file. 
* TestFirefox.xml file can be run to test cases in Firefox browser. TestEdge.xml file can be run to test cases in Edge browser. TestChrome.xml file can be run to test cases in Chrome browser.
* The test run starts by running the selected xml file.
*  The relevant test cases start the running in sequential or parallel with the start of the selected xml file(TestChrome.xml).
* The result of the test running could be accessed from the console or from the TrustedShopsTask\target\surefire-reports\emailable-report.html(for .html report the project must be run as maven).
* In addition, the attached screenshots can be examined to run the project.

## Getting Your Development Environment Setup
### Recommended Versions
| Recommended             | Reference                                           |
|-------------------------|-----------------------------------------------------|
| Oracle Java 11 JDK      | [Download](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
| Selenium                | [Download](https://www.selenium.dev/)               |
| TestNG                  | [Download](https://testng.org/doc/download.html)    |
| IntelliJ 2018 or higher | [Download](https://www.jetbrains.com/idea/download/)|
| Maven 3.6.0 or higher   | [Download](https://maven.apache.org/download.cgi)   |
| Git 2.40.1              | [Download](https://git-scm.com/downloads)           |



