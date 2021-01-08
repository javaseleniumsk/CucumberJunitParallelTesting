@login
Feature: Login Page

Scenario: Login page title
Given user is in login page "http://automationpractice.com/index.php"
When the user captures the title of the page
Then "My Store" should be the title
@smoke
Scenario: Forgot passoword link
Given user is in login page "http://automationpractice.com/index.php"
And has clicked on signin button
Then forgot password link should be displayed

Scenario: Login with correct credentials
Given user is in login page "http://automationpractice.com/index.php"
And has clicked on signin button
When user enter username "dec2020secondbatch@gmail.com"
And enters password "Selenium@12345"
And clicks on login button
Then the user captures the title of the page
And "My account - My Store" should be the title