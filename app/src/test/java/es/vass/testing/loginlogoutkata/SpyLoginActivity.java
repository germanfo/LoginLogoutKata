package es.vass.testing.loginlogoutkata;

/**
 * Created by German on 15/11/17.
 */

public class SpyLoginActivity implements LoginPresenter.LoginPresenterView {

    private boolean loginEnabledCalled = false;

    public boolean isLoginEnabledCalled() {
        return loginEnabledCalled;
    }

    public void setLoginEnabledCalled(boolean loginEnabledCalled) {
        this.loginEnabledCalled = loginEnabledCalled;
    }

    public boolean isEnabledValue() {
        return enabledValue;
    }

    public void setEnabledValue(boolean enabledValue) {
        this.enabledValue = enabledValue;
    }

    private boolean enabledValue;

    @Override
    public void setLoginEnabled() {
        loginEnabledCalled = true;
        enabledValue = true;
    }

    @Override
    public void setLoginDisabled() {
        enabledValue = false;
    }
}
