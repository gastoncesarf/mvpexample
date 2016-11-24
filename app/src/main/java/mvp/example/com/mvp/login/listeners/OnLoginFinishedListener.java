package mvp.example.com.mvp.login.listeners;

/**
 * Created by gaflores on 11/24/16.
 */

public interface OnLoginFinishedListener {
    void onUsernameError();

    void onPasswordError();

    void onSuccess();
}
