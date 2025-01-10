@Smoke @Regression @Functional
Feature: Create new data with get function

  @Positive
  Scenario: as a user , can get  data
    Given Create request and add test data in json
    When send data with get method with get URL and get response
    Then check status two hundred
    And check response time below two thousand
    And check response header contain-type is application json
    And response body should not null
    And check response body contain key url
    And check response body contain key origin
  