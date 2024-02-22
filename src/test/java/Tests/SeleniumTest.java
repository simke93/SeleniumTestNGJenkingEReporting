package Tests;


import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {

    public static WebDriver driver;

    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public static void Setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);

        HomePage.click_hamburger_menu();
        HomePage.click_orderProducts_link();
    }

    public static String capture(WebDriver driver) throws IOException, IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../ExecImages/" + System.currentTimeMillis()
                + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }


    @Test
    void validateTitles_OnlineProducts() throws InterruptedException, IOException {
        test = extent.createTest("Validate Shoe Titles on Products Page", "This test validates " +
                "that the different ShoeTypes are correct on Online Product Page");
        ProductsPage.formalSHoes_verifyTitle();
        ProductsPage.sportsShoes_verifyTitle();
        ProductsPage.sneakers_verifyTitle();
        extent.flush();
    }

    @Test
    void validateFirstFormalShoes(){
        test = extent.createTest("Validate First Formal Shoename", "This test validates " +
                "first formal shoes on Online Product Page");
        ProductsPage.FormalShoes_dropdown_firstshoe_verify();

    }
    @Test
    void validateFirstSportsShoe(){
        test = extent.createTest("Validate First Sport Shoename", "This test validates " +
                "first sports shoe on Online Product Page");
        ProductsPage.sportsShoes_firstshoe_verifyTitle();
    }

    @AfterSuite
    public static void cleanup(){

        extent.flush();
        driver.quit();
    }

}
