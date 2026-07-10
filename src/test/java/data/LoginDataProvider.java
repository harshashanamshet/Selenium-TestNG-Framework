package data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        List<LoginData> loginData =
                mapper.readValue(
                        new File("src/test/resources/testdata/LoginData.json"),
                        //D:\Harsha\eclipeWorkspace\ECommerceDemo\src\test\resources\testdata\LoginData.json
                        new TypeReference<List<LoginData>>() {});
        Object[][] data = new Object[loginData.size()][1];

        for (int i = 0; i < loginData.size(); i++) {
            data[i][0] = loginData.get(i);
        }

        return data;
    }
}

