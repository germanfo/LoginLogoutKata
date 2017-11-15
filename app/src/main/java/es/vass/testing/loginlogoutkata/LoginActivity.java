package es.vass.testing.loginlogoutkata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.LoginPresenterView{

    private EditText et_user;
    private EditText et_password;
    private Button bt_login;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = ServiceLocator.provideLoginPresenter(this);
        initViews();

        addTextWatcher();
    }

    private void addTextWatcher() {

        et_user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                loginPresenter.setLoginUser(et_user.getText().toString());
            }
        });

        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                loginPresenter.setLoginPassword(et_password.getText().toString());
            }
        });


    }


    private void initViews() {
        et_user = findViewById(R.id.et_login);
        et_password = findViewById(R.id.et_password);
        bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin();
            }
        });
    }


    @Override
    public void setLoginEnabled() {
        bt_login.setEnabled(true);
    }

    @Override
    public void setLoginDisabled() {
        bt_login.setEnabled(false);
    }

    @Override
    public void loginDone() {
        Toast.makeText(this, "Login OK", Toast.LENGTH_LONG).show();
    }

    @Override
    public void passwordError(String errorText) {
        Toast.makeText(this, errorText, Toast.LENGTH_LONG).show();
    }
}
