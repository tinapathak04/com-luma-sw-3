package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){

        //Mouse Hover on Men Menu
        mouseHover(By.xpath("//span[contains(text(),'Men')]"),By.xpath("//span[contains(text(),'Men')]"));
        //Mouse Hover on Bottoms
        mouseHover(By.linkText("Bottoms"),By.linkText("Pants"));
        //Click on Pants
        clickOnElement(By.xpath("//strong[contains(text(),'Pants')]"));

        //Mouse Hover on product name 'Cronus Yoga Pant’ and click on size 32.
        mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"),By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"),By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.
        mouseHover(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"),By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));

        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//body/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]"));
        Assert.assertEquals("Message not found", expectedText, actualText);

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //Verify the text ‘Shopping Cart.’
        String expectedText1 = "Shopping Cart";
        String actualText1 = getTextFromElement(By.xpath("//body/div[1]/main[1]/div[1]/h1[1]/span[1]"));
        Assert.assertEquals("Message not found", expectedText1, actualText1);

        //Verify the product name ‘Cronus Yoga Pant’
        String expectedText2 = "Cronus Yoga Pant";
        String actualText2 = getTextFromElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]"));
        Assert.assertEquals("Message not found", expectedText2, actualText2);

        //Verify the product size ‘32’
        String expectedText3 = "32";
        String actualText3 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("Message not found", expectedText3, actualText3);

        //Verify the product colour ‘Black’
        String expectedText4 = "Black";
        String actualText4 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Message not found", expectedText4, actualText4);



    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
