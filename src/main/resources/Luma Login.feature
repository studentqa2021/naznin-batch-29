@SmokeTest
Feature: Login functionality test
@TC_01
Scenario: As LUMA application user must do login with valid credential
Given open any browser
And go to application URL
When click signin button
And put email
And put password 
And click second signin button
Then validate login was succesful