package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {

        // * Mouse Hover on Women Menu
        mouseHover(By.xpath("//span[contains(text(),'Women')]"), By.xpath("//span[contains(text(),'Women')]"));

        //* Mouse Hover on Tops
        //mouseHover(By.xpath("//ul[@style='display: block; top: 46.8px; left: -0.412506px;']//span[text()='Tops']"),By.xpath("//ul[@style='display: block; top: 46.8px; left: -0.412506px;']//span[text()='Tops']"));
        mouseHover(By.linkText("Tops"), By.linkText("Jackets"));

        //* Click on Jackets
        //clickOnElement(By.xpath("//ul[@style='display: block; top: 46.8px; left: -0.412506px;']//span[text()='Jackets']"));
        clickOnElement(By.xpath("//strong[contains(text(),'Jackets')]"));

        //* Select Sort By filter “Product Name”
        selectByValue(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"), "name");

        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/a[1]"));


        //* Verify the products name display in alphabetical order
        String expectedText = "Set Ascending Direction";
        String actualText = getTextFromElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/a[1]"));
        Assert.assertEquals("Message not found", expectedText, actualText);
    }


    @Test
    public void verifyTheSortByPriceFilter() {

        // Mouse Hover on Women Menu
        mouseHover(By.xpath("//span[contains(text(),'Women')]"), By.xpath("//span[contains(text(),'Women')]"));

        //* Mouse Hover on Tops
        //mouseHover(By.xpath("//ul[@style='display: block; top: 46.8px; left: -0.412506px;']//span[text()='Tops']"),By.xpath("//ul[@style='display: block; top: 46.8px; left: -0.412506px;']//span[text()='Tops']"));
        mouseHover(By.linkText("Tops"), By.linkText("Jackets"));

        //* Click on Jackets
        //clickOnElement(By.xpath("//ul[@style='display: block; top: 46.8px; left: -0.412506px;']//span[text()='Jackets']"));
        clickOnElement(By.xpath("//strong[contains(text(),'Jackets')]"));

        //Select Sort By filter “Price”
        selectByValue(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"),"price");

        //mouseHover(By.linkText("Set Ascending Direction"),By.linkText("Set Ascending Direction"));
        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/a[1]"));

        //Verify the products price display in Low to High
        String expectedText = "Set Ascending Direction";
        String actualText = getTextFromElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/a[1]"));
        Assert.assertEquals("Message not found", expectedText, actualText);




    }

    @After
    public void tearDown() {
        driver.quit();
    }
}






