package de.teamLocster.user;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

public class UITest {
    private WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    void tearDown() {driver.quit();}

    @Test
    void signUpTest() {
        driver.get("http://localhost:8080/signup");

        String firstNameInput = "Max";
        String lastNameInput = "Mustermann";
        String birthDateInput = "01.04.1991";
        String sexInput = "männlich";
        String emailInput = "max.mustermann@fh-erfurt.de";
        String passwordInput = "Hallo123.@!";

        WebElement firstName = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/input[1]"));
        WebElement lastName = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/input[2]"));
        WebElement birthDate = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/input[3]"));
        WebElement sex = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/input[4]"));
        WebElement email = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/input[5]"));
        WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/input[6]"));
        WebElement passwordValidator = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/input[7]"));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[2]/div/button"));

        firstName.sendKeys(firstNameInput);
        lastName.sendKeys(lastNameInput);
        birthDate.sendKeys(birthDateInput);
        sex.sendKeys(sexInput);
        email.sendKeys(emailInput);
        password.sendKeys(passwordInput);
        passwordValidator.sendKeys(passwordInput);

        submitButton.click();


    }

    @Test
    void logInTest() {
        driver.get("http://localhost:8080/login");

        String emailInput = "monika@normal.de";
        String passwordInput = "MeinGeilesPassword123!";


        WebElement email = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[1]/input[1]"));
        WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[1]/input[2]"));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[2]/div[2]/button"));

        email.sendKeys(emailInput);
        password.sendKeys(passwordInput);


        submitButton.click();


    }

}
