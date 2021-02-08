import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.epam.reportportal.junit5.ReportPortalExtension;

@ExtendWith(ReportPortalExtension.class)
public class JunitTest {

    private static final Logger LOGGER = LogManager.getLogger(JunitTest.class);

    @BeforeEach
    void setUp() {
        Configuration.driverManagerEnabled = false;
        Configuration.browser = CustomProvider.class.getName();
    }

    @Test
    public void addition() {
        LOGGER.info("Test started");
        assertThat(1 + 1, equalTo(2));
    }

    @Test
    public void googlePage() {
        LOGGER.info("Test started");
        open("http://google.com");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
        $(By.name("q")).shouldBe(Condition.visible);
        $(By.name("btnK")).shouldBe(Condition.exist);
    }
}
