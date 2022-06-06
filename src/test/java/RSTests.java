
import RS_Home_page.AutomationPracticePage;
import RS_Home_page.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Iterator;
import java.util.Set;


public class RSTests extends BaseTest {

    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @Test
    public void demoQaTask() throws InterruptedException {

        AutomationPracticePage app = new AutomationPracticePage(driver);
        Assert.assertEquals(driver.getTitle(), Constants.EXPECTED_TITLE);

        app.clickOnRadioButton2();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='radio2']")).isSelected());

        String staticDropDownOption = "Arm";
        app.selectStaticDropDown(staticDropDownOption);
        Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value").startsWith(staticDropDownOption), true);

        app.selectDynamicDropDownOption3();
        Assert.assertTrue(driver.findElement(By.cssSelector("option[value='option3']")).isSelected());

        app.selectCheckBox();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption2")).isSelected());

    }

    @Test
    public void openWindows() {

        AutomationPracticePage app = new AutomationPracticePage(driver);
        app.clickOnSwitchWindow();

        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                Assert.assertEquals(driver.switchTo().window(child_window).getTitle(),
                        Constants.NEW_WINDOWS_TITLE);
                driver.close();
            }
        }
        driver.switchTo().window(parent);
    }

    @Test
    public void switchToTabe() {
        AutomationPracticePage app = new AutomationPracticePage(driver);
        app.clickOnOpenTabButton();
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
        Assert.assertEquals(driver.getTitle(), Constants.EXPECTED_OPEN_TAB_TITLE);
    }

    @Test
    public void openAlert() {
        AutomationPracticePage app = new AutomationPracticePage(driver);

        String name = app.switchToAlertField("Artur");
        Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("value"), name);
        app.clickOnAlertBtn();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(name));
        alert.accept();

    }

    @Test
    public void confirmAlert() {
        AutomationPracticePage app = new AutomationPracticePage(driver);
        String name2 = app.switchToAlertField("Madoyan");
        Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("value"), name2);
        app.clickOnConfirmBtn();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(name2));
        alert.accept();

    }

    @Test
    public void hideButton() {
        AutomationPracticePage app = new AutomationPracticePage(driver);
        app.clickOnHideButton();
        String st = (String) jse.executeScript("return " +
                "document.getElementById('displayed-text').getAttributeNode('style').value");
        Assert.assertEquals(st, "display: none;");
    }

    @Test
    public void showButton() {
        AutomationPracticePage app = new AutomationPracticePage(driver);
        app.clickOnShowButton();
        String st = (String) jse.executeScript("return " +
                "document.getElementById('displayed-text').getAttributeNode('style').value");
        Assert.assertEquals(st, "display: block;");
    }

    @Test
    public void scrollTable() {
        AutomationPracticePage app = new AutomationPracticePage(driver);
        app.scrollTable();
    }

    @Test
    public void hoverOnButton() {
        AutomationPracticePage app = new AutomationPracticePage(driver);
        app.hoverOnHoverButton();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.EXPECTED_URL_TOP_TITLE);
    }

    @Test
    public void scrollIFrame() {
        AutomationPracticePage app = new AutomationPracticePage(driver);
        app.iFrameScroll();
        Assert.assertTrue(driver.findElement(By.id("sub-frame-error")).isDisplayed());
    }
}