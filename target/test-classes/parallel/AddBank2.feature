Feature: Add bank

  Background: 

  Scenario: BHiman Homepage navigation
    Given Add BankPage
    When user logs in with username
    And user logs in with password
    And users clicks on login Button
    Then users checks the HomePage Title
    When user navigates to bankPage
    When user clicks on AddBankButton
		When user fills the Bank form from given sheetname "<SheetName>" and rownumber <RowNumber>
Examples:
|SheetName|RowNumber|
|addbank	|0|
|addbank	|1|




