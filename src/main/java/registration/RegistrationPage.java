package registration;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
public class RegistrationPage {
    private WebDriver driver;
    //Локатор до поля "Имя" на странице регистрации
    private By nameInRegistrationPage = By.xpath(".//fieldset[1]/div/div/input");
    //Локатор до поля "Email" на странице регистрации
    private By emailInRegistrationPage = By.xpath(".//fieldset[2]/div/div/input");
    //Локатор до поля "Пароль" на странице регистрации
    private By passwordInRegistrationPage = By.xpath(".//input[@name='Пароль']");
    //Локатор до кнопки "Войти" на странице регистрации
    private By enterButtonInRegistrationPage = By.xpath(".//p[text()='Уже зарегистрированы?']/a[text()='Войти']");
    //Локатор до кнопки "Зарегистрироваться" на странице регистрации
    private By registrationButtonInRegistrationPage = By.xpath(".//button[text()='Зарегистрироваться']");
    // Локатор до текста ошибки "Некорректный пароль"
    private By textNotCorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    //Локатор до кнопки "Войти" рядом с текстом "Уже зарегистрированы?" на странице регистрации
    private By buttonEnterInFooter = By.xpath(".//p[text()='Уже зарегистрированы?']/a[text()='Войти']");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Метод для ввода текста в поле 'Имя'")
    public void setName(String userName) {
        driver.findElement(nameInRegistrationPage).sendKeys(userName);
    }
    @Step("Метод для ввода текста в поле 'Email'")
    public void setEmail(String userEmail) {
        driver.findElement(emailInRegistrationPage).sendKeys(userEmail);
    }
    @Step("Метод для ввода текста в поле 'Пароль'")
    public void setPassword(String userPassword) {
        driver.findElement(passwordInRegistrationPage).sendKeys(userPassword);
    }
    @Step("Метод для нажатия на кнопку 'Зарегистрироваться' на странице регистрации")
    public void clickRegistrationButtonInRegistrationPage() {
        driver.findElement(registrationButtonInRegistrationPage).click();
    }
    @Step("Метод получения текста 'Некорректный пароль'")
    public String getIncorrectPasswordText() {
        new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(textNotCorrectPassword).getText();
    }
    @Step("Метод для нажатия на кнопку 'Войти' рядом с текстом 'Уже зарегистрированы?' на странице регистрации")
    public void clickButtonEnterInFooterInRegistrationPage() {
        driver.findElement(buttonEnterInFooter).click();
    }
}
