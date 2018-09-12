Feature: Open chrome browser and go to google.com

  @chromee
  Scenario: open chrome and go to google
    Given when i open chrome
    When i navigate to google
    Then i see the page
