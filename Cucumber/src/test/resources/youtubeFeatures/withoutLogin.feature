
Feature: YouTube Search without login
  Scenario: Search with unlogined user
    Given browser with opened YouTube site
    When enter to search bar "heisenbug"
    Then can see rows with "heisenbug" in dropdown list

  Scenario: Searching by Enter
    Given browser with opened YouTube site
    When enter to search bar "heisenbug"
    When press Enter
    Then can see youTube Channel "Heisenbug" in the top

  Scenario: Search with bad result
    Given browser with opened YouTube site
    When enter to search bar "<><><><><><><><>"
    When press Enter
    Then can see page with text "No results found"

  Scenario: Empty or space search
    Given browser with opened YouTube site
    When enter to search bar ""
    When press Enter
    When enter to search bar " "
    When press Enter
    Then can see start page

  Scenario: Try to sub to channel without login
    Given browser with opened YouTube site
    When enter to search bar "heisenbug"
    When press Enter
    When press "Subscribe " button
    Then can see Google form with login name and text "Email or phone"




