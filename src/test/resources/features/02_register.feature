Feature: Register feature

  Background:
    Given Click create account button.

  @Test
  Scenario: UI02001.Create an account
    When Mandatory fields are filled.
    When Accept "Privacy Policy".
    When Accept "Terms of Service".
    When Click continue button
    Then Check create account

  @Test
  Scenario: UI02002.Check required fields to create an account
    When Name "", surname "", email address "" fields are filled in and country "" is selected.
    When Click continue button
    Then Verify the alert is "Please fill in the required fields and confirm the agreements to create an account."
    Then Register page "true" validation check for "firstname" field.
    Then Register page "true" validation check for "lastname" field.
    Then Register page "true" validation check for "email" field.
    Then Register page "true" validation check for "country" field.
    When Name "TestName", surname "", email address "" fields are filled in and country "" is selected.
    When Click continue button
    Then Verify the alert is "Please fill in the required fields and confirm the agreements to create an account."
    Then Register page "false" validation check for "firstname" field.
    Then Register page "true" validation check for "lastname" field.
    Then Register page "true" validation check for "email" field.
    Then Register page "true" validation check for "country" field.
    When Name "TestName", surname "TestLastName", email address "" fields are filled in and country "" is selected.
    When Click continue button
    Then Verify the alert is "Please fill in the required fields and confirm the agreements to create an account."
    Then Register page "false" validation check for "firstname" field.
    Then Register page "false" validation check for "lastname" field.
    Then Register page "true" validation check for "email" field.
    Then Register page "true" validation check for "country" field.
    When Name "TestName", surname "TestLastName", email address "mail@gmail.com" fields are filled in and country "" is selected.
    When Click continue button
    Then Verify the alert is "Please fill in the required fields and confirm the agreements to create an account."
    Then Register page "false" validation check for "firstname" field.
    Then Register page "false" validation check for "lastname" field.
    Then Register page "false" validation check for "email" field.
    Then Register page "true" validation check for "country" field.
    When Name "TestName", surname "TestLastName", email address "mail@gmail.com" fields are filled in and country "Turkey" is selected.
    When Click continue button
    Then Verify the alert is "Please confirm the agreements to create an account."
    Then Register page "false" validation check for "firstname" field.
    Then Register page "false" validation check for "lastname" field.
    Then Register page "false" validation check for "email" field.
    Then Register page "false" validation check for "country" field.

  @Test
  Scenario: UI02003.Check valid email address to create an account
    When Name "TestName", surname "TestLastName", email address "mail" fields are filled in and country "Turkey" is selected.
    When Accept "Privacy Policy".
    When Accept "Terms of Service".
    When Click continue button
    Then Verify the alert is "Please enter a valid Email Address."
