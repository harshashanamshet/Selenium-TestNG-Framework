package data;

public class LoginData {

    private String username;
    private String password;
    private boolean expectedResult;
    private String expectedMsg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(boolean expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getExpectedMsg() {
        return expectedMsg;
    }

    public void setExpectedMsg(String expectedMsg) {
        this.expectedMsg = expectedMsg;
    }
}
