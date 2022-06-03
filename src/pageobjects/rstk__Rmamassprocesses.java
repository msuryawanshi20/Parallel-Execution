package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.PageRow;
import com.provar.core.testapi.annotations.PageTable;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.TextType;

@SalesforcePage( title="Rstk__ Rmamassprocesses"                                
               , summary=""
               , page="Rmamassprocesses"
               , namespacePrefix="rstk"
               , object="rstk__sormh__c"
               , connection="QARSF_Admin"
     )             
public class rstk__Rmamassprocesses {

	@PageRow()
	public static class RMAMassShipmetTable {

		@BooleanType()
		@FindBy(xpath = ".//input")
		public WebElement selected;
		
		@TextType()
		@FindBy(xpath = ".//td[3]/span/a")
		public WebElement product;
		
	}

	@FindBy(xpath = "//tbody[contains(@id,'rmashipment')]//tr")
	@PageTable(firstRowContainsHeaders = false, row = RMAMassShipmetTable.class)
	public List<RMAMassShipmetTable> rMAMassShipmetTable;
	
}
