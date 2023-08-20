Feature: Verify logout functionality
Scenario: logout
Given registered user logged in to salesforce
When user click the logout link
Then user should be redirected to the login page