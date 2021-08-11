import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class pragmaticRegistrationTest {

    public static WebDriver driver;

    @BeforeMethod
    public static void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\WEB Browser Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg");
    }

    @Test
    public void myAccountReg () {

        WebElement myAccountField = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
        myAccountField.click();

        WebElement registerField = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        registerField.click();

        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
        firstNameField.sendKeys("Preslava");

        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
        lastNameField.sendKeys("Tasheva");

        WebElement emailField = driver.findElement(By.id("input-email"));
        emailField.sendKeys("preslavast@preslava.bg");

        WebElement telephoneField = driver.findElement(By.id("input-telephone"));
        telephoneField.sendKeys("123654789");

        WebElement createPasswordField = driver.findElement(By.id("input-password"));
        createPasswordField.sendKeys("123parola456*");

        WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
        confirmPasswordField.sendKeys("123parola456*");

        WebElement checkBoxdField = driver.findElement(By.name("agree"));
        checkBoxdField.click();

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        continueButton.click();

        WebElement confirmation = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        String confirmationText = confirmation.getText();

        Assert.assertEquals(confirmationText, "Your Account Has Been Created!");
    }

    @AfterMethod
    public static void quitBrowser() {
        driver.quit();
    }
    
}
