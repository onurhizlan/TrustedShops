package pages;

import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class MainPage extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @FindBy(css = "head > title")
    private WebElement getTitle;

    @FindBy(css = "span[class='sc-3a77ab16-6 kohtTt']")
    private WebElement getGrade;

    @FindBy(css = "a[class='sc-3a77ab16-10 duwcXP']")
    private WebElement gradeInformationLink;

    @FindBy(css = "span[class='Modalstyles__ModalTitle-sc-10yc67r-1 Kqdoz']")
    private WebElement reviewsTitle;

    @FindBy(xpath = "(//div[@class='sc-1c6045e2-2 jqbmOX'])[1]")
    private WebElement reviewsContent;

    @FindBy(xpath = "(//pre[@class='sc-1c6045e2-1 igseOi'])[1]")
    private WebElement rating;

    @FindBy(xpath = "(//div[@class='sc-1c6045e2-2 jqbmOX'])[2]")
    private WebElement ratingContent;

    @FindBy(xpath = "(//pre[@class='sc-1c6045e2-1 igseOi'])[2]")
    private WebElement authenticCustomerRatings;

    @FindBy(xpath = "(//pre[@class='sc-1c6045e2-1 igseOi'])[2]//following::div[1]")
    private WebElement authenticCustomerRatingsContent;

    @FindBy(css = "span[class='Iconstyles__Icon-sc-hltmf-0 gPhzdv Modalstyles__CloseIcon-sc-10yc67r-3 ijctcv hls hls-icon-action-dismiss")
    private WebElement closeGradeInfoScreen;

    @FindBy(css = "a[href*='stars=2'] > div:nth-child(2)")
    private WebElement twoStar;

    @FindBy(css = "span[class='Iconstyles__Icon-sc-hltmf-0 hhdSsN  hls hls-icon-arrow-chevron-right']")
    private WebElement nextPageButton;

    @FindBy(css = "div[class='sc-2e7612c5-0 sc-f836bc46-0 kyZgbN chcERM']")
    private WebElement starComments;


    public void pageTitle() {
        getTitle.isEnabled();
        Assert.assertEquals("Bewertungen zu Jalousiescout.de | Lesen Sie 147.087 Bewertungen zu Jalousiescout.de", driver.getTitle().replaceAll(" ", " "));
        System.out.println("Title is exist");
    }

    public void checkGrade() {
        wait.until(ExpectedConditions.visibilityOf(getGrade));
        String gradeText = getGrade.getText();
        String grade = gradeText.replace(",", ".");
        System.out.println("Grade: " + grade);
        float asd = Float.parseFloat(grade);

        Assert.assertTrue(asd > 0);
    }

    public void gradeInformation() {
        gradeInformationLink.click();

        String getReviewTitle = reviewsTitle.getText();
        Assert.assertEquals("Lesen Sie die Bewertungen anderer Kundinnen und Kunden von Jalousiescout.de als Orientierungshilfe!", getReviewTitle);

        String getReviewsContent = reviewsContent.getText();
        Assert.assertEquals("Jeder Service von Jalousiescout.de kann mit bis zu 5 Sternen bewertet werden. Die Bewertungen beziehen " +
                "sich auf Erfahrungen mit Jalousiescout.de, die zum Zeitpunkt der Bewertungsabgabe nicht länger als 6 Monate zurückliegen. " +
                "Aus dem einfachen Durchschnitt der Bewertungsnoten aller Bewertungen der letzten 12 Monate wird anschließend eine Gesamtnote " +
                "berechnet. In Kommentaren teilen Kundinnen und Kunden ihre Erfahrungen in eigenen Worten mit.\n\n" +
                "Es gelten die Nutzungsbedingungen des Bewertungssystems.", getReviewsContent);

        String getRating = rating.getText();
        Assert.assertEquals("Notenberechnung auf Basis der Sternevergabe", getRating);

        String getRatingContent = ratingContent.getText();
        Assert.assertEquals("5.00 - 4.50 Sehr gut\n" +
                "4.49 - 3.50 Gut\n" +
                "3.49 - 2.50 Befriedigend\n" +
                "2.49 - 1.50 Ausreichend\n" +
                "1.49 - 1.00 Mangelhaft", getRatingContent);

        String getAuthenticCustomerRatings = authenticCustomerRatings.getText();
        Assert.assertEquals("Authentische Kundenbewertungen für mehr Vertrauen", getAuthenticCustomerRatings);

        String getAuthenticCustomerRatingsContent = authenticCustomerRatingsContent.getText();
        Assert.assertEquals("Trusted Shops ist die führende Vertrauensmarke für Online-Shopping in Europa. " +
                "Sämtliche Bewertungen von Jalousiescout.de prüft Trusted Shops mittels maschineller und manueller Kontrollen, " +
                "denn nur authentische Rezensionen sind eine echte Einkaufshilfe.", getAuthenticCustomerRatingsContent);

        System.out.println("Grade calculation contents are correct");
        closeGradeInfoScreen.click();
    }

    public void checkTwoStars(){
        wait.until(ExpectedConditions.visibilityOf(starComments));
        List<WebElement> twoStarReviews = driver.findElements(By.xpath("//div[@class='sc-2e7612c5-0 sc-f836bc46-0 kyZgbN chcERM']"));

        for (int i = 1; i <= twoStarReviews.size(); i++) {
            try {
                int getStarPoint = driver.findElements(By.xpath("//div[@class='sc-2e7612c5-0 sc-f836bc46-0 kyZgbN chcERM']["+ i +"]//child::span[@style='display: inline; color: rgb(255, 220, 15);']")).size();

                Assert.assertEquals(getStarPoint, 2);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void twoStarsReviews() throws InterruptedException {
        twoStar.click();

        while (true) {
            try {
                checkTwoStars();
                scrollToElement(nextPageButton);
                nextPageButton.click();
            } catch (Exception e) {
                break;
            }
        }
        System.out.println("All Reviews have 2 Star");
    }

    public void  sumOfAllStars() {
        int sumOfAllStar = 0;
        List<WebElement> allStars = driver.findElements(By.xpath("//div[@class='sc-61f2e426-8 iMXstX']"));

        for (int i = 1; i <= allStars.size(); i++) {
            try {
                String getAllStars = "(//div[@class='sc-61f2e426-8 iMXstX'])[%s]//child::span[1]";
                WebElement element = driver.findElement(By.xpath(String.format(getAllStars, i)));

                String getStars = element.getText();
                String stars = getStars.replace("< ", "");

                int parseStars = Integer.parseInt(String.valueOf(stars));
                sumOfAllStar += parseStars;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Sum Of All Stars: " + sumOfAllStar);
        Assert.assertTrue(sumOfAllStar < 101);
    }
}
