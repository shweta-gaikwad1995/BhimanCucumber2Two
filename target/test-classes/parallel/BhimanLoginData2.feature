Feature: LoginData Feature

Scenario Outline: Login with different_set of data
Given user navigates  Login Page
When user fills the Login_form from given sheetname "<SheetName>" and rownumber <RowNumber>
Examples:
|SheetName|RowNumber|
|addbank|0|
|addbank|1|
