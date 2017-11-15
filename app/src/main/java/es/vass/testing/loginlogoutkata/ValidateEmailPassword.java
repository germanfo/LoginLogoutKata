package es.vass.testing.loginlogoutkata;



/**
 * Created by German on 15/11/17.
 */

class ValidateEmailPassword {

    public boolean validate(String email, String password) {
        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password);
    }
}
