#Soat Falabella automation

## Description

This repository is responsible for containing the automation of test cases of the soat project of the falabella site.

The project includes Screenshot when run Test. This files save in testOutFile Folder.

## Requirements

- Test cases will be automated with Selenium WebDriver
- The project must be of the Gradle type
- Integration with CircleCI will take place
- JUnit 5 libraries will be implemented

## Run Test
 
- Before run command please go to src/test/java/utilities/BaseConfigSelenium and change param in configCapabilities("") because by default is CI, you change this param with values: WinChrome (Chrome in Windows), MacChrome ( Chrome in Mac), WinFirefox(Firefox in Windows), MacFirefox(Firefox in Mac).
 By default run test with headless if your change this option please go to same archive written above and change this option.
- This command is used to run tests

            gradle test
            
 
## Authors

- Camila Suarez



 