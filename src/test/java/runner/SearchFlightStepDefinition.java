package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.SearchFlightPage;
import pages.SelectYourFlightPage;


public class SearchFlightStepDefinition {
    String expectedFromOrigin;
    String expectedToDestiny;
    String expectedDepartureDate;
    String expectedReturnDate;
    String expectedAdultsNumber;
    String expectedChildNumber;
    String expectedInfantsNumber;
    SearchFlightPage searchFlightPage = new SearchFlightPage();
    SelectYourFlightPage selectYourFlightPage = new SelectYourFlightPage();

    @Given("The user is in the main Flight Booking Form")
    public void the_user_is_in_the_main_flight_booking_form(){
        searchFlightPage.flightSearchEngine.waitElementIsVisible();
        searchFlightPage.flightSearchEngine.mouseOver();
    }
    @When("the user selects options for: {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void the_user_enters_valid_data_for_each_required_field(String departurePlace, String destinationPlace,String departureDate,String returnDate,String adultsNumber,String childNumber,String infantsNumber){

         expectedFromOrigin = departurePlace;
         expectedToDestiny = destinationPlace;
         expectedDepartureDate = departureDate;
         expectedReturnDate = returnDate;
         expectedAdultsNumber = adultsNumber;
         expectedChildNumber = childNumber;
         expectedInfantsNumber = infantsNumber;

        searchFlightPage.fromOrigin.selectOption(expectedFromOrigin);
        searchFlightPage.toDestiny.selectOption(expectedToDestiny);

        searchFlightPage.datePickerDepartureInput.waitElementIsVisible();
        searchFlightPage.datePickerDepartureInput.waitElementIsClickable();
        searchFlightPage.datePickerDepartureInput.click();
        try{
            searchFlightPage.containerDatePicker.waitElementIsVisible();
            searchFlightPage.datePickerSelectDate(expectedDepartureDate).click();
        }catch (Exception e){
            searchFlightPage.datePickerDepartureInput.click();
            searchFlightPage.containerDatePicker.waitElementIsVisible();
            searchFlightPage.datePickerSelectDate(expectedDepartureDate).click();
        }
        searchFlightPage.datePickerReturnInput.waitElementIsVisible();
        searchFlightPage.datePickerReturnInput.waitElementIsClickable();
        searchFlightPage.datePickerReturnInput.click();

        try{
            searchFlightPage.containerDatePicker.waitElementIsVisible();
            searchFlightPage.datePickerSelectDate(expectedReturnDate).click();
        }
        catch (Exception e) {
            searchFlightPage.datePickerReturnInput.click();
            searchFlightPage.containerDatePicker.waitElementIsVisible();
            searchFlightPage.datePickerSelectDate(expectedReturnDate).click();
        }
        searchFlightPage.adults.selectOption(expectedAdultsNumber);
        searchFlightPage.child.selectOption(expectedChildNumber);
        searchFlightPage.infants.selectOption(expectedInfantsNumber);
    }
    @And("user searches for the flight with these options")
    public void user_searches_for_the_flight_with_these_options(){
        searchFlightPage.searchFlightsButton.click();
        selectYourFlightPage.loadingIcon.waitElementIsNotVisible(40);
        selectYourFlightPage.header.waitElementIsVisible();
    }
    @Then("the user should be able to see the Select Your Flight page")
    public void the_user_should_be_able_to_see_the_select_your_flight_page(){
        Assertions.assertTrue(selectYourFlightPage.navbarSelectFlightStep.getAttributeOfElement("class").contains("active"), "The step to 'Select your flight' is not activated");
        Assertions.assertTrue(selectYourFlightPage.shoppingCartContainer.isWebElementDisplayed(), "'Your shopping cart' is not displayed on the page");
    }
    @And("the options that the user selected should be displayed on the Select Your Flight page")
    public void the_options_that_the_user_selected_should_be_displayed_on_the_select_your_flight_page(){
        String actualOriginToDestiny = selectYourFlightPage.originToDestinyText.getText();
        String actualDestinyToOrigin = selectYourFlightPage.destinyToOriginText.getText();
        selectYourFlightPage.adultNumberText.waitElementIsVisible();
        String actualAdultNumberText = selectYourFlightPage.adultNumberText.getText();
        String actualChildrenNumberText = selectYourFlightPage.childrenNumberText.getText();
        String actualInfantsNumberText = selectYourFlightPage.infantsNumberText.getText();
        String actualDateDepartureText = selectYourFlightPage.dateDepartureText.getText();
        String actualDateReturnText = selectYourFlightPage.dateReturnText.getText();

        boolean expectedFromOriginToDestiny = actualOriginToDestiny.toLowerCase().contains(expectedFromOrigin.toLowerCase()) && actualOriginToDestiny.toLowerCase().contains(expectedToDestiny.toLowerCase());
        boolean expectedFromDestinyToOrigin=  actualDestinyToOrigin.toLowerCase().contains(expectedFromOrigin.toLowerCase()) && actualDestinyToOrigin.toLowerCase().contains(expectedToDestiny.toLowerCase());

        Assertions.assertTrue(expectedFromOriginToDestiny, "The places selected for the 'Outbound flight' are not as expected");
        Assertions.assertTrue(expectedFromDestinyToOrigin, "The places selected for the 'Return Flight' are not as expected");
        Assertions.assertEquals(expectedDepartureDate, actualDateDepartureText, "The departure date is not what was expected");
        Assertions.assertEquals(expectedReturnDate, actualDateReturnText, "The return date is not what was expected");
        Assertions.assertTrue(actualAdultNumberText.contains(expectedAdultsNumber), "The option selected for the number of adults is not what was expected");
        Assertions.assertTrue(actualChildrenNumberText.contains(expectedChildNumber), "The option selected for the number of children is not what was expected");
        Assertions.assertTrue(actualInfantsNumberText.contains(expectedInfantsNumber), "The option selected for the number of infants is not what was expected");
    }

    @Then("the user should see the popup modal with the text: {}")
    public void the_user_should_see_the_popup_modal_with_the_text(String expectedText) {
        selectYourFlightPage.popupModalWithoutFlight.waitElementIsVisible();
        String actualPopupModalText = selectYourFlightPage.popupModalWithoutFlightText.getText();
        Assertions.assertEquals(expectedText, actualPopupModalText, "The text of the informative modal is not what is expected");
    }
}
