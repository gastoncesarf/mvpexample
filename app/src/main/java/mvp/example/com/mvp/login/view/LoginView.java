package mvp.example.com.mvp.login.view;

/**
 * Created by gaflores on 11/24/16.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void clearErrors();
}
