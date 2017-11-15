package es.vass.testing.loginlogoutkata;

/**
 * Created by German on 15/11/17.
 */

public class LoginPresenter {

    private final LoginPresenterView loginPresenterView;
    private String loginUser, loginPassword;
    private ValidateEmailPassword validateEmailPassword;
    private LoginUseCase loginUseCase;

    interface LoginPresenterView {
        void setLoginEnabled();
        void setLoginDisabled();
        void loginDone();
        void passwordError(String errorText);
    }

    public LoginPresenter(LoginPresenterView loginPresenterView, ValidateEmailPassword validateEmailPassword, LoginUseCase loginUseCase) {
        this.loginPresenterView = loginPresenterView;
        this.validateEmailPassword = validateEmailPassword;
        this.loginUseCase = loginUseCase;

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

    public void doLogin(){
        if (loginUseCase.doLogin(loginUser, loginPassword)){
            loginPresenterView.loginDone();
        }else {
            loginPresenterView.passwordError("Password incorrecto");
        }
    }
}
