package com.juaracoding.fauziujian3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ujian3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\Juara Coding SQA\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String txtHeader = driver.findElement(By.cssSelector(".login_logo")).getText();
        System.out.println(txtHeader);

        //Positive Case
        ///Login
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        System.out.println("Login Success");
        delay(3);
        ///Addtochart
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        delay(3);
        driver.findElement(By.id("shopping_cart_container")).click();
        delay(3);
        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
        System.out.println("Add to Cart Success");
        delay(3);
        ///Logout
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        delay(3);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        delay(3);
        System.out.println("Logout Success");

        //Negative Case
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String txtLoginError = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        System.out.println(txtLoginError);
        assertEquals(txtLoginError,"is required");
        delay(3);
        driver.quit();


    }

    static void delay (long detik){
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void assertEquals(String actual, String expected){
        if(actual.contains(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }




}
