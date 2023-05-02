package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsTest extends BaseTest {
    HomePage homePage = new HomePage();
    CellPhonesPage cellPhonesPage = new CellPhonesPage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    SignInPage signInPage = new SignInPage();
    RegisterPage registerPage = new RegisterPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // Mouse Hover on “Electronics” Tab
        homePage.mouseHoverOnElectronics();
        // Mouse Hover on “Cell phones” and click
        homePage.clickOnCellPhones();
        //Verify the text “Cell phones”
        Assert.assertEquals(cellPhonesPage.getCellPhonesText(), "Cell phones", "Cell phones text not displayed");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()  {
        // Mouse Hover on “Electronics” Tab
        homePage.mouseHoverOnElectronics();
        // Mouse Hover on “Cell phones” and click
        homePage.clickOnCellPhones();
        // Verify the text “Cell phones”
        Assert.assertEquals(cellPhonesPage.getCellPhonesText(), "Cell phones", "Cell phones text not displayed");
        // Click on List View Tab
        cellPhonesPage.clickListTab();
        // Click on product name “Nokia Lumia 1020” link
        cellPhonesPage.clickOnNokiaLumia();
        // Verify the text “Nokia Lumia 1020”
        Assert.assertEquals(productPage.getNokiaLumiaText(), "Nokia Lumia 1020", "Nokia Lumia Text not displayed");
        // Verify the price “$349.00”
        Assert.assertEquals(productPage.getNokiaLumiaPrice(), "$349.00", "Price not $349.00");
        // Change quantity to 2
        productPage.clearQuantity();
        productPage.sendQuantity("2");
        // Click on “ADD TO CART” tab
        productPage.clickAddToCartNokia();
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals(productPage.getSuccessfullyAddedMessage(), "The product has been added to your shopping cart", "Successfully added message not displayed");
        //After that close the bar clicking on the cross button.
        productPage.closeSuccessMessage();
        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        productPage.mouseHoverOnShoppingCart();
        productPage.clickOnGoToCart();
        // Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.getShoppingCartMessage(), "Shopping cart", "Not on shopping cart");
        // Verify the quantity is 2
        Assert.assertEquals(shoppingCartPage.getQuantity(), "2", "Quantity not 2");
        // Verify the Total $698.00
        Assert.assertEquals(shoppingCartPage.getTotalPriceShoppingCart(), "$698.00", "Price not $698.00");
        // click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfService();
        // Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckout();
        // Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals(signInPage.getWelcomeText(), "Welcome, Please Sign In!", "Welcome text not displayed");
        // Click on “REGISTER” tab
        signInPage.clickOnRegister();
        // Verify the text “Register”
        Assert.assertEquals(registerPage.getRegisterText(), "Register", "Register page not displayed");
        // Fill the mandatory fields
        registerPage.enterFirstName("jigna");
        registerPage.enterLastName("Patel");
        registerPage.enterEmail("jignayp");
        registerPage.enterPassword("jigna123");
        registerPage.enterConfirmPassword("jigna123");
        //Click on “REGISTER” Button
        registerPage.clickRegisterButton();
        // Verify the message “Your registration completed”
        Assert.assertEquals(registerPage.registrationCompleteMessage(), "Your registration completed", "Register message not displayed");
    }

}
