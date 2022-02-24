
Feature: AddBank_Details

Background:
   Given User is on_LoginPage
    When User EntersUsername
    And User EntersPassword
    When User Clicks_Login_Button
    Then User Verifies_the LoginPage title


    
    Scenario: HomePage
    Given User is Navigated_HomePage
    When User MOuse howers on Masters_Tab and click on_BanksLink
  And User Clicks_AddBankButton
  Then User is navigated to_AddBankPage
 Then User Verifies the AddBank_Title 
    
    Scenario: AddBankPage
    Given User is on_AddBankPage
    
  
   
    
    
    