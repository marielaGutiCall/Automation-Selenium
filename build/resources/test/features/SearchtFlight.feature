@FindFlightPage
@severity=Blocker
Feature: Feature - Search Flight in the BOA Web application

  @ValidOptionsToSearchAFlight
  Scenario Outline: Scenario - Search Flight with Departure and Return

    Given The user is in the main Flight Booking Form
    When  the user selects options for: <departurePlace>, <destinationPlace>, <departureDate>, <returnDate>, <adultsNumber>, <childNumber> and <infantsNumber>
    And   user searches for the flight with these options
    Then  the user should be able to see the Select Your Flight page
    And   the options that the user selected should be displayed on the Select Your Flight page
    Examples:
      | departurePlace | destinationPlace | departureDate | returnDate | adultsNumber | childNumber | infantsNumber |
      | "LA PAZ"       | "COCHABAMBA"     | "26"          | "28"       | "2"          | "2"         | "1"           |

  @NoFlightsAvailable
  Scenario Outline: Scenario - The user selects options for an unavailable flight

    Given The user is in the main Flight Booking Form
    When  the user selects options for: <departurePlace>, <destinationPlace>, <departureDate>, <returnDate>, <adultsNumber>, <childNumber> and <infantsNumber>
    And   user searches for the flight with these options
    Then  the user should see the popup modal with the text: No se encontro itinerario para un segmento. Por favor intente con otra combinacion de fechas o pasajeros.
    Examples:
      | departurePlace | destinationPlace | departureDate | returnDate | adultsNumber | childNumber | infantsNumber |
      | "COBIJA"       | "YACUIBA"        | "29"          | "30"       | "2"          | "2"         | "1"           |
