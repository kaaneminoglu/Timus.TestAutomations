Feature: Login feature

  @Test
  Scenario: UI01001.Enter valid email address & valid password
    When "berqnetfw@gmail.com" and "aB12345678.!" are entered.
    Then Verify the alert is "Welcome, berqnet"

  @Test
  Scenario: UI01002.Check email address & password credentials
    When "berqnetsfws@gmail.com" and "aB12345678.!" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."
    When "berqnetfw@gmail.com" and "aB12345678" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."
    When "berqnetfws@gmail.com" and "aB12345678" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."
    When "berqnetfws@gmail.co" and "aB12345678" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."
    When "berqnetfws@gmail.net" and "aB12345678" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."
    When "berqnetfws@gmail.asdfgh" and "aB12345678" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."
    When "berqnetfws@gmail.asdfgh" and "a" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."
    When "berqnetfws@gmail.asdfgh" and "1" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."
    When "berqnetfws@gmail.asdfgh" and "123456789012345690qwertyuıoğasdfghjklzxcvbn" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."
    When "erqnetsfws@gmail.com.com.com.com.com.com.com.com.com.com.com.com" and "aB12345678.!" are entered.
    Then Verify the alert is "Wrong credentials. Please check your email or password."

  @Test
  Scenario: UI01003.Check form errors
    When "berqnetsfws@gmail.com" and "" are entered.
    Then Verify the alert is "Please check form errors."
    Then Validation check for "password" field.
    When "berqnetfw" and "aB12345678" are entered.
    Then Verify the alert is "Please check form errors."
    Then Validation check for "email" field.
    When "berqnetfw@" and "aB12345678" are entered.
    Then Verify the alert is "Please check form errors."
    Then Validation check for "email" field.
    When "berqnetfw@." and "aB12345678" are entered.
    Then Verify the alert is "Please check form errors."
    Then Validation check for "email" field.
    When "berqnetfw@.com" and "aB12345678" are entered.
    Then Verify the alert is "Please check form errors."
    Then Validation check for "email" field.
    When "berqnetfwgmail.com" and "aB12345678" are entered.
    Then Verify the alert is "Please check form errors."
    Then Validation check for "email" field.
    When "@gmail.com" and "aB12345678" are entered.
    Then Verify the alert is "Please check form errors."
    Then Validation check for "email" field.
    When "" and "aB12345678" are entered.
    Then Verify the alert is "Please check form errors."
    Then Validation check for "email" field.