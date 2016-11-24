package mvp.example.com.mvp.login.model;

import android.os.Handler;
import android.text.TextUtils;
import mvp.example.com.mvp.login.listeners.OnLoginFinishedListener;

/**
 * Created by gaflores on 11/24/16.
 */

public class LoginModel {

    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if (!error) {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
