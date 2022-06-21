# AutomationProject
> Java quickstart project for test automation which covers UI testing, DB Testig and API Testing.

## Concepts Included
```
- Page Object Pattern
- Dependency injection
- Cucumber step definitions
- Parallel test runs
- Common web page interaction methods
- Commonly used test utilities classes
- API interaction methods
```

## Requirments
- Java 11
- Chrome driver, Firefox driver, Explorer driver (UI tests use Firefox by default, can be changed in the console)
- maven 3.8.0

## Built With
> Java, Maven, TestNG, Cucumber, Selenium, Rest Assured, SQL

## Sample Execution From IDE Console
> mvn test -Dbrowser="chrome" \
> mvn test -> default is firefox \
> you can run as "chrome", "chromeheeadless", "explorer" and "firefox" 

## Sample Output
[INFO] Tests run: 22, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 47.496 s - in TestSuite \
[INFO] \
[INFO] Results:\
[INFO] \
[INFO] Tests run: 22, Failures: 0, Errors: 0, Skipped: 0\
[INFO] \
[INFO] ------------------------------------------------------------------------\
[INFO] BUILD SUCCESS\
[INFO] ------------------------------------------------------------------------\
[INFO] Total time:  53.954 s\
[INFO] Finished at: 2022-06-20T17:19:07-04:00\
[INFO] ------------------------------------------------------------------------

## Reporting
Report is in the **/target/surefire-reports** directory after a successful run.\
Logs are also in **/logs** directory

## Author
[@TimurCelik](https://www.linkedin.com/in/timurcelik/)
