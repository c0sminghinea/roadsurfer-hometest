package pages;

import org.openqa.selenium.By;

public class BookingPage {

    public static By locationDropdown = By.cssSelector("span.search-input--value");
    public static By dateMenu = By.xpath("//span[normalize-space()='From']");
    public static By searchButton = By.cssSelector(".button.button--v2.h-12");
    public static By acceptCookiesButton = By.cssSelector("button[role='button']");
    public static By shadowRootHost = By.id("usercentrics-root");
    public static By dropOffField = By.cssSelector(".search-return");
    public static By camperResult = By.cssSelector(".result-card");
    public static By cityList = By.cssSelector("ul.stations-list li.station-item");
    public static By calendarContainer = By.cssSelector(".calendar__date-container");
    public static By availableDates = By.cssSelector(".calendar__date-container:not(.is-disabled):not(.is-off-month)");
}
