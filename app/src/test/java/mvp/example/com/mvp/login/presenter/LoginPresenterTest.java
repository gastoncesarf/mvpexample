package mvp.example.com.mvp.login.presenter;

import mvp.example.com.mvp.login.model.LoginModel;
import mvp.example.com.mvp.login.view.LoginView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertNull;

/**
 * Created by gaflores on 11/24/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    LoginModel mLoginModel;
    LoginView mLoginView;
    LoginPresenter mLoginPresenter;

    @Before
    public void setup() {

        mLoginView = Mockito.mock(LoginView.class);
        mLoginModel = Mockito.mock(LoginModel.class);
        mLoginPresenter = new LoginPresenter(mLoginView, mLoginModel);
    }

    @Test
    public void testValidateCredentials() {
        mLoginPresenter.validateCredentials("test","test");
        verify(mLoginView, times(1)).showProgress();
    }

    @Test
    public void testUserNameError() {
        mLoginPresenter.onUsernameError();
        verify(mLoginView).setUsernameError();
        verify(mLoginView).hideProgress();
    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        mLoginPresenter.onDestroy();
        assertNull(mLoginPresenter.view);
    }
}
