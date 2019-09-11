
Feature: Test with login

  Scenario: Search after login with heisenbug
    Given browser with opened YouTube and logined
    Then can see login image
    When enter to search bar "heisenbug"
    Then can see rows with "heisenbug" in dropdown list


  Scenario: Search by Enter with login
    Given browser with opened YouTube and logined
    When enter to search bar "heisenbug"
    When press Enter
    Then can see youTube Channel "Heisenbug" in the top

  Scenario: Search with bad result with login
    Given browser with opened YouTube and logined
    When enter to search bar "<><><><><><><><>"
    When press Enter
    Then can see page with text "No results found"

  Scenario: Empty or space search
    Given browser with opened YouTube and logined
    When enter to search bar ""
    When press Enter
    When enter to search bar " "
    When press Enter
    Then can see start page
  @ss
  Scenario: browser with opened YouTube and logined
    Given browser with opened YouTube and logined
    When enter to search bar "heisenbug"
    When press Enter
    When press "Subscribe " button as logined user
    Then Button should change name to "Subscribed"
    When press this button again
    Then can see button with "Subscribe"
