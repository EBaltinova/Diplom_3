package main;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
public class MainPage {
    private WebDriver driver;
    // Локатор до кнопки "Личный кабинет" в хедере
    private By lkButtonInHeader = By.xpath(".//p[text()='Личный Кабинет']");
    // Локатор до кнопки "Войти в аккаунт" на основной странице (Это так же кнопка "Оформить заказ" если пользователь зарегистрирован)
    private By authorizationOrOrderButtonOnMainPage = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    // Локатор до вкладки "Булки"
    private By bunTub = By.xpath(".//span[text()='Булки']");
    // Локатор до текста из заголовка "Булки"
    private By bunHeaderText = By.xpath(".//h2[text()='Булки']");
    // Локатор до вкладки "Соусы"
    private By sauceTub = By.xpath(".//span[text()='Соусы']");
    // Локатор до текста из заголовка "Соусы"
    private By sauceHeaderText = By.xpath(".//h2[text()='Соусы']");
    // Локатор до вкладки "Начинки"
    private By toppingsTub = By.xpath(".//span[text()='Начинки']");
    // Локатор до текста из заголовка "Начинки"
    private By toppingsHeaderText = By.xpath(".//h2[text()='Начинки']");
    // Локатор до кнопки "Оформить заказ"
    private By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");
    // Локатор до текста "Соберите бургер"
    private By textCreateBurger = By.xpath(".//h1[text()='Соберите бургер']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Метод для нажатия на кнопку 'Личный кабинет' в хедере")
    public void clickLkButtonInHeader() {
        driver.findElement(lkButtonInHeader).click();
    }
    @Step("Метод для нажатия на кнопку 'Личный кабинет' на основной странице")
    public void clickLkButtonInMainPage() {
        driver.findElement(authorizationOrOrderButtonOnMainPage).click();
    }
    @Step("Метод для получения текста из кнопки 'Оформить заказ'")
    public String getTextFromButtonCreateOrder() {
        new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(buttonCreateOrder).getText();
    }
    @Step("Метод для получения текста 'Соберите бургер' из конструктора")
    public String getTextCreateBurgerFromConstructor() {
        new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(textCreateBurger).getText();
    }
    @Step("Метод нажатия на вкладку 'Булки'")
    public void clickTubBunInHeader() {
        driver.findElement(bunTub).click();
    }
    @Step("Метод для получения текста 'Булки' из заголовка вкладки 'Булки'")
    public String getTextBunHeader() {
        new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(bunHeaderText).getText();
    }
    @Step("Метод нажатия на вкладку 'Соусы'")
    public void clickTubSauceInHeader() {
        driver.findElement(sauceTub).click();
    }
    @Step("Метод для получения текста 'Соусы' из заголовка вкладки 'Соусы'")
    public String getTextSauceHeader() {
        new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(sauceHeaderText).getText();
    }
    @Step("Метод нажатия на вкладку 'Начинки'")
    public void clickTubToppingsInHeader() {
        driver.findElement(toppingsTub).click();
    }
    @Step("Метод для получения текста 'Соусы' из заголовка вкладки 'Начинки'")
    public String getTextToppingsHeader() {
        new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(toppingsHeaderText).getText();
    }
}
