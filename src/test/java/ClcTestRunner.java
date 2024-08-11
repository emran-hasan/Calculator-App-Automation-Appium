import org.testng.Assert;
import org.testng.annotations.Test;

public class ClcTestRunner extends Setup{
    @Test(priority = 1, description = "Automate a series for calculator app")
    public void doSeries(){
        CalcScreen calcScreen = new CalcScreen(driver);
        int result = Integer.parseInt(calcScreen.calculateSeries("100/10*5-10+60"));
        System.out.println(result);
        Assert.assertEquals(result, 100);
    }
}
