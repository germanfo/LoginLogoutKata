package es.vass.testing.loginlogoutkata;

/**
 * Created by German on 15/11/17.
 */

class LoginUseCase {
    public boolean doLogin(String email, String password) {
        if (!"wrong".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
