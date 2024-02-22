import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IndexPageTest {
    private ChromeDriver chromeDriver;
    @BeforeEach
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeDriver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void close() {
        chromeDriver.close();
    }
    @Test
    public void expectIndexPageToContainHeading() {
        chromeDriver.get(System.getenv("WEB_APP_URL"));
        assertThat(heading()).isEqualTo("Office Lunch");
    }

    private String heading() {
        return chromeDriver.findElement(By.id("title")).getText();
    }
}
