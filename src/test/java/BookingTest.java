import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.BookingSteps;
import utils.BaseTest;

public class BookingTest extends BaseTest {
    private BookingSteps bookingSteps;

    @BeforeClass
    public void initializeSteps() {
        bookingSteps = new BookingSteps(driver);
    }

    @Test(description = "Search for available campers by location and date")
    public void bookingFlow() {
        bookingSteps.navigateTo();
        bookingSteps.openLocationDropdown();
        boolean isOneWay = bookingSteps.clickRandomCity();
        if (isOneWay) {
            bookingSteps.selectDifferentDropOff();
            bookingSteps.clickRandomCity();
        }
        bookingSteps.selectDateOnCalendar();
        bookingSteps.submitSearch();
        bookingSteps.checkCamperResults();
    }
}