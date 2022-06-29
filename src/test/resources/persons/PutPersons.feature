#noinspection NonAsciiCharacters
Feature: PUT "/api/persons" endpoint step definitions

  Scenario:TC_001_When the rest api application is called with one person, then the person should be created successfully
    Given PUT "/api/persons/" endpoint returns 201 and body list
      | id | PersonName  | PhoneNumber    |
      | 1  | Baris Ustek | 05555555555    |
    When PUT "/api/persons/" endpoint is called
      | PersonName  | PhoneNumber    |
      | Baris Ustek | 05555555555    |
    Then HTTP status code should be 201 status code
    And Persons should be
      | id | PersonName  | PhoneNumber    |
      | 1  | Baris Ustek | 05555555555    |

  Scenario:TC_002_When the rest api application is called with a list of persons, then all rows should be created successfully
    Given PUT "/api/persons/" endpoint returns 201 and body list
      | id | PersonName  | PhoneNumber    |
      | 1  | Baris Ustek | 05555555555    |
      | 2  | Mr.Brown    | 05555555554    |
      | 3  | Mrs.Brown   | 6583020585     |
    When PUT "/api/persons/" endpoint is called
      | PersonName  | PhoneNumber    |
      | Baris Ustek | 05555555555    |
      | Mr.Brown    | 05555555554    |
      | Mrs.Brown   | 6583020585     |
    Then HTTP status code should be 201 status code
    And Persons should be
      | id | PersonName  | PhoneNumber    |
      | 1  | Baris Ustek | 05555555555    |
      | 2  | Mr.Brown    | 05555555554    |
      | 3  | Mrs.Brown   | 6583020585     |

  Scenario Outline:TC_003_When the rest api application's PUT /api/persons endpoint is called without a phone number or username, then the endpoint should return 400 and <messsage>
    Given PUT "/api/persons/" endpoint returns 400 status code and Message is "<message>"
    When PUT "/api/persons/" endpoint is called
      | PersonName  | PhoneNumber       |
      | <personName> | <phoneNumber>    |
    Then HTTP status code should be 400 and Message should be "<message>"

    Examples:
    |personName  |phoneNumber |message                                                    |
    |            |05555555555 |Person name cannot be empty..                              |
    |Baris Ustek |            |Phone number cannot be empty.                              |
    |            |            |Person name cannot be empty. Phone number cannot be empty. |
    |[empty]     |05555555555 |Person name cannot be empty.                               |
    |Baris Ustek |[empty]     |Phone number cannot be empty.                              |
    |[empty]     |[empty]     |Person name cannot be empty. Phone number cannot be empty. |

  Scenario:TC_004_When the rest api application's PUT /api/persons endpoint is called with the same person name, the endpoint should return 400 and "Person already created!"
    Given PUT "/api/persons/" endpoint returns 400 status code and Message is "Person already created!"
    When PUT "/api/persons/" endpoint is called
      | PersonName  | PhoneNumber       |
      | Baris Ustek  | 05555555555      |
      | Baris Ustek  | 05555555545      |
    Then HTTP status code should be 400 and Message should be "Person already created!"

  Scenario:TC_005_When the rest API application's PUT /api/persons endpoint is called with id, then the endpoint should return 400, and the "Id field must be empty while creating a person"
    Given PUT "/api/persons/1" endpoint returns 400 status code and Message is "Id field must be empty while creating a person"
    When PUT "/api/persons/1" endpoint is called
      | PersonName   | PhoneNumber      |
      | Baris Ustek  | 05555555555      |
    Then HTTP status code should be 400 and Message should be "Id field must be empty while creating a person"