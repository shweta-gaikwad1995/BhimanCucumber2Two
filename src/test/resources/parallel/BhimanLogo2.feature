Feature: Bhiman Login_Scanerio

Background:
Given user is on Bhiman BhimanApplication
When user enters_username 

Scenario: Bhiman Page_Details Valid Credentials
And user entesr_password
And user clicks on_loginButton

Scenario: Bhiman Page_Invalid_Credentials
But user enters Invalid_password
And user clicks on_loginButton

