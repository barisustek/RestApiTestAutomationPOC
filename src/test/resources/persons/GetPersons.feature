#noinspection NonAsciiCharacters
Feature: GET "/api/persons" endpoint step definitions

  Scenario: TC_001_When the rest api application is first initialized, the person list should be empty.
    Given GET "/api/persons" endpoint returns 200 and body list
      | id | PersonName  | PhoneNumber    |
    When GET "/api/persons" endpoint is called without parameters
    Then HTTP status code should be 200 status code
    And Persons should be
      | id | PersonName  | PhoneNumber    |

  Scenario: TC_002_When the "/api/persons" endpoint is called, then stored persons list should be returned.
    Given GET "/api/persons" endpoint returns 200 and body list
      | id | PersonName  | PhoneNumber    |
      | 1  | Baris Ustek | 05555555555    |
      | 2  | Mr.Brown    | (530) 892-1201 |
      | 3  | Mrs.Brown   | (301) 638-5772 |
    When GET "/api/persons" endpoint is called without parameters
    Then HTTP status code should be 200 status code
    And Persons should be
      | id | PersonName  | PhoneNumber    |
      | 1  | Baris Ustek | 05555555555    |
      | 2  | Mr.Brown    | (530) 892-1201 |
      | 3  | Mrs.Brown   | (301) 638-5772 |

  Scenario: TC_003_When the "/api/persons/<id>" endpoint is called, then matching data is returned according to the given id
    Given GET "/api/persons/1" endpoint returns 200 and body list
      | id | PersonName  | PhoneNumber    |
      | 1  | Baris Ustek | 05555555555    |
    When GET "/api/persons/1" endpoint is called
    Then HTTP status code should be 200 status code
    And Persons should be
      | id | PersonName  | PhoneNumber    |
      | 1  | Baris Ustek | 05555555555    |

  Scenario: TC_004_When the "/api/persons/<id>" endpoint is called with non-matching id according to a given list, then returns 404 not found
    Given GET "/api/persons/4" endpoint returns 404 and body list
      | id | personName  | phoneNumber    |
    When GET "/api/persons/4" endpoint is called
    Then HTTP status code should be 404 status code

  Scenario Outline: TC_005_When "/api/persons/<id>" endpoint is called with non-matching id according to a given list, then returns 404 not found
    Given GET "/api/persons/<id>" endpoint returns 404 and body list
      | id | personName  | phoneNumber    |
    When GET "/api/persons/<id>" endpoint is called
    Then HTTP status code should be 404 status code

    Examples:
    | id          |
    | Baris       |
    | 05555555555 |