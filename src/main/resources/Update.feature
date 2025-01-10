@Smoke @Regression @Functional
Feature: Update new data with put function

  @Positive
  Scenario: as a user , can Update old data
    Given Create request and add test data in json
    When send data with put method with put URL and get response
    Then check status two hundred
    And check response time below two thousand
    And check response header contain-type is application json
    And response body should not null
    And check response body contain key Name
    And check response body contain key Salary
    And check response body contain value Adam
    And check response body contain value ten thousand