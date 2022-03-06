Feature: Add-bank

  Background: 
  Given Add-BankPage
    When user logs in with_username
    And user logs in with_password
    And users clicks on login-Button
  #  Then users checks the HomePage-Title
  #  When user navigates to-bankPage
   # When user clicks on-AddBankButton

  Scenario: BHiman Homepage-navigation
Then users checks the HomePage-Title "Bhiman Admin Login page"
   When user navigates to-bankPage
   When user clicks on-AddBankButton


 When user enters bank-Form-details 
  
  | John     | Doe      | 123456789  |    Savings |  SBIN0005943  | 745451556|
      
    And Click-submit button
   And Click-Okay Button 
     
    
	