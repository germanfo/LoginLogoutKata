package es.vass.testing.loginlogoutkata;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by German on 15/11/17.
 */

public class ValidateEmailPasswordTest {

    private static final String NOT_EMPTY_EMAIL = "mail";
    private static final String NOT_EMPTY_PASSWORD = "pass";

    @Test public void shouldReturnTrueIfTheLoginAndPassAreNotEmpty() throws Exception {
        ValidateEmailPassword validateEmailPassword = new ValidateEmailPassword();

        boolean notEmpty = validateEmailPassword.validate(NOT_EMPTY_EMAIL, NOT_EMPTY_PASSWORD);

        assertTrue(notEmpty);
    }
}
