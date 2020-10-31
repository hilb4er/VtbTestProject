package org.example;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class VtbTest {

    private static ChromeDriver driver;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @Test
    public void SearchTest() throws Exception {

        SearchPage objLogin = new SearchPage(driver);
        objLogin.textInputAndClick("Расследование");
        System.out.println();
        objLogin.checkResults();

    }
    @AfterClass
    public static void  after (){
        driver.quit();
    }
}
