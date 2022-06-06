package RS_Home_page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticePage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, 12);
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);

    //Buttons
    @FindBy(css = "input[value='radio2']")
    private WebElement radioButton2;
    @FindBy(css = "option[value='option3']")
    private WebElement dynamicDropDownOption3;
    @FindBy(id = "autocomplete")
    private WebElement staticDropDown;
    @FindBy(id = "checkBoxOption2")
    private WebElement checkbox2;
    @FindBy(id = "openwindow")
    private WebElement switchWindow;
    @FindBy(css = "a[class='btn-style class1 class2']")
    private WebElement openAlertButton;
    // WINDOWS AND ALERTS
    @FindBy(id = "name")
    private WebElement alertField;
    @FindBy(id = "alertbtn")
    private WebElement alertButton;
    @FindBy(id = "confirmbtn")
    private WebElement confirmButton;
    //SHOW HIDE
    @FindBy(id = "hide-textbox")
    private WebElement hideButton;
    @FindBy(id = "show-textbox")
    private WebElement showButton;
    // TABLE TO SCROLL
    @FindBy(css = "div[class='tableFixHead']")
    private WebElement table;


    public AutomationPracticePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRadioButton2() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='radio2']")));
        radioButton2.click();
    }

    public void selectDynamicDropDownOption3() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='option3']")));
        dynamicDropDownOption3.click();
    }

    public String selectStaticDropDown(String option) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete")));
        staticDropDown.sendKeys(option);
        Thread.sleep(1000);
        staticDropDown.sendKeys(Keys.DOWN);
        staticDropDown.sendKeys(Keys.RETURN);
        return option;
    }

    public void selectCheckBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkBoxOption2")));
        checkbox2.click();
    }

    public void clickOnSwitchWindow() {
        jse.executeScript("window.scrollTo(0,100);"); //to be able click button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openwindow")));
        switchWindow.click();

    }

    public void clickOnOpenTabButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='btn-style class1 class2']")));
        openAlertButton.click();
    }

    public String switchToAlertField(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        alertField.sendKeys(name);
        return name;
    }

    public void clickOnAlertBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertbtn")));
        alertButton.click();
    }

    public void clickOnConfirmBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmbtn")));
        confirmButton.click();
    }

    public void clickOnHideButton() {
        jse.executeScript("window.scrollTo(0,500);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hide-textbox")));
        hideButton.click();

    }

    public void clickOnShowButton() {
        jse.executeScript("window.scrollTo(0,500);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("show-textbox")));
        showButton.click();
    }

    public void scrollTable() {
        jse.executeScript("window.scrollTo(0,600);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='tableFixHead']")));
        WebElement tableElement = driver.findElement(By.cssSelector("div[class='tableFixHead']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", tableElement);
    }

    public void hoverOnHoverButton() {
        jse.executeScript("window.scrollTo(0,850);");
        WebElement ele = driver.findElement(By.id("mousehover"));
        Actions action = new Actions(driver);
        action.moveToElement(ele).pause(1).build().perform();
        WebElement ele2 = driver.findElement(By.cssSelector("a[href='#top']"));
        action.moveToElement(ele2).click().perform();

    }

    public void iFrameScroll() {
        jse.executeScript("window.scrollTo(0,1000);");
        WebElement iFrameEl = driver.findElement(By.cssSelector("fieldset #courses-iframe"));
        driver.switchTo().frame(iFrameEl);
        driver.findElement(By.cssSelector("div .login-btn a ")).click();
    }
}



