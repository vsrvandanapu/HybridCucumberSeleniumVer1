Feature: Verify Login functionality
Scenario Outline: Login with valid credentials
Given: user navigates to login page
When user enters valid email address <username> into username filed
And user enters valid password <password> into password filed
And clicks on Login button
Then user should login successfully
Examples:
|username									|password			|
|srinivas@cisolutions.com	|Selenium@1		|
|srinivas@cisolutions.com	|Selenium@1		|
|srinivas@cisolutions.com	|Selenium@1		|

Scenario: Login with invalid credentials
Given: user navigates to login page
When user enters invalid email address "srinivas99@cisolutions.com" into username filed
And user enters invalid password "adsum@1" into password filed
And clicks on Login button
Then user should get a proper warning message about credentials

Scenario: Login with valid email and invalid password
Given: user navigates to login page
When user enters valid email address "srinivas@cisolutions.com" into username filed
And user enters invalid password "adsum@1" into password filed
And clicks on Login button
Then user should get a proper warning message about credentials

Scenario: Login with invalid email and valid password
Given: user navigates to login page
When user enters invalid email address "srinivas99@cisolutions.com" into username filed
And user enters valid password "Selenium@1" into password filed
And clicks on Login button
Then user should get a proper warning message about credentials