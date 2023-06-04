import io.qameta.allure.junit4.DisplayName;
import authorization.LoginPage;
import main.MainPage;
import registration.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
public class TestRegistration {
    private String userName;
    private String userEmail;
    private String userPassword;
    private WebDriver driver;
    @Before
    public void preparatoryDataForTestRegistration() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @Test
    @DisplayName("Регистрация нового пользователя со всеми корректными данными")
    public void testSuccessfulRegistrationAndAppearancesTextAboutPasswordRecoveryInChrome() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        userName = "Test User36";
        userEmail = "TestChelForUi36@mail.ru";
        userPassword = "123456789";
        objMainPage.clickLkButtonInHeader();
        objLoginPage.clickRegistrationButtonInLoginPage();
        objRegistrationPage.setName(userName);
        objRegistrationPage.setEmail(userEmail);
        objRegistrationPage.setPassword(userPassword);
        objRegistrationPage.clickRegistrationButtonInRegistrationPage();
        String actualForgetPasswordText = objLoginPage.getForgetPassword();
        String expectedEnterText = "Забыли пароль? Восстановить пароль";
        assertEquals("Должна появиться кнопка 'Забыли пароль? Восстановить пароль'", expectedEnterText, actualForgetPasswordText);
    }
    @Test
    @DisplayName("Регистрация нового пользователя с некорректным паролем")
    public void testNotCorrectRegistrationIfPasswordNotCorrectInChrome() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        userName = "Test User32";
        userEmail = "TestChelForUi32@mail.ru";
        userPassword = "123";
        objMainPage.clickLkButtonInHeader();
        objLoginPage.clickRegistrationButtonInLoginPage();
        objRegistrationPage.setName(userName);
        objRegistrationPage.setEmail(userEmail);
        objRegistrationPage.setPassword(userPassword);
        objRegistrationPage.clickRegistrationButtonInRegistrationPage();
        String actualForgetPasswordText = objRegistrationPage.getIncorrectPasswordText();
        String expectedEnterText = "Некорректный пароль";
        assertEquals("Должна появиться надпись 'Некорректный пароль'", expectedEnterText, actualForgetPasswordText);
    }
    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
