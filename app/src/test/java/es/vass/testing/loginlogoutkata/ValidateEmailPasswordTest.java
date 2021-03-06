package es.vass.testing.loginlogoutkata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by German on 15/11/17.
 */

public class ValidateEmailPasswordTest {

    private static final String NOT_EMPTY_EMAIL = "mail";
    private static final String NOT_EMPTY_PASSWORD = "pass";
    private static final String WRONG_PASSWORD = "wrong";

    private SpyLoginActivity spyLoginActivity;
    private LoginPresenter testLoginPresenter;
    private LoginPresenter.LoginPresenterView view;
    @Mock LoginUseCase loginUseCase;

    @Before public void setUp() {

        MockitoAnnotations.initMocks(this);
        view = mock(LoginPresenter.LoginPresenterView.class);
        spyLoginActivity = new SpyLoginActivity();
        testLoginPresenter = ServiceLocator.provideLoginPresenter(view, loginUseCase);
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
        verify(view,times(1)).setLoginEnabled();

    }

    @Test public void shouldCallViewEnableLoginWhenUserAndPasswordChanged() throws Exception {
        testLoginPresenter.setLoginUser(NOT_EMPTY_EMAIL);
        testLoginPresenter.setLoginPassword(NOT_EMPTY_PASSWORD);

        //assertTrue(spyLoginActivity.isLoginEnabledCalled());
        verify(view).setLoginEnabled();
    }

    @Test public void shouldShowErrorOnWrongPassword() throws Exception {

        when(loginUseCase.doLogin(anyString(), anyString())).thenReturn(false);

        testLoginPresenter.setLoginUser(NOT_EMPTY_EMAIL);
        testLoginPresenter.setLoginPassword(WRONG_PASSWORD);

        testLoginPresenter.doLogin();

        verify(view).passwordError(anyString());
    }

}
