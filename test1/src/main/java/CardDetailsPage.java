import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CardDetailsPage {
    private WebDriver driver;

    public CardDetailsPage(WebDriver driver) {
        this.driver = driver;

    }

    private By documentsTab = By.xpath("//div[@o2t-title='Document(s)']");
    private By uploadedDocument = By.xpath("//span[@class='file-name ng-binding']");
    private By documentAddButton = By.xpath("(//div[@class='field-file-add'])[1]");
    private String filePath = "..\\test1\\src\\main\\resources\\testFile.txt";

    public void clickDocumentsTab() {
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(documentsTab)).click();
    }

    public void uploadDocument() throws InterruptedException, AWTException {

        File fileToUpload = new File(filePath);
        String absolutePath = fileToUpload.getAbsolutePath();
        StringSelection sel = new StringSelection(absolutePath);

        // Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(documentAddButton)).click();
        // Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(1000);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);

// Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

// Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);

        //Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(3000);
    }

    public void verifyUploadedFileName() {

        String file = driver.findElement(uploadedDocument).getAttribute("innerHTML");
        System.out.println(file);
        Assert.assertEquals(file, "testFile.txt");
        System.out.println("Filename matches!!");
    }
}