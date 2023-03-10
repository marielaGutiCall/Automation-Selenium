package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.BookFlightPage;
import pages.SelectYourFlightPage;

public class SelectYourFlightStepDefinition {
    String outboundFlightSelectedRow = "1";
    String returnFlightSelectedRow = "2";
    String expectedOptionForTheAdultsField;
    String expectedOptionForTheChildrenField;
    String expectedOptionForTheInfantsField;
    SelectYourFlightPage selectYourFlightPage = new SelectYourFlightPage();
    BookFlightPage bookFlightPage = new BookFlightPage();

    @When("the user selects the outbound flight")
    public void the_user_selects_the_outbound_flight(){
        selectYourFlightPage.oneWayFlightClassOption(outboundFlightSelectedRow).waitElementIsClickable();
        selectYourFlightPage.oneWayFlightClassOption(outboundFlightSelectedRow).click();
    }

    @And("the user selects the return flight")
    public void the_user_selects_the_return_flight(){
        selectYourFlightPage.returnFlightClassOption(returnFlightSelectedRow).waitElementIsClickable();
        selectYourFlightPage.returnFlightClassOption(returnFlightSelectedRow).click();
    }

    @Then ("the user should see the outbound flight option they selected with a different background color")
    public void the_user_should_see_the_outbound_flight_option_they_selected_with_a_different_background_color(){
        boolean isSelectedTheOutboundFlightOption = selectYourFlightPage.oneWayFlightClassOption(outboundFlightSelectedRow).getAttributeOfElement("class").contains("vuelosIda_seleccionado");
        Assertions.assertTrue(isSelectedTheOutboundFlightOption, "The outbound flight option is not selected");
        Assertions.assertEquals(selectYourFlightPage.oneWayFlightClassOption(outboundFlightSelectedRow).getCSSPropertyOfElement("background-color"), "rgba(239, 170, 53, 1)", "The selected outbound flight option does not have the expected background color");
    }

    @And("the user should see the outbound flight option they selected in the shopping cart panel")
    public void the_user_should_see_the_outbound_flight_option_they_selected_in_the_shopping_cart_panel(){
        selectYourFlightPage.originToDestinyDepartureTime.waitElementIsVisible();
        String actualScheduleDepartureOutboundFlight = selectYourFlightPage.originToDestinyDepartureTime.getText() + " " + selectYourFlightPage.originToDestinyDeparturePlace.getText();
        String actualScheduleArrivalOutboundFlight  = selectYourFlightPage.originToDestinyArrivalTime.getText() + " " + selectYourFlightPage.originToDestinyArrivalPlace.getText();
        String expectedScheduleDepartureOutboundFlight = selectYourFlightPage.departureTimeOutboundFlightLabel(outboundFlightSelectedRow).getText();
        String expectedScheduleArrivalOutboundFlight  = selectYourFlightPage.arrivalTimeOutboundFlightLabel(outboundFlightSelectedRow).getText();

        Assertions.assertEquals(actualScheduleDepartureOutboundFlight, expectedScheduleDepartureOutboundFlight,"The time and place of departure of the outbound flight in the shopping cart does not match the selected option");
        Assertions.assertEquals(actualScheduleArrivalOutboundFlight, expectedScheduleArrivalOutboundFlight,"The time and place of arrival of the outbound flight in the shopping cart does not match the selected option");
    }

    @And ("the user should see the return flight option they selected with a different background color")
    public void the_user_should_see_the_return_flight_option_they_selected_with_a_different_background_color(){
        boolean isSelectedTheReturnFlightOption = selectYourFlightPage.returnFlightClassOption(returnFlightSelectedRow).getAttributeOfElement("class").contains("vuelosVuelta_seleccionado");
        Assertions.assertTrue(isSelectedTheReturnFlightOption, "the return flight option is not selected");
        Assertions.assertEquals(selectYourFlightPage.returnFlightClassOption(returnFlightSelectedRow).getCSSPropertyOfElement("background-color"), "rgba(239, 170, 53, 1)", "The selected return flight option does not have the expected background color");
    }

    @And("the user should see the return flight option they selected in the shopping cart panel")
    public void the_user_should_see_the_return_flight_option_they_selected_in_the_shopping_cart_panel(){
        selectYourFlightPage.destinyToOriginDepartureTime.waitElementIsVisible();
        String actualScheduleDepartureReturnFlight  = selectYourFlightPage.destinyToOriginDepartureTime.getText() + " " + selectYourFlightPage.destinyToOriginDeparturePlace.getText();
        String actualScheduleArrivalReturnFlight = selectYourFlightPage.destinyToOriginArrivalTime.getText() + " " + selectYourFlightPage.destinyToOriginArrivalPlace.getText();
        selectYourFlightPage.departureTimeReturnFlightLabel(outboundFlightSelectedRow).waitElementIsVisible();
        String expectedScheduleDepartureReturnFlight  = selectYourFlightPage.departureTimeReturnFlightLabel(returnFlightSelectedRow).getText();
        String expectedScheduleArrivalReturnFlight =  selectYourFlightPage.arrivalTimeReturnFlightLabel(returnFlightSelectedRow).getText();

        Assertions.assertEquals(actualScheduleDepartureReturnFlight, expectedScheduleDepartureReturnFlight,"The time and place of departure of the return flight in the shopping cart does not match the selected option");
        Assertions.assertEquals(actualScheduleArrivalReturnFlight, expectedScheduleArrivalReturnFlight,"The time and place of arrival of the return flight in the shopping cart does not match the selected option");
    }

    @When("the user removes the selected Outbound Flight option from the shopping cart")
    public void the_user_removes_the_selected_outbound_flight_option_from_the_shopping_cart(){
        selectYourFlightPage.buttonDeleteSelectedOutboundFlightOption.waitElementIsClickable();
        selectYourFlightPage.buttonDeleteSelectedOutboundFlightOption.click();
    }
    @And("the user removes the selected Return Flight option from the shopping cart")
    public void the_user_removes_the_selected_return_flight_option_from_the_shopping_cart(){
        selectYourFlightPage.buttonDeleteSelectedReturnFlightOption.waitElementIsClickable();
        selectYourFlightPage.buttonDeleteSelectedReturnFlightOption.click();
    }

    @Then("the user should see in the shopping cart panel the text: {}")
    public void the_user_should_see_in_the_shopping_cart_panel_the_text_select_your_flight(String expectedEmptyFlightText){
        selectYourFlightPage.emptyFlightLabel.waitElementIsVisible();
        String actualEmptyFlightText = selectYourFlightPage.emptyFlightLabel.getText().replace("\n", " ");
        Assertions.assertEquals(expectedEmptyFlightText, actualEmptyFlightText, "The text for an empty flight is not what is expected");
    }

    @And("the user should see that the shopping cart total is 0")
    public void the_user_should_see_that_the_shopping_cart_total_is_0(){
        String expectedTotalPriceInput = "0";
        String actualTotalPriceInput = selectYourFlightPage.totalPriceInput.getAttributeOfElement("value");
        Assertions.assertEquals(expectedTotalPriceInput, actualTotalPriceInput, "The total price is not equal to 0, the flights have not been removed");
    }

    @And("the user should see that the Outbound Flight option they removed is not selected in the flight options set")
    public void the_user_should_see_that_the_outbound_flight_option_they_removed_is_not_selected_in_the_flight_options_set(){
        boolean isSelectedTheOutboundFlightOption = !selectYourFlightPage.oneWayFlightClassOption(outboundFlightSelectedRow).getAttributeOfElement("class").contains("vuelosIda_seleccionado");
        Assertions.assertTrue(isSelectedTheOutboundFlightOption, "The outbound flight option is still selected");
        Assertions.assertEquals(selectYourFlightPage.oneWayFlightClassOption(outboundFlightSelectedRow).getCSSPropertyOfElement("background-color"), "rgba(241, 241, 241, 1)", "The selected outbound flight option does not have the expected background color");
    }

    @And("the user should see that the Return Flight option they removed is not selected in the flight options set")
    public void the_user_should_see_that_the_return_flight_option_they_removed_is_not_selected_in_the_flight_options_set(){
        boolean isSelectedTheReturnFlightOption = !selectYourFlightPage.returnFlightClassOption(returnFlightSelectedRow).getAttributeOfElement("class").contains("vuelosVuelta_seleccionado");
        Assertions.assertTrue(isSelectedTheReturnFlightOption, "the return flight option is still selected");
        Assertions.assertEquals(selectYourFlightPage.returnFlightClassOption(returnFlightSelectedRow).getCSSPropertyOfElement("background-color"), "rgba(241, 241, 241, 1)", "The selected return flight option does not have the expected background color");
    }

    @When("the user updates the quantity in the adult option to: {string}")
    public void the_user_adds_more_quantity_in_the_adult_option(String optionForTheAdultsField){
        expectedOptionForTheAdultsField = optionForTheAdultsField;
        selectYourFlightPage.adultNumberDropdown.waitElementIsClickable();
        selectYourFlightPage.adultNumberDropdown.click();
        selectYourFlightPage.newOptionSelectedForDropdown(expectedOptionForTheAdultsField).waitElementIsClickable();
        selectYourFlightPage.newOptionSelectedForDropdown(expectedOptionForTheAdultsField).click();

    }
    @And("the user updates the quantity in the children option to: {string}")
    public void the_user_adds_more_quantity_in_the_children_option(String optionForTheChildrenField){
        expectedOptionForTheChildrenField = optionForTheChildrenField;
        selectYourFlightPage.childrenNumberDropdown.waitElementIsClickable();
        selectYourFlightPage.childrenNumberDropdown.click();
        selectYourFlightPage.newOptionSelectedForDropdown(expectedOptionForTheChildrenField).waitElementIsClickable();
        selectYourFlightPage.newOptionSelectedForDropdown(expectedOptionForTheChildrenField).click();
    }

    @And("the user updates the quantity in the infants option to: {string}")
    public void the_user_adds_more_quantity_in_the_infants_option(String optionForTheInfantsField){
        expectedOptionForTheInfantsField = optionForTheInfantsField;
        selectYourFlightPage.infantsNumberDropdown.waitElementIsClickable();
        selectYourFlightPage.infantsNumberDropdown.click();
        selectYourFlightPage.newOptionSelectedForDropdown(expectedOptionForTheInfantsField).waitElementIsClickable();
        selectYourFlightPage.newOptionSelectedForDropdown(expectedOptionForTheInfantsField).click();
    }

    @Then("the user should see that the adult, child and infant options have been updated")
    public void the_user_should_see_that_the_adult_child_and_infant_options_have_been_updated(){
        String actualAdultNumberText = selectYourFlightPage.adultNumberText.getText();
        String actualChildrenNumberText = selectYourFlightPage.childrenNumberText.getText();
        String actualInfantsNumberText = selectYourFlightPage.infantsNumberText.getText();
        Assertions.assertEquals("x"+expectedOptionForTheAdultsField, actualAdultNumberText, "The new option selected for the Adults field is not what was expected");
        Assertions.assertEquals("x"+expectedOptionForTheChildrenField, actualChildrenNumberText, "The new option selected for the Children field is not what was expected");
        Assertions.assertEquals("x"+expectedOptionForTheInfantsField, actualInfantsNumberText, "The new option selected for the Infants field is not what was expected");
    }

    @Then("the user should see that the total price in the shopping cart is the sum of the prices in the adult, child, infant and tax fields")
    public void the_user_should_see_that_the_total_price_in_the_shopping_cart_is_the_sum_of_the_prices_in_the_adult_child_infant_and_tax_fields(){
        double totalPriceAdult = Double.parseDouble(selectYourFlightPage.totalPriceAdultField.getText());
        double totalPriceChildren = Double.parseDouble(selectYourFlightPage.totalPriceChildrenField.getText());
        double totalPriceInfants = Double.parseDouble(selectYourFlightPage.totalPriceInfantsField.getText());
        int actualTotalPriceTaxes= Integer.parseInt(selectYourFlightPage.totalPriceTaxesField.getText());
        String expectedTotalPrice= String.format("%.0f", totalPriceAdult + totalPriceChildren + totalPriceInfants + actualTotalPriceTaxes);
        String actualTotalPriceInput = selectYourFlightPage.totalPriceInput.getAttributeOfElement("value");
        Assertions.assertEquals(actualTotalPriceInput, expectedTotalPrice, "The total price calculated is not what was expected");
    }

    @And("the user hovers over the tax price field")
    public void the_user_hovers_over_the_tax_price_field(){
        selectYourFlightPage.totalPriceTaxesField.waitElementIsVisible();
        selectYourFlightPage.totalPriceTaxesField.mouseOver();
    }

    @Then("the user should see that the total price of the taxes in the shopping cart is the sum of the prices of the airport taxes, IVA and IT")
    public void the_user_should_see_that_the_total_price_of_the_taxes_in_the_shopping_cart_is_the_sum_of_the_prices_of_the_airport_taxes_iva_and_it(){
        int actualTotalPriceTaxes= Integer.parseInt(selectYourFlightPage.totalPriceTaxesField.getText());
        double airportTaxPrice = Double.parseDouble(selectYourFlightPage.airportTaxPriceField.getText());
        double ivaTaxPrice = Double.parseDouble(selectYourFlightPage.ivaTaxPriceField.getText());
        double itTaxPrice = Double.parseDouble(selectYourFlightPage.itTaxPriceField.getText());
        String expectedTotalTaxes= String.format("%.0f", airportTaxPrice + ivaTaxPrice + itTaxPrice);
        Assertions.assertEquals(expectedTotalTaxes, Integer.toString(actualTotalPriceTaxes), "The calculated total price of taxes is not as expected");
    }

    @When("the user clicks on the Continue shopping button")
    public void the_user_clicks_on_the_continue_shopping_button(){
        selectYourFlightPage.buttonContinueShopping.waitElementIsClickable();
        selectYourFlightPage.buttonContinueShopping.click();
    }

    @Then("the user should be able to see the Book Flight page")
    public void the_user_should_be_able_to_see_the_book_flight_page(){
        bookFlightPage.peopleForm.waitElementIsVisible();
        Assertions.assertTrue(bookFlightPage.navbarBookStep.getAttributeOfElement("class").contains("active"), "The step to Book is not activated");
        Assertions.assertTrue(bookFlightPage.backToFlightsButton.isWebElementDisplayed(), "The button to return to choose the Flight is not displayed on the page");
    }

    @And("the user should see that the total price on the select flight page matches the book flight page")
    public void the_user_should_see_that_the_total_price_on_the_select_flight_page_matches_the_book_flight_page(){
        String actualBookFlightTotalPriceInput = bookFlightPage.totalPriceInput.getAttributeOfElement("value");
        String expectedShoppingCartTotalPriceInput = selectYourFlightPage.totalPriceInput.getAttributeOfElement("value");
        Assertions.assertEquals(expectedShoppingCartTotalPriceInput,actualBookFlightTotalPriceInput, "The total prices on the page to book the flight and to select the flight do not match");
    }
}
