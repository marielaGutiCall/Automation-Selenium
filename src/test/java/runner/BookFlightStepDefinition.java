package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.jupiter.api.Assertions;
import pages.BookFlightPage;
import pages.BookingRecordPage;
import pages.SelectYourFlightPage;

public class BookFlightStepDefinition {
    BookFlightPage bookFlightPage = new BookFlightPage();
    BookingRecordPage bookingRecordPage = new BookingRecordPage();
    SelectYourFlightPage selectYourFlightPage = new SelectYourFlightPage();

    @When("the user fills in the passenger information to book flight")
    public void the_user_fills_in_the_passenger_information_to_book_flight(){
        bookFlightPage.peopleForm.waitElementIsVisible(30);
        bookFlightPage.passengerName1.waitElementIsVisible(10);
        bookFlightPage.passengerName1.setText("Maria");
        bookFlightPage.passengerLastName1.setText("Gonzales");
        bookFlightPage.passengerDocumentType1.selectOption("CI");
        bookFlightPage.passengerDocument1.setText("1234567");
        bookFlightPage.passengerPhone1.setText("65431234");
        bookFlightPage.passengerEmail1.setText("maria@gmail.com");
        bookFlightPage.passengerBirthday1.click();
        bookFlightPage.datePickerContainer.waitElementIsVisible(8);
        bookFlightPage.yearDatePicker.selectOption("1994");
        bookFlightPage.datePickerSelectDate("8").click();

        bookFlightPage.passengerName2.setText("Jose");
        bookFlightPage.passengerLastName2.setText("Gonzales");
        bookFlightPage.passengerDocumentType2.selectOption("CI");
        bookFlightPage.passengerDocument2.setText("654312");
        bookFlightPage.passengerPhone2.setText("65431234");

        bookFlightPage.passengerBirthday2.waitElementIsVisible();
        bookFlightPage.passengerBirthday2.clickOnElement();
        bookFlightPage.datePickerContainer.waitElementIsVisible(8);
        bookFlightPage.yearDatePicker.selectOption("2012");
        bookFlightPage.datePickerSelectDate("8").click();
    }

    @And("the user clicks on make the payment")
    public void the_user_clicks_on_make_the_payment(){
        bookFlightPage.checkOutButton.waitElementIsClickable();
        bookFlightPage.checkOutButton.click();
        selectYourFlightPage.loadingIcon.waitElementIsVisible();
        selectYourFlightPage.loadingIcon.waitElementIsNotVisible(40);
    }

    @Then ("the user should be able to see the page to Pay for the flight")
    public void the_user_should_be_able_to_see_the_page_to_pay_for_the_flight(){
        bookingRecordPage.backToFlightsButton.waitElementIsVisible(8);
        Assertions.assertTrue(bookingRecordPage.payBooking.isWebElementDisplayed(), "The button to pay for the booking is not shown in the interface");
        Assertions.assertTrue(bookingRecordPage.navbarPurchaseStep.getAttributeOfElement("class").contains("active"), "The step to Pay is not activated");
    }

    @And("the user should be able to see the reservation code on the page to Pay for the flight")
    public void the_user_should_be_able_to_see_the_reservation_code_on_the_page_to_Pay_for_the_flight(){
        Assertions.assertTrue(bookingRecordPage.reservationCode.isWebElementDisplayed(), "The booking record locator is not displayed in the interface");
    }
}
