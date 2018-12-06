import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;

    }

    private By userNameField = By.id("userName");
    private By passwordField = By.id("passWord");
    private By domainNameField = By.id("domainName");
    private By submitButton = By.xpath("//input[@type='submit']");

    public SignUpPage setUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public SignUpPage setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage setDomainName(String domainName) {
        driver.findElement(domainNameField).clear();
        driver.findElement(domainNameField).sendKeys(domainName);
        return this;
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}

