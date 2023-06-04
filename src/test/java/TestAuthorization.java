import io.qameta.allure.junit4.DisplayName;
import authorization.LoginPage;
import main.MainPage;
import recover.PasswordRecoverPage;
import registration.RegistrationPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
public class TestAuthorization {
    private String userEmail;
    private String userPassword;
    private WebDriver driver;
    @Before
    public void preparatoryDataForTestAuthorization() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @Test
    @DisplayName("Авторизация существующего пользователя по кнопке с основной страницы")
    public void testCorrectAuthorizationByButtonInMainPageInChrome() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        userEmail = "TestChelForUi@mail.ru";
        userPassword = "123456789";
        objMainPage.clickLkButtonInMainPage();
        objLoginPage.setNameOnAuthorization(userEmail);
        objLoginPage.setPasswordOnAuthorization(userPassword);
        objLoginPage.clickAuthorizationButtonInAuthorizationPage();
        String actualTextFromButtonCreateOrder = objMainPage.getTextFromButtonCreateOrder();
        String expectedEnterText = "Оформить заказ";
        assertEquals("Должна появиться надпись 'Оформить заказ'", expectedEnterText, actualTextFromButtonCreateOrder);
    }
    @Test
    @DisplayName("Авторизация существующего пользователя по кнопке с хедера")
    public void testCorrectAuthorizationByButtonInHeaderOfMainPageInChrome() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        userEmail = "TestChelForUi@mail.ru";
        userPassword = "123456789";
        objMainPage.clickLkButtonInHeader();
        objLoginPage.setNameOnAuthorization(userEmail);
        objLoginPage.setPasswordOnAuthorization(userPassword);
        objLoginPage.clickAuthorizationButtonInAuthorizationPage();
        String actualTextFromButtonCreateOrder = objMainPage.getTextFromButtonCreateOrder();
        String expectedEnterText = "Оформить заказ";
        assertEquals("Должна появиться надпись 'Оформить заказ'", expectedEnterText, actualTextFromButtonCreateOrder);
    }
    @Test
    @DisplayName("Авторизация существующего пользователя по кнопке со страницы регистрации")
    public void testCorrectAuthorizationByButtonInFooterInRegistrationPageInChrome() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        userEmail = "TestChelForUi@mail.ru";
        userPassword = "123456789";
        objMainPage.clickLkButtonInHeader();
        objLoginPage.clickRegistrationButtonInLoginPage();
        objRegistrationPage.clickButtonEnterInFooterInRegistrationPage();
        objLoginPage.setNameOnAuthorization(userEmail);
        objLoginPage.setPasswordOnAuthorization(userPassword);
        objLoginPage.clickAuthorizationButtonInAuthorizationPage();
        String actualTextFromButtonCreateOrder = objMainPage.getTextFromButtonCreateOrder();
        String expectedEnterText = "Оформить заказ";
        assertEquals("Должна появиться надпись 'Оформить заказ'", expectedEnterText, actualTextFromButtonCreateOrder);
    }
    @Test
    @DisplayName("Авторизация существующего пользователя по кнопке со страницы восстановления пароля")
    public void testCorrectAuthorizationByButtonInFooterInPasswordRecoveryPageInChrome() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        PasswordRecoverPage objPasswordRecoverPage = new PasswordRecoverPage(driver);
        userEmail = "TestChelForUi@mail.ru";
        userPassword = "123456789";
        objMainPage.clickLkButtonInHeader();
        objLoginPage.clickButtonPasswordRecoverInAuthorizationPage();
        objPasswordRecoverPage.clickButtonEnterInFooterInPasswordRecoverPage();
        objLoginPage.setNameOnAuthorization(userEmail);
        objLoginPage.setPasswordOnAuthorization(userPassword);
        objLoginPage.clickAuthorizationButtonInAuthorizationPage();
        String actualTextFromButtonCreateOrder = objMainPage.getTextFromButtonCreateOrder();
        String expectedEnterText = "Оформить заказ";
        assertEquals("Должна появиться надпись 'Оформить заказ'", expectedEnterText, actualTextFromButtonCreateOrder);
    }
}
