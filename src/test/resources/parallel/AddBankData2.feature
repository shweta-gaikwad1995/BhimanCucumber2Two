Feature: Add_Bank Alert_Messages

Background:
Given  User is on_Login_Page
When User Enters__Username
And User Enters--Password
And User Clicks on__Login-Button


Scenario: Home-_Page
Given User is on_Home-Page
Then User_Verifies the Home-Page Title 
When User_Mouse-Howers on Masters-Tab & click-on-BanksLink
Then User_is Navigated to BanksPage Verify title "Banks"
Then User_is Navigated to AddBanks Page
When user_enters Bank-Name "123456"
But Alert-Message_is "Please Enter Proper Bank Name" displayed








