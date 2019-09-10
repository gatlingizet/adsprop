Feature: Test with login


  Scenario: Search after login with heisenbug
    Given browser with opened YouTube site and logined
    When enter to search bar "heisenbug"
    Then can see rows with "heisenbug" in dropdown list


  Scenario: Search by Enter with login
    Given browser with opened YouTube site
    When enter to search bar "heisenbug"
    When press Enter
    Then can see youTube Channel "Heisenbug" in the top

  Scenario: Search with bad result with login
    Given browser with opened YouTube site
    When enter to search bar "<><><><><><><><>"
    When press Enter
    Then can see page with text "No results found"
