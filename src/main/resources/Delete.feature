@Smoke @Regression @Functional
Feature: Create new data with delete function

  @Positive
  Scenario: as a user , can delete  data
    Given Create request and add test data in json
    When send data with get method with delete URL and delete response
    Then check status two hundred
    And check response time below two thousand
    And check response header contain-type is application json
 
 
  