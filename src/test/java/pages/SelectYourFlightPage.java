package pages;

import control.Button;
import control.Label;
import control.MainControl;
import control.TextBox;
import org.openqa.selenium.By;

public class SelectYourFlightPage {

     public MainControl navbarSelectFlightStep = new MainControl(By.id("stage_seleccion"));
     public MainControl header = new MainControl(By.xpath("//div[@id='ui_reserva_vuelos']//div[contains(@class, 'header')]"));
     public MainControl shoppingCartContainer = new MainControl(By.id("widget_resumen_reserva"));
     public MainControl loadingIcon = new MainControl(By.xpath("//loading//figure"));
     public Label originToDestinyText = new Label(By.xpath("//h2[@id='lbl_info_salida']//following-sibling::b[1]"));
     public Label destinyToOriginText = new Label(By.xpath("//h2[@id='lbl_info_salida']//following-sibling::b[2]"));
     public Label adultNumberText = new Label(By.xpath("//ul[@data-tipo='adulto']//li[@class='selected']"));
     public Label childrenNumberText = new Label(By.xpath("//ul[@data-tipo='ninho']//li[@class='selected']"));
     public Label infantsNumberText = new Label(By.xpath("//ul[@data-tipo='infante']//li[@class='selected']"));
     public Label dateDepartureText = new Label(By.xpath("//table[@id='tbl_days_selector_salida']//td[@class='day-selector selected']//h2//span"));
     public Label dateReturnText = new Label(By.xpath("//table[@id='tbl_dayselector_regreso']//td[@class='day-selector selected']//h2//span"));
     public MainControl popupModalWithoutFlight = new MainControl(By.id("simple_dialog"));
     public Label popupModalWithoutFlightText = new Label(By.xpath("//div[@id='simple_dialog']//div[@class='description']"));
     public Button oneWayFlightClassOption(String numberRow){
          return new Button(By.xpath("//div[@id='vuelosIda_"+numberRow+"']//div[contains(@class,'cajaFamilia') and not(@class='cajaFamiliaNoDisponible')]"));
     }
     public Button returnFlightClassOption(String numberRow){
          return new Button(By.xpath("//div[@id='vuelosVuelta_"+numberRow+"']//div[contains(@class,'cajaFamilia') and not(@class='cajaFamiliaNoDisponible')]"));
     }
     public Label departureTimeOutboundFlightLabel(String numberRow){
          return new Label(By.xpath("//div[@id='vuelosIda_"+numberRow+"']//div[@class='desc_vuelo']//div[1]//span//following-sibling::div//b"));
     }
     public Label arrivalTimeOutboundFlightLabel(String numberRow){
          return new Label(By.xpath("//div[@id='vuelosIda_"+numberRow+"']//div[@class='desc_vuelo']//div[3]//span//following-sibling::div//b"));
     }
     public Label departureTimeReturnFlightLabel(String numberRow){
          return new Label(By.xpath("//div[@id='vuelosVuelta_"+numberRow+"']//div[@class='desc_vuelo']//div[1]//span//following-sibling::div//b"));
     }
     public Label arrivalTimeReturnFlightLabel(String numberRow){
          return new Label(By.xpath("//div[@id='vuelosVuelta_"+numberRow+"']//div[@class='desc_vuelo']//div[3]//span//following-sibling::div//b"));
     }
     public Label originToDestinyDepartureTime = new Label(By.xpath("//table[@id='tbl_seleccion_ida']//td[@class='cell-cod-origen-destino salida_']//span"));
     public Label originToDestinyDeparturePlace = new Label(By.xpath("//table[@id='tbl_seleccion_ida']//td[@class='cell-cod-origen-destino salida_']//h1"));
     public Label originToDestinyArrivalTime = new Label(By.xpath("//table[@id='tbl_seleccion_ida']//td[@class='cell-cod-origen-destino llegada_']//span"));
     public Label originToDestinyArrivalPlace = new Label(By.xpath(" //table[@id='tbl_seleccion_ida']//td[@class='cell-cod-origen-destino llegada_']//h1"));
     public Label destinyToOriginDepartureTime = new Label(By.xpath("//table[@id='tbl_seleccion_vuelta']//td[@class='cell-cod-origen-destino salida_']//span"));
     public Label destinyToOriginDeparturePlace = new Label(By.xpath("//table[@id='tbl_seleccion_vuelta']//td[@class='cell-cod-origen-destino salida_']//h1"));
     public Label destinyToOriginArrivalTime = new Label(By.xpath("//table[@id='tbl_seleccion_vuelta']//td[@class='cell-cod-origen-destino llegada_']//span"));
     public Label destinyToOriginArrivalPlace = new Label(By.xpath(" //table[@id='tbl_seleccion_vuelta']//td[@class='cell-cod-origen-destino llegada_']//h1"));
     public Button buttonDeleteSelectedOutboundFlightOption = new Button(By.xpath("//table[@id='tbl_seleccion_ida']//td[@id='btn_borrar_ida']"));
     public Button buttonDeleteSelectedReturnFlightOption = new Button(By.xpath("//table[@id='tbl_seleccion_vuelta']//td[@id='btn_borrar_vuelta']"));
     public Label emptyFlightLabel = new Label(By.id("div_empty_vuelo"));
     public TextBox totalPriceInput = new TextBox(By.id("precio_total"));
     public Button adultNumberDropdown= new Button(By.xpath("//ul[@data-tipo='adulto']"));
     public Button childrenNumberDropdown = new Button(By.xpath("//ul[@data-tipo='ninho']"));
     public Button infantsNumberDropdown = new Button(By.xpath("//ul[@data-tipo='infante']"));

     public Button newOptionSelectedForDropdown(String option){
          return new Button(By.xpath("//ul[@class='active']//li[@data-count='"+option+"']"));
     }
     public Label totalPriceAdultField = new Label(By.xpath("//span[@id='precio_adulto']"));
     public Label totalPriceChildrenField = new Label(By.xpath("//span[@id='precio_ninho']"));
     public Label totalPriceInfantsField = new Label(By.xpath("//span[@id='precio_infante']"));
     public Label totalPriceTaxesField = new Label(By.xpath("//td[@id='totalTasas']"));
     public Label airportTaxPriceField = new Label(By.xpath("//div[@id='tooltip_tasas']//tr[3]//td[@class='qty']"));
     public Label ivaTaxPriceField = new Label(By.xpath("//div[@id='tooltip_tasas']//tr[6]//td[@class='qty']"));
     public Label itTaxPriceField = new Label(By.xpath("//div[@id='tooltip_tasas']//tr[9]//td[@class='qty']"));
     public Button buttonContinueShopping = new Button(By.xpath("//div[contains(@class,'btn_validar_vuelos')]"));
}
