package profile;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
public class ProfilePage {
    private WebDriver driver;
    // Локатор до кнопки "Профиль"
    private By buttonProfile = By.xpath(".//a[text()='Профиль']");
    // Локатор до кнопки "Конструктор"
    private By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    // Локатор до логотипа "Stellar Burgers"
    private By logoStellarBurgers = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //Локатор до кнопки "Выход" в профиле
    private By buttonLogout = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    // Метод получения текста из кнопки "Профиль"
    public String getTextFromButtonProfile() {
        new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(buttonProfile).getText();
    }
    @Step("Метод для нажатия на кнопку 'Конструктора' из профиля")
    public void clickConstructorButtonInProfilePage() {
        driver.findElement(buttonConstructor).click();
    }
    @Step("Метод для нажатия на лого 'Stellar Burgers' из профиля")
    public void clickLogoStellarBurgersInProfilePage() {
        driver.findElement(logoStellarBurgers).click();
    }
    @Step("Метод для нажатия на кнопку 'Выход' из профиля")
    public void clickLogoutButtonInProfilePage() {
        new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(buttonLogout).click();
    }
}
