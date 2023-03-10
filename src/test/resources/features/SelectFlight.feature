@SelectFlightPage
@severity=Blocker

Feature: Feature - Select Your Flight in the BOA Web application

  @ValidOptionsToSelectAFlight
  Scenario Outline: Scenario - Select Your Flight

    Given The user is in the main Flight Booking Form
    And   the user selects options for: <departurePlace>, <destinationPlace>, <departureDate>, <returnDate>, <adultsNumber>, <childNumber> and <infantsNumber>
    And   user searches for the flight with these options
    When  the user selects the outbound flight
    And   the user selects the return flight
    Then  the user should see the outbound flight option they selected with a different background color
    And   the user should see the outbound flight option they selected in the shopping cart panel
    And   the user should see the return flight option they selected with a different background color
    And   the user should see the return flight option they selected in the shopping cart panel

    Examples:
      | departurePlace | destinationPlace | departureDate | returnDate | adultsNumber | childNumber | infantsNumber |
      | "LA PAZ"       | "COCHABAMBA"     | "26"          | "28"       | "2"          | "2"         | "1"           |

  @RemoveSelectedFlightOptions
  Scenario Outline: Scenario - Remove Selected Flight Options from shopping cart

    Given The user is in the main Flight Booking Form
    And   the user selects options for: <departurePlace>, <destinationPlace>, <departureDate>, <returnDate>, <adultsNumber>, <childNumber> and <infantsNumber>
    And   user searches for the flight with these options
    And   the user selects the outbound flight
    And   the user selects the return flight
    When  the user removes the selected Outbound Flight option from the shopping cart
    And   the user removes the selected Return Flight option from the shopping cart
    Then  the user should see in the shopping cart panel the text: SELECT YOUR FLIGHT
    And   the user should see that the shopping cart total is 0
    And   the user should see that the Outbound Flight option they removed is not selected in the flight options set
    And   the user should see that the Return Flight option they removed is not selected in the flight options set

    Examples:
      | departurePlace | destinationPlace | departureDate | returnDate | adultsNumber | childNumber | infantsNumber |
      | "LA PAZ"       | "COCHABAMBA"     | "26"          | "28"       | "2"          | "2"         | "1"           |

  @UpdateOptionsForAdultChildrenAndInfants
  Scenario Outline: Scenario - Update The Options for the Adult Children And Infants fields

    Given The user is in the main Flight Booking Form
    And   the user selects options for: <departurePlace>, <destinationPlace>, <departureDate>, <returnDate>, <adultsNumber>, <childNumber> and <infantsNumber>
    And   user searches for the flight with these options
    And   the user selects the outbound flight
    And   the user selects the return flight
    When  the user updates the quantity in the adult option to: <adultUpdatedOption>
    And   the user updates the quantity in the children option to: <childrenUpdatedOption>
    And   the user updates the quantity in the infants option to: <infantsUpdatedOption>
    Then  the user should see that the adult, child and infant options have been updated

    Examples:
      | departurePlace | destinationPlace | departureDate | returnDate | adultsNumber | childNumber | infantsNumber | adultUpdatedOption | childrenUpdatedOption | infantsUpdatedOption |
      | "LA PAZ"       | "COCHABAMBA"     | "26"          | "28"       | "2"          | "2"         | "1"           | "3"                | "4"                   | "2"                  |

  @VerifyTotalPriceInTheShoppingCart
  Scenario Outline: Scenario - Verify Total Price In The Shopping Cart

    Given The user is in the main Flight Booking Form
    And   the user selects options for: <departurePlace>, <destinationPlace>, <departureDate>, <returnDate>, <adultsNumber>, <childNumber> and <infantsNumber>
    And   user searches for the flight with these options
    When  the user selects the outbound flight
    And   the user selects the return flight
    Then  the user should see that the total price in the shopping cart is the sum of the prices in the adult, child, infant and tax fields

    Examples:
      | departurePlace | destinationPlace | departureDate | returnDate | adultsNumber | childNumber | infantsNumber |
      | "LA PAZ"       | "COCHABAMBA"     | "26"          | "28"       | "2"          | "2"         | "1"           |

  @VerifyTotalTaxesPriceInTheShoppingCart
  Scenario Outline: Scenario - Verify total Tax price in Shopping Cart

    Given The user is in the main Flight Booking Form
    And   the user selects options for: <departurePlace>, <destinationPlace>, <departureDate>, <returnDate>, <adultsNumber>, <childNumber> and <infantsNumber>
    And   user searches for the flight with these options
    When  the user selects the outbound flight
    And   the user selects the return flight
    And   the user hovers over the tax price field
    Then  the user should see that the total price of the taxes in the shopping cart is the sum of the prices of the airport taxes, IVA and IT

    Examples:
      | departurePlace | destinationPlace | departureDate | returnDate | adultsNumber | childNumber | infantsNumber |
      | "LA PAZ"       | "COCHABAMBA"     | "26"          | "28"       | "2"          | "2"         | "1"           |

  @ContinueShopping
  Scenario Outline: Scenario - The user continues with the purchase after selecting the outbound flight and return flight

    Given The user is in the main Flight Booking Form
    And   the user selects options for: <departurePlace>, <destinationPlace>, <departureDate>, <returnDate>, <adultsNumber>, <childNumber> and <infantsNumber>
    And   user searches for the flight with these options
    And   the user selects the outbound flight
    And   the user selects the return flight
    When  the user clicks on the Continue shopping button
    Then  the user should be able to see the Book Flight page
    And   the user should see that the total price on the select flight page matches the book flight page

    Examples:
      | departurePlace | destinationPlace | departureDate | returnDate | adultsNumber | childNumber | infantsNumber |
      | "LA PAZ"       | "COCHABAMBA"     | "26"          | "28"       | "2"          | "2"         | "1"           |