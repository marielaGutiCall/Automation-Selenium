package pages;

import control.Button;
import control.Dropdown;
import control.MainControl;
import org.openqa.selenium.By;

public class SearchFlightPage {

    public MainControl flightSearchEngine = new MainControl(By.id("buscador_vuelos"));
    public Dropdown fromOrigin = new Dropdown(By.id("select_desde"));
    public Dropdown toDestiny = new Dropdown(By.id("select_hasta"));
    public MainControl containerDatePicker = new MainControl(By.id("ui-datepicker-div"));
    public Button datePickerDepartureInput = new Button(By.id("picker_salida"));
    public Button datePickerReturnInput = new Button(By.id("picker_regreso"));
    public Dropdown adults = new Dropdown(By.id("select_nro_adultos"));
    public Dropdown child = new Dropdown(By.id("select_nro_ninhos"));
    public Dropdown infants = new Dropdown(By.id("select_nro_bebes"));
    public Button searchFlightsButton = new Button(By.id("btn_buscar_vuelos"));
    public Button datePickerSelectDate(String date){
        return new Button(By.xpath("//td[contains(@data-month,'2')]//a[text()='"+date+"']"));
    }
}
