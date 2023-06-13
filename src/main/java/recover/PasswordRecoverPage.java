package recover;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PasswordRecoverPage {
    private WebDriver driver;
    //Локатор до кнопки "Войти" на странице восстановления пароля
    private By enterButtonInRecoverPage = By.xpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']");
    public PasswordRecoverPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Метод для нажатия на кнопку для восстановления пароля")
    public void clickButtonEnterInFooterInPasswordRecoverPage() {
        driver.findElement(enterButtonInRecoverPage).click();
    }
}
