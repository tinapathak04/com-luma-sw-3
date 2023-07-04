package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){

        //Mouse Hover on Gear Menu
        mouseHover(By.xpath("//span[contains(text(),'Gear')]"),By.xpath("//span[contains(text(),'Gear')]"));
       // mouseHover(By.xpath("//span[contains(text(),'Bags')]"),By.xpath("//span[contains(text(),'Bags')]"));

        //Click on Bags
        clickOnElement(By.linkText("Bags"));

        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        //Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        Assert.assertEquals("Message not found", expectedText, actualText);

        //Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");

        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1 = getTextFromElement(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        Assert.assertEquals("Message not found", expectedText1, actualText1);


        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));


//        //Verify the product name ‘Cronus Yoga Pant’
//        String expectedText2 = "Cronus Yoga Pant";
//        String actualText2 = getTextFromElement(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/strong[1]/a[1]"));
//        Assert.assertEquals("Message not found", expectedText2, actualText2);


        //Verify the Qty is ‘3’
//        String expectedText3 = "3";
//        String actualText3 = getTextFromElement(By.xpath("//span[@class='counter-number']"));
//        Assert.assertEquals("Message not found", expectedText3, actualText3);


        //Verify the product price ‘$135.00’
        String expectedText4 = "$135.00";
        String actualText4 = getTextFromElement(By.xpath("//span[@data-bind='text: getValue()']"));
        Assert.assertEquals("Message not found", expectedText4, actualText4);

        //Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextToElement(By.xpath("//input[@class='input-text qty']"),"5");


        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        //Verify the product price ‘$225.00’
        String expectedText5 = "$225.00";
        String actualText5 = getTextFromElement(By.xpath("//td[@class='col subtotal']//span[text()='$225.00']"));
        Assert.assertEquals("Message not found", expectedText4, actualText4);



    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
