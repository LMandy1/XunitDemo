package TestXunit;

import DemoXunit.Login;
import DemoXunit.Shopping;
import LoginData.DataParams;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by duzhe on 2018/12/23.
 *
 * @Description:
 */
public class ShoppingTest {


    Login login = new Login();
    Shopping shopping = new Shopping();

    @BeforeClass
    public void beforeMethod(){
        System.out.println("------start");
    }

    @Test(dataProvider = "getProPrice",dataProviderClass = DataParams.class,dependsOnMethods = "TestXunit.LoginTest.testLogin")
    public void testGetPrice(int proId, int expect){
        int price = shopping.getPrice(proId);
        System.out.println(shopping.getPro(proId)+"  "+ price);
        Assert.assertEquals(price,expect);
    }

    @AfterClass
    public void AfterMethod(){
        System.out.println("------ending");    }
}
