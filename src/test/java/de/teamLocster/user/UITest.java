package de.teamLocster.user;

import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.Sex;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.RelationshipStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import de.teamLocster.enums.Sex;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

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

    @Autowired
    UserRepository userRepository;

    @Test
    void signUpTest() {
        driver.get("http://localhost:8080/signup");

        String firstNameInput = "Max";
        String lastNameInput = "Mustermann";
        String birthDateInput = "1990-07-19";
        String sexInput = "männlich";
        String emailInput = "max.mustermann@fh-erfurt.de";
        String passwordInput = "Hallo123.@!";

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        WebElement birthDate = driver.findElement(By.xpath("//*[@id=\"birthday\"]"));
        WebElement sex = driver.findElement(By.xpath("//*[@id=\"sex\"]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"emailAddress\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement passwordValidator = driver.findElement(By.xpath("//*[@id=\"passwordRepeat\"]"));
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
        String passwordInput = "Hallo123.@!";


        WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"login-submit\"]"));

        email.sendKeys(emailInput);
        password.sendKeys(passwordInput);


        submitButton.click();
    }

}
