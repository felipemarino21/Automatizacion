# 2. Pruebas automatizadas (50 puntos)

To change the browser for testing please  open the global.properties file in the following directory:
//AutomatizacionExcelCredit/src/test/resources/global.properties
and replace edge for chrome


To run this test, you must have Maven installed

https://maven.apache.org/install.html


Using Maven

Open a command window in the project root folder and run:

maven clean test 

Or use this command for generating a report in Html

mvn surefire-report:report

The generated unit test report can be found in the target/site directory. The unit test report is named surefire-report.html. The path to the unit test report is thus:

your-project/target/site/surefire-report.html

