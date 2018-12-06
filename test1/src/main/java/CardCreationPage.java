import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CardCreationPage {
    private WebDriver driver;

    public CardCreationPage(WebDriver driver) {
        this.driver = driver;

    }

    private By cardNameField = By.id("cardName");
    private By cardButton = By.xpath("//div[@class='btn-label ng-binding']");
    private String title = "testoviy candidatovich";
    private By createdCard = By.xpath("(//div[@column-id='day/2019/2/3/07']//div[@class='card__text__down ng-binding'])[1]");
    private By movedCard = By.xpath("(//div[@column-id='day/2019/2/3/08']//div[@class='card__color__border'])[1]");
    private By dropTo = By.xpath("//div[@column-id='day/2019/2/3/08']");
    private By notification = By.xpath("//div[@class='toast custom-animation toast-success']");

    private void clickCreateCardButton() {
        driver.findElement(cardButton).click();
    }

    private void setCardTitle() {
        driver.findElement(cardNameField).sendKeys(title);
    }

    public void createCard() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame("slideboard");

        setCardTitle();
        clickCreateCardButton();
        Thread.sleep(5000);
    }

    public void verifyCardCreation() {
        String message = new WebDriverWait(driver, 5).until(visibilityOfElementLocated(notification)).getText();
        System.out.println(message);
        Assert.assertEquals(message, "Succès\n" +
                "\"" + title + "\" a été créée avec succès\n" +
                "Ouvrez la carte");

    }

    public void moveCard() throws InterruptedException {
        Actions act = new Actions(driver);
        act.dragAndDrop(driver.findElement(createdCard), driver.findElement(dropTo)).build().perform();
        Thread.sleep(10000);
    }

    public void openCreatedCard()throws InterruptedException{
       driver.findElement(movedCard).click();
       Thread.sleep(2000);
    }
}