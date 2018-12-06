import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TestScenario {
    private WebDriver driver;
    private SignUpPage signUpPage;
    private ProjectsPage projectsPage;
    private CardCreationPage cardCreationPage;
    private CardDetailsPage cardDetailsPage;

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\A.Perepadya\\git\\Tantalum\\exe\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://chewie.one2team.com");

    }

    @Test
    public void testScenario() throws InterruptedException, AWTException {

        signUpPage = new SignUpPage(driver);
        projectsPage = new ProjectsPage(driver);
        cardCreationPage = new CardCreationPage(driver);
        cardDetailsPage = new CardDetailsPage(driver);

        signUpPage.setUserName("candidat ")
                .setPassword("Candidat1*")
                .setDomainName("telco")
                .clickSubmitButton();
        Thread.sleep(5000);

        projectsPage.clickSlideBoardImage();
        projectsPage.setZzTache();
        projectsPage.clickCreateCardButton();
        cardCreationPage.createCard();
        cardCreationPage.verifyCardCreation();
        cardCreationPage.moveCard();
        cardCreationPage.openCreatedCard();
        cardDetailsPage.clickDocumentsTab();
        cardDetailsPage.uploadDocument();
        cardDetailsPage.verifyUploadedFileName();
        Thread.sleep(5000);

    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }
}
