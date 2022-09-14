package th.ac.ku.book;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddBookTests {

    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(id = "nameInput")
    private WebElement nameField;

    @FindBy(id = "authorInput")
    private WebElement authorField;

    @FindBy(id = "priceInput")
    private WebElement priceField;

    @FindBy(id = "submitButton")
    private WebElement submitButton;


    @BeforeAll
    private static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1000);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/book/add");
        PageFactory.initElements(driver, this);

    }

    @AfterEach
    public void afterEach() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }
}

