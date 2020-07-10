Feature: check logIn functionality

  @UI
  Scenario: Verifying LogIn/LogOut functionality by UI
    Given user opens main 'URL' of Wikipedia
    When click Sign in button
    And fill in 'mail' and 'password'
    Then check logged in 'user'
    When click Sing out button
    Then check that user successfuly logged out

  @UI
  Scenario: Verifying LogIn/LogOut functionality by link
    Given user opens main 'URL' of Wikipedia
    When click Sign in button
    And fill in 'mail' and 'password'
    Then check logged in 'user'
    When log out by link
    Then check that user successfuly logged out

  @API
  Scenario: Verifying creation user functionality by API
    Given create new user with 'James' name and 'middle' job position
    Then check status code 201

  @API
  Scenario: Verifying get single user method by API
    Given get created user by 2 id
    Then check status code 200

  @API
  Scenario: Verifying update user method by API
    Given update created user by 2 id with 'Victor' name and 'singer' job
    Then check status code 200

  @API
  Scenario: Verifying delete user method by API
    Given delete created user by 2
    Then check status code 204