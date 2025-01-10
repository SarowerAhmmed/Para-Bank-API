@Smoke @Regression @Functional
Feature: Create new data with post function

  @Positive
  Scenario: as a user , can create new data
    Given Create request and add test data in json
    When send data with post method with post URL and get response
    Then check status two hundred
    And check response time below two thousand
    And check response header contain-type is application json
    And response body should not null
    And check response body contain key Name
    And check response body contain key Salary
    And check response body contain value Sarower
    And check response body contain value five thousand