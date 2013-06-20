Feature: Greetings
  Scenario: Users should be greeted
    Given I visit the main page
    Then I should be greeted with "Whaddup Yo!"

  Scenario: Should see list of developers
    Given I visit the main page
    Then I should see id "1", name "STEVEN"
    And I should see id "2", name "MUSA"
    And I should see id "3", name "`WOLE"

  Scenario: Should add new developer
    Given I visit the main page
    When I enter a developer name as "CHRIS"
    And I click on the "Create" button
    Then I should see id "4", name "CHRIS"

  Scenario: Should delete existing developer
    Given I visit the main page
    When I enter developer ID "1" in the Developer ID textbox
    And I click on the "Delete" button
    Then Developer with ID "1" should be deleted from the list of developers
