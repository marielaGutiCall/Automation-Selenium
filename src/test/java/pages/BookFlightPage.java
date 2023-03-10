package pages;

import control.Button;
import control.Dropdown;
import control.MainControl;
import control.TextBox;
import org.openqa.selenium.By;

public class BookFlightPage {

    public MainControl navbarBookStep = new MainControl(By.id("stage_registro"));
    public MainControl peopleForm = new MainControl(By.id("div_formulario_personas"));
    public Button backToFlightsButton = new Button(By.id("btn_volver_vuelos"));
    public TextBox totalPriceInput = new TextBox(By.id("precio_total"));
    public TextBox passengerName1 = new TextBox(By.id("tbx_px1_nombres"));
    public TextBox passengerLastName1 = new TextBox(By.id("tbx_px1_apellidos"));
    public Dropdown passengerDocumentType1 = new Dropdown(By.id("select_px1_tipo_documento"));
    public TextBox passengerDocument1 = new TextBox(By.id("tbx_px1_documento"));
    public TextBox passengerPhone1 = new TextBox(By.id("tbx_px1_telefono"));
    public TextBox passengerEmail1 = new TextBox(By.id("tbx_px1_email"));
    public Button passengerBirthday1 = new Button(By.id("picker_px1_nacimiento"));

    public TextBox passengerName2 = new TextBox(By.id("tbx_px2_nombres"));
    public TextBox passengerLastName2 = new TextBox(By.id("tbx_px2_apellidos"));
    public Dropdown passengerDocumentType2 = new Dropdown(By.id("select_px2_tipo_documento"));
    public TextBox passengerDocument2 = new TextBox(By.id("tbx_px2_documento"));
    public TextBox passengerPhone2 = new TextBox(By.id("tbx_px2_telefono"));
    public MainControl passengerBirthday2 = new MainControl(By.id("picker_px2_nacimiento"));


    public MainControl datePickerContainer = new MainControl(By.id("ui-datepicker-div"));
    public Dropdown yearDatePicker = new Dropdown(By.xpath("//div[@id='ui-datepicker-div']//select"));

    public Button datePickerSelectDate(String date){
        return new Button(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='"+date+"']"));
    }
    public Button checkOutButton = new Button(By.xpath("//div[@id='info_registro_pasajeros']//div[@id='btn_validar_pasajeros']"));
}
