package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@SalesforcePage( title="Rstk__ Sormamassentry"                                
               , summary=""
               , page="SormaMassEntry"
               , namespacePrefix="rstk"
               , object="rstk__sormh__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Sormamassentry {

	@ButtonType()
	@FindBy(xpath = "//span[2]/input[@id='newRmaDetail_add']")
	public WebElement add;

	@PageRow()
	public static class RMADetailMaintenanceGrid {

		@TextType()
		@FindBy(xpath = ".//td[2]/span/input")
		public WebElement product;

		@TextType()
		@FindBy(xpath = ".//td[3]/input")
		public WebElement quantityAuthorized;

		@ChoiceListType()
		@FindBy(xpath = ".//td[4]/select")
		public WebElement reasonForReturn;

		@TextType()
		@FindBy(xpath = "//li[@id='li-0']")
		public WebElement list;

		@TextType()
		@FindBy(xpath = ".//td[5]/span[1]/input")
		public WebElement salesOrderLine;

		@TextType()
		@FindBy(xpath = ".//td[6]/span[1]/input")
		public WebElement shipperLine;

		@ChoiceListType()
		@FindBy(xpath = ".//td[7]/select")
		public WebElement action;

		@TextType()
		@FindBy(xpath = ".//td[8]//input")
		public WebElement dateIssued;

		@TextType()
		@FindBy(xpath = ".//td[10]/span[1]/input")
		public WebElement receiveToSite;
		

	}

	@FindBy(xpath = "//tbody[contains(@id,'gridTable')]//tr")
	@PageTable(firstRowContainsHeaders = false, row = RMADetailMaintenanceGrid.class)
	public List<RMADetailMaintenanceGrid> rMADetailMaintenanceGrid;
	@ButtonType()
	@FindByLabel(label = "Save")
	public WebElement save;

}
