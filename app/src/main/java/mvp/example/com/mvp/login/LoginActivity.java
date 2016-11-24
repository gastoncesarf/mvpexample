package mvp.example.com.mvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import mvp.example.com.mvp.R;
import mvp.example.com.mvp.login.presenter.LoginPresenter;
import mvp.example.com.mvp.login.view.LoginView;
import mvp.example.com.mvp.main.MainActivity;

/**
 * Created by gaflores on 11/24/16.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                presenter.validateCredentials(username.getText().toString(), password.getText().toString());
            }
        });

        presenter = new LoginPresenter(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.requestFocus();
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.requestFocus();
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void clearErrors() {
        username.setError(null);
        password.setError(null);
    }
}
