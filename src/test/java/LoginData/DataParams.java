package LoginData;

import org.testng.annotations.DataProvider;

/**
 * Created by duzhe on 2018/12/23.
 *
 * @Description:
 */
public class DataParams {



    @DataProvider
    public Object[][] getProPrice(){
        return new Object[][]{
                {1,200},
                {2,120},
                {3,80},
                {-9,-1}
        };
    }

}
