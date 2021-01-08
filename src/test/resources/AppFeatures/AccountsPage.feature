@account
Feature: Accounts feature
Background:
Given the user is logged into the application "http://automationpractice.com/index.php"
|username|password|
|dec2020secondbatch@gmail.com|Selenium@12345|

@smoke
Scenario: verify the logout button
Given user is in accounts page
#Then verify signout button is displayed


Scenario: verify the tabs in Account page
Given user is in accounts page
Then user gets the account tabs
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And Account section should have <5> tabs