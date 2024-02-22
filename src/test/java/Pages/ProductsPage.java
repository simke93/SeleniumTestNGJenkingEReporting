package Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.*;


public class ProductsPage {

    public static String FormalShoes_xpath = "/html/body/div[2]/center/h2";
    public static String sportsShoes_xpath = "/html/body/div[3]/center/h2";
    public static String sneakers_xpath = "/html/body/div[4]/center/h2";

    public static String formalShoes_dropdown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportsShoes_dropdown_xpath = "/html/body/div[3]/center/div/i[1]";
    public static String sneakers_dropdown_xpath = "/html/body/div[4]/center/div/i[1]";

    public static String formalShoes_firstShoeName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";


    public static String sportsShoes_firstShoename = "/html/body/div[3]/table/tbody/tr[1]/td[1]";


    public static void formalSHoes_verifyTitle() throws IOException {
        String expectedTitleFS = "Formal Shoes";
        String actualTitleFS = driver.findElement(By.xpath(FormalShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleFS, actualTitleFS);
        if (expectedTitleFS.equals(actualTitleFS)) {
            test.log(Status.PASS, "Test passed for title verification of Formal Shoes");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
        } else if (false) {
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }
    }


    public static void sportsShoes_verifyTitle() throws IOException {
        String expectedTitleSS = "Sports Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportsShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleSS, actualTitleSS);
        if (expectedTitleSS.equals(actualTitleSS)) {
            test.log(Status.PASS, "Test passed for title verification of Sports Shoes");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Failed");
        }
    }
    public static void sneakers_verifyTitle(){
        String expectedTitleSn = "Sneakers";
        String actualTitleSn = driver.findElement(By.xpath(sneakers_xpath)).getText();
        Assert.assertEquals(expectedTitleSn, actualTitleSn);
        if (expectedTitleSn.equals(actualTitleSn)) {
            test.log(Status.PASS, "Test passed for title verification of Sneakers Shoes");
        }
    }


    public static void FormalShoes_dropdown_firstshoe_verify(){
        String expectedFirstFormalShoe = "Classic Cheltenham".trim();
        driver.findElement(By.xpath(formalShoes_dropdown_xpath)).click();
        String actualFirstFormalShoe =
                driver.findElement(By.xpath(formalShoes_firstShoeName)).getText().trim();
        Assert.assertEquals(expectedFirstFormalShoe, actualFirstFormalShoe);
        if (expectedFirstFormalShoe.equals(actualFirstFormalShoe)) {
            test.log(Status.PASS, "Test passed for first name of Formal shoe i.e Classic " +
                    "Cheltanham");
        }
    }

    public static void sportsShoes_firstshoe_verifyTitle(){
        String expectedFirstSportsShoe = "Ultimate".trim();
        driver.findElement(By.xpath(sportsShoes_dropdown_xpath)).click();
        String actualFirstSportsShoe = driver.findElement(By.xpath(sportsShoes_firstShoename)).getText().trim();
        Assert.assertEquals(expectedFirstSportsShoe, actualFirstSportsShoe);
        if (expectedFirstSportsShoe.equals(actualFirstSportsShoe)) {
            test.log(Status.PASS, "Test passed for first name of Sports shoe i.e Ultimate ");
        }


    }



}


