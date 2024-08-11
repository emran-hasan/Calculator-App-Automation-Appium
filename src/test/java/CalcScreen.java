import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcScreen {
    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement btnAdd;
    @FindBy(id = "com.google.android.calculator:id/op_sub")
    WebElement btnSub;
    @FindBy(id = "com.google.android.calculator:id/op_mul")
    WebElement btnMul;
    @FindBy(id = "com.google.android.calculator:id/op_div")
    WebElement btnDiv;
    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement btnEqual;
    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement screenResult;
    AndroidDriver driver;

    public CalcScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public String calculateSeries(String series) {
        for (int i = 0; i < series.length(); i++) {
            char cha = series.charAt(i);
            if (cha == '+') {
                btnAdd.click();
            } else if (cha == '-') {
                btnSub.click();
            } else if (cha == '*') {
                btnMul.click();
            } else if (cha == '/') {
                btnDiv.click();
            } else if (Character.isDigit(cha)) {
                driver.findElement(By.id("com.google.android.calculator:id/digit_" + cha)).click();
            }
        }
        btnEqual.click();
        return screenResult.getText();

    }

}
