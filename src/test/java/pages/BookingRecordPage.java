package pages;

import control.Button;
import control.Label;
import control.MainControl;
import org.openqa.selenium.By;

public class BookingRecordPage {
    public MainControl navbarPurchaseStep = new MainControl(By.id("stage_compra"));
    public Label reservationCode = new Label(By.id("lbl_codigo_reserva"));
    public Button payBooking = new Button(By.xpath("//div[@id='info_pago_bancos']//b[@class='button']"));
    public Button backToFlightsButton = new Button(By.id("btn_volver_vuelos"));
}
