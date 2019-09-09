Feature: YouTube login

  Scenario: Login to youtube with incorrect credentials
    When browser with opened YouTube site
    When click to login button
    Then can see google form with login name and text "Email or phone"

