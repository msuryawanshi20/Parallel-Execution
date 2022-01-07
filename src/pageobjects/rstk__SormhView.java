package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@SalesforcePage( title="Rstk__ Sormh View"                                
               , summary=""
               , page="SormhView"
               , namespacePrefix="rstk"
               , object="rstk__sormh__c"
               , connection="QARSF_Admin"
     )             
public class rstk__SormhView {

	@TextType()
	@FindBy(xpath = "//label[normalize-space(.)='RMA Number']/parent::span/parent::th/following-sibling::td[1]//span")
	public WebElement rMANumber;
	@ButtonType()
	@FindByLabel(label = "RMA Detail Maintenance Grid")
	public WebElement rMADetailMaintenanceGrid;
	@ButtonType()
	@FindByLabel(label = "Release RMA")
	public WebElement releaseRMA;
	
}