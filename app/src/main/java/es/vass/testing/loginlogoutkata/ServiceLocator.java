package es.vass.testing.loginlogoutkata;

/**
 * Created by German on 15/11/17.
 */

public class ServiceLocator {

    public static LoginPresenter provideLoginPresenter(LoginPresenter.LoginPresenterView loginPresenterView){
        return new LoginPresenter(loginPresenterView, new ValidateEmailPassword(), new LoginUseCase());
    }
}
