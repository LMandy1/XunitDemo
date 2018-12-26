package LoginData;

import org.testng.annotations.DataProvider;

public class BuysParams {

    @DataProvider
//    * @return  -2 未登录；-1 购买数量<=0；1 购买成功; 0 库存不足
    public Object[][] getBuys(){
        return new Object[][]{
                {"","",2,2,-2},
                {"test","",2,2,-2},
                {"","123456",2,2,-2},
                {"admin","",2,2,-2},
                {"admin","123456",1,2,0},
                {"puser","123456",1,0,-1},
                {"puser","123456",1,2,0},
                {"puser","123456",2,2,1},
                {"puser","123456",2,3,1},
                {"puser","123456",2,13,0},
                {"puser","123456",3,1,1}
        };
    }
}
