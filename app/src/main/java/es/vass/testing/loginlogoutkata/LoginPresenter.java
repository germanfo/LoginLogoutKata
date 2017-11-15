package es.vass.testing.loginlogoutkata;

/**
 * Created by German on 15/11/17.
 */

public class LoginPresenter {

    private final LoginPresenterView loginPresenterView;
    private String loginUser, loginPassword;
    private ValidateEmailPassword validateEmailPassword;

    interface LoginPresenterView {
        void setLoginEnabled();
        void setLoginDisabled();
    }

    public LoginPresenter(LoginPresenterView loginPresenterView, ValidateEmailPassword validateEmailPassword) {
        this.loginPresenterView = loginPresenterView;
        this.validateEmailPassword = validateEmailPassword;

    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
        checkValidLogin();
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        checkValidLogin();
    }

    private void checkValidLogin() {
        if (validateEmailPassword.validate(loginUser, loginPassword)) {
            loginPresenterView.setLoginEnabled();
        }
        else {
            loginPresenterView.setLoginDisabled();
        }
    }
}
