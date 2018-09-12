Feature: Open firefox browser and go to google.com

  @firefoxx
  Scenario: open firefox and go to google
    Given when i open firefox
    When i navigate to google
    Then i see the page
