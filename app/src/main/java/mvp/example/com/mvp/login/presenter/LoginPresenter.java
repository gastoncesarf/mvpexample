package mvp.example.com.mvp.login.presenter;

import android.text.TextUtils;
import mvp.example.com.mvp.login.listeners.OnLoginFinishedListener;
import mvp.example.com.mvp.login.model.LoginModel;
import mvp.example.com.mvp.login.view.LoginView;
import org.w3c.dom.Text;

/**
 * Created by gaflores on 11/24/16.
 */

public class LoginPresenter implements OnLoginFinishedListener {
    LoginView view;
    private LoginModel model;

    public LoginPresenter(LoginView loginView) {
        view = loginView;
        model = new LoginModel();
    }

    public LoginPresenter(LoginView loginView, LoginModel mock) {
        view = loginView;
        model = mock;
    }

    public void validateCredentials(String username, String password) {
/*        if(TextUtils.isEmpty(username)) {
            onUsernameError();
        }*/
        if (view != null) {
            view.showProgress();
        }

        model.login(username, password, this);
    }

    public void onDestroy() {
        view = null;
    }

    @Override
    public void onUsernameError() {
        if (view != null) {
            view.setUsernameError();
            view.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (view != null) {
            view.setPasswordError();
            view.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.navigateToHome();
        }
    }
}
