import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class Googlebrowser {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private String pageUrl = "https://www.google.com/";
    private String expectedTitle = "Google";
    private String actualTitle = "";
    private String search = "melania trump";

    private By searchField = By.name("q");

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);

        driver.get(pageUrl);
        driver.findElement(searchField).sendKeys(search);
        driver.findElement(searchField).sendKeys(Keys.ENTER);

    }

        @Test
        public void test() {

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    }





