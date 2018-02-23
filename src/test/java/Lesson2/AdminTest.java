package Lesson2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\server\\chromedriver.exe");
        //sciptA();
        sciptB();

    }

    private static WebDriver getDriver (){
        WebDriver drivers = new ChromeDriver();
        return drivers;
    }

    public static void sciptA(){

        WebDriver chrome = getDriver();

        chrome.manage().window().maximize();

        chrome.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement login = chrome.findElement(By.name("email"));
        login.sendKeys("webinar.test@gmail.com");

        WebElement password = chrome.findElement(By.name("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement button = chrome.findElement(By.name("submitLogin"));
        button.click();

        WebElement dynamicElement = (new WebDriverWait(chrome, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("employee_avatar_small")));
        dynamicElement.click();

        WebElement exit = chrome.findElement(By.id("header_logout"));
        exit.click();
        chrome.close();
    }


    private static void sciptB(){
        WebDriver chrome = getDriver();

        chrome.manage().window().maximize();

        chrome.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement login = chrome.findElement(By.name("email"));
        login.sendKeys("webinar.test@gmail.com");

        WebElement password = chrome.findElement(By.name("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement button = chrome.findElement(By.name("submitLogin"));
        button.click();

        List<WebElement> elements = chrome.findElements(By.className("maintab  has_submenu"));
        for(WebElement element : elements){
            element.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(chrome.getTitle());
            chrome.navigate().refresh();
            element.isSelected();
        }

    }

}
