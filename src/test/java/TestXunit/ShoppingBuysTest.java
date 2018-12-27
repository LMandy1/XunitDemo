package TestXunit;

import DemoXunit.Login;
import DemoXunit.Products;
import DemoXunit.Shopping;
import org.testng.Assert;
import org.testng.annotations.*;

public class ShoppingBuysTest {
    Shopping shopping = new Shopping();
    Login login = new Login();
    @BeforeClass
    public void testBefore(){
        System.out.println("查询系统中的库存：");
        for (Products pro:Products.values()){
            String proStr = String.format("   %s的库存为：%s",pro.getProName(),pro.getCount());
            System.out.println(proStr);
        }
        System.out.println("Shopping.buys方法的单元测试开始");
    }
    @BeforeMethod
    public void testBaforemd(){
        System.out.print("开始-------");
    }
    @Test(dataProvider = "getBuys",dataProviderClass = LoginData.BuysParams.class)
    public void testShoppingBuys(String name,String pwd,int proId,int count,int ex){
        login.userLogin(name,pwd);
        Products pro = Products.getPro(proId);
        String userStr;
        if(login.isLogin == false || pro == null){
            userStr = "用户"+name;
        }else {
            int profCount = pro.getCount();
            int proeCount = profCount - count;

            if (count<0 || proeCount<0){
                proeCount = profCount;
                userStr = String.format("%s目前的库存为：%s,用户%s,买%s件%s",pro.getProName(),profCount,name,count,pro.getProName());
            }else {
                proeCount = proeCount;
                userStr = String.format("%s目前的库存为：%s,用户%s,买%s件%s,该商品剩余%s",pro.getProName(),profCount,name,count,pro.getProName(),proeCount);
            }
        }
        int ac = shopping.buys(proId,count);
        switch (ac){
            case -3:
                System.out.print(userStr+"购买商品不存在");
                break;
            case -2:
                System.out.print(userStr+" 未登录，不能购买商品  ");
                break;
            case -1:
                System.out.print(userStr+" ，购买数量<=0  ");
                break;
            case 0:
                System.out.print(userStr+" ，库存不足  ");
                break;
            case 1:
                System.out.print(userStr+" ，购买成功  ");
        }
        Assert.assertEquals(ac,ex);
    }
    @AfterClass
    public void testAfter(){
        System.out.println("Shopping.buys方法的单元测试结束，恢复商品库存：");
        for (Products pro:Products.values()){
           switch (pro.getProId()){
               case 1:
                   pro.setCount(0);
                   break;
               case 2:
                   pro.setCount(10);
                   break;
               case 3:
                   pro.setCount(1);
                   break;
           }
            String proStr = String.format("  %s的库存为：%s",pro.getProName(),pro.getCount());
            System.out.println(proStr);
        }
    }
    @AfterMethod
    public void testAftermd(){
        System.out.println("--------结束；");
    }
}
