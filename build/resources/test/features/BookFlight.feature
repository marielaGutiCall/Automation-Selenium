@BookFlight
@severity=Normal
Feature: Feature - Book flight and make payment in the BOA Web application

  @BookFlightAndMakePayment
  Scenario Outline: Scenario - The user fills in the passenger information to book and pay for the flight

    Given The user is in the main Flight Booking Form
    And   the user selects options for: <departurePlace>, <destinationPlace>, <departureDate>, <returnDate>, <adultsNumber>, <childNumber> and <infantsNumber>
    And   user searches for the flight with these options
    And   the user selects the outbound flight
    And   the user selects the return flight
    And   the user clicks on the Continue shopping button
    When  the user fills in the passenger information to book flight
    And   the user clicks on make the payment
    Then  the user should be able to see the page to Pay for the flight
    And   the user should be able to see the reservation code on the page to Pay for the flight

    Examples:
      | departurePlace | destinationPlace | departureDate | returnDate | adultsNumber | childNumber | infantsNumber |
      | "LA PAZ"       | "COCHABAMBA"     | "26"          | "28"       | "1"          | "1"         | "0"         |