package es.vass.testing.loginlogoutkata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText et_user;
    private EditText et_password;
    private Button bt_login;
    private ValidateEmailPassword validateEmailPassword = new ValidateEmailPassword();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        addTextWatcher();
    }

    private void addTextWatcher() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkEnableOrDisableLoginButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        et_user.addTextChangedListener(textWatcher);
        et_password.addTextChangedListener(textWatcher);

        //initial call
        checkEnableOrDisableLoginButton();
    }

    private void checkEnableOrDisableLoginButton() {
        String loginText = et_user.getText().toString();
        String passwordText = et_password.getText().toString();


        boolean enable = validateEmailPassword.validate(loginText, passwordText);

        bt_login.setEnabled(enable);
    }

    private void initViews() {
        et_user = findViewById(R.id.et_login);
        et_password = findViewById(R.id.et_password);
        bt_login = findViewById(R.id.bt_login);
    }



}
