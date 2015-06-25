Feature: Home Page

  Scenario: Should allow users to see their friend's photo
    Given I am logged in as "Nini"
    When I am on the home page
    Then I should see my friend's "shared photo"

  Scenario: Should allow users to see their friend's status
    Given I am logged in as "Nini"
    When I am on the home page
    Then I should see my friend's "posted status"