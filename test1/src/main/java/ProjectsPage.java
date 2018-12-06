import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProjectsPage {
    private WebDriver driver;

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;

    }

    private By slideBoardImage = By.id("img_slideboard");
    private By zzTachesDropdown = By.id("select2-chosen-2");
    private By zzTachesDropdownOption = By.id("select2-results-2");
    private By createCardButton = By.xpath("(//span[@class='add-icon'])[6]");
    private By cardColumn = By.xpath("//div[@column-id='day/2019/2/3/07']");


    public void clickSlideBoardImage() throws InterruptedException {
        driver.findElement(slideBoardImage).click();
        Thread.sleep(5000);
    }

    public void clickCreateCardButton() throws InterruptedException {
        driver.switchTo().frame("slideboard");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(cardColumn);
        action.moveToElement(we).build().perform();
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(createCardButton)).click();
        driver.switchTo().defaultContent();
        Thread.sleep(500);
    }

    public void setZzTache() throws InterruptedException {
        driver.switchTo().frame("slideboard");
        driver.findElement(zzTachesDropdown).click();
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(zzTachesDropdownOption)).click();
        driver.switchTo().defaultContent();
        Thread.sleep(1000);

    }
}