package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CellPhonesPage extends Utility {
    By cellPhonesText = By.xpath("//h1[contains(text(),'Cell phones')]");
    By listTab = By.xpath("//a[@class='viewmode-icon list']");
    By productNokiaLumiaLink = By.linkText("Nokia Lumia 1020");

    public String getCellPhonesText(){
        return getTextFromElement(cellPhonesText);
    }
    public void clickListTab(){
        clickOnElement(listTab);
    }
    public void clickOnNokiaLumia(){
        clickOnElement(productNokiaLumiaLink);
    }
}
