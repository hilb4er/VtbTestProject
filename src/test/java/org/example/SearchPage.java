package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.NoSuchElementException;

public class SearchPage {
    WebDriver driver;
    WebElement strokaPoiska ,result;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void textInputAndClick (String str) throws Exception{

        try {
            strokaPoiska = driver.findElement(By.cssSelector("*[type=text]"));

        }
        catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
        strokaPoiska.sendKeys(str);
        strokaPoiska.sendKeys(Keys.ENTER);
    }

    public void checkResults() throws Exception {
        try {
            result = driver.findElement(By.id("result-stats"));
        }
        catch (NoSuchElementException ex ){
            System.out.println(ex.getMessage());
        }
        String text = result.getText();
       int number  = Integer.parseInt(text.substring(0,text.indexOf("(")).
                replaceAll("[^\\d+]"," ").replaceAll("\\s", ""));
        if (number < 1000) {
            throw  new Exception ("Количество результатов поиска меньше 1000");
        }
        System.out.println();
    }
}


