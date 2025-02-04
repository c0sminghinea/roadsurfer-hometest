package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BookingPage;
import resources.Constants;
import resources.Language;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BookingSteps {
    private final WebDriverWait wait;
    private final WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(BookingSteps.class);

    public BookingSteps(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    private void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }

    @Step("Given I navigate to the Roadsurfer homepage")
    public void navigateTo() {
        driver.get(Constants.BOOKING_URL);
        try {
            WebElement shadowHost = driver.findElement(BookingPage.shadowRootHost);
            WebElement acceptCookiesButton = shadowHost.getShadowRoot()
                    .findElement(BookingPage.acceptCookiesButton);
            acceptCookiesButton.click();
        } catch (NoSuchElementException | TimeoutException e) {
            logger.error("Failed to find or interact with shadow DOM element: ", e);
        }
    }

    @Step("When I select pick-up & drop-off location")
    public void openLocationDropdown() {
        clickButton(BookingPage.locationDropdown);
    }

    public boolean clickRandomCity() {
        List<WebElement> cities = driver.findElements(BookingPage.cityList);
        Random random = new Random();
        int randomIndex = random.nextInt(cities.size());
        WebElement randomCity = cities.get(randomIndex);
        String cityName = randomCity.getText();
        randomCity.click();
        return cityName.contains(Language.oneWay);
    }

    public void selectDifferentDropOff() {
        clickButton(BookingPage.dropOffField);
    }

    @Step("And I select a start date and an end date")
    public void selectDateOnCalendar() {
        clickButton(BookingPage.dateMenu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BookingPage.calendarContainer));
        List<WebElement> dates = driver.findElements(BookingPage.availableDates);
        selectDate(dates, 0);
        selectDate(dates, 5);
    }

    private void selectDate(List<WebElement> dates, int index) {
        if (index < dates.size()) {
            dates.get(index).click();
        }
    }

    @Step("And I submit the search for available campers")
    public void submitSearch() {
        clickButton(BookingPage.searchButton);
    }

    @Step("Then I will see a list that contains at least 2 different camper models")
    public void checkCamperResults() {
        List<WebElement> camperListing = driver.findElements(BookingPage.camperResult);
        assertTrue(camperListing.size() >= 2, "Expected at least 2 campers but found: " + camperListing.size());
    }
}
