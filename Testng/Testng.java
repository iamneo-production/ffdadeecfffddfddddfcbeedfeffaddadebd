import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FlipkartLinkTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testCountLinksOnHomePage() {
        // Open the Flipkart website
        driver.get("https://flipkart.com");

        // Find all the links on the homepage
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Get the count of links
        int linkCount = links.size();

        // Assert the link count is greater than 0
        Assert.assertTrue(linkCount > 0, "No links found on the homepage.");
        System.out.println("Number of links on the homepage: " + linkCount);
    }

    @Test
    public void testPrintLinkTextAndURLs() {
        // Open the Flipkart website
        driver.get("https://flipkart.com");

        // Find all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Print link text and URLs
        for (WebElement link : links) {
            String linkText = link.getText();
            String linkURL = link.getAttribute("href");
            System.out.println("Link Text: " + linkText);
            System.out.println("Link URL: " + linkURL);
            System.out.println("----------------------------");
        }
    }

    @AfterMethod
    public void tearDown() {
        // Quit the browser
        driver.quit();
    }
}
