import io.qameta.allure.junit4.DisplayName;
import authorization.LoginPage;
import main.MainPage;
import profile.ProfilePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
public class TestLogout {
    private String userEmail;
    private String userPassword;
    private WebDriver driver;
    @Before
    public void preparatoryDataForTestAuthorization() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @Test
    @DisplayName("Авторизация и последующий логаут из личного кабинета")
    public void testCorrectAuthorizationAndLogoutInChrome() {
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);
        userEmail = "TestChelForUi@mail.ru";
        userPassword = "123456789";
        objMainPage.clickLkButtonInMainPage();
        objLoginPage.setNameOnAuthorization(userEmail);
        objLoginPage.setPasswordOnAuthorization(userPassword);
        objLoginPage.clickAuthorizationButtonInAuthorizationPage();
        objMainPage.clickLkButtonInHeader();
        objProfilePage.clickLogoutButtonInProfilePage();
        String actualEnterTextFromButton = objLoginPage.getEnterText();
        String expectedEnterTextFromButton = "Войти";
        assertEquals("Должна появиться надпись 'Войти'", expectedEnterTextFromButton, actualEnterTextFromButton);
    }
    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
