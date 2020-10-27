package market.api.model;

public class SignInMerchantModerator {
    private String email;
    private String password;

    public SignInMerchantModerator(String email, String password) {
        this.email = email;
        this.password = password;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
