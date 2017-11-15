package es.vass.testing.loginlogoutkata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by German on 15/11/17.
 */

public class ValidateEmailPasswordTest {

    private static final String NOT_EMPTY_EMAIL = "mail";
    private static final String NOT_EMPTY_PASSWORD = "pass";

    private SpyLoginActivity spyLoginActivity;
    private LoginPresenter testLoginPresenter;
    private LoginPresenter.LoginPresenterView view;

    @Before public void setUp() {
        view = mock(LoginPresenter.LoginPresenterView.class);
        spyLoginActivity = new SpyLoginActivity();
        testLoginPresenter = ServiceLocator.provideLoginPresenter(view);
    }

    @After public void tearDown() {
        testLoginPresenter = null;
        spyLoginActivity = null;
        view = null;
    }

    @Test public void shouldReturnTrueIfTheLoginAndPassAreNotEmpty() throws Exception {
        testLoginPresenter.setLoginUser(NOT_EMPTY_EMAIL);
        testLoginPresenter.setLoginPassword(NOT_EMPTY_PASSWORD);

        //assertTrue(spyLoginActivity.isEnabledValue());
        verify(view,times(2)).setLoginEnabled(anyBoolean());

    }

    @Test public void shouldCallViewEnableLoginWhenUserAndPasswordChanged() throws Exception {
        testLoginPresenter.setLoginUser(NOT_EMPTY_EMAIL);
        testLoginPresenter.setLoginPassword(NOT_EMPTY_PASSWORD);

        assertTrue(spyLoginActivity.isLoginEnabledCalled());
    }
}
