package evaldasbuz.com.ribbit;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    protected Button mSignUpTextView;
    protected EditText mUsername;
    protected EditText mPassword;
    protected Button mLoginButton;
    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mUsername = (EditText) findViewById(R.id.usernameField);
        mPassword = (EditText) findViewById(R.id.passwordField);
        mLoginButton = (Button) findViewById(R.id.loginButton);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                if (username.isEmpty() || password.isEmpty()) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this)
                            .setMessage(R.string.login_error_message)
                            .setTitle(R.string.login_error_title)
                            .setPositiveButton(android.R.string.ok, null);

                    AlertDialog dialog = builder.create();
                    builder.show();

                } else {
                    // Login
                    mProgressBar.setVisibility(View.VISIBLE);

                    ParseUser.logInInBackground(username, password, new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {

                               if (e == null){
                                   //Success!
                                   Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                                   startActivity(intent);


                               } else {
                                   AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this)
                                           .setMessage(e.getMessage())
                                           .setTitle(R.string.login_error_title)
                                           .setPositiveButton(android.R.string.ok, null);

                                   AlertDialog dialog = builder.create();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                                   builder.show();
                               }
                        }
                    });
                }

            }
        });

        mSignUpTextView = (Button) findViewById(R.id.singupText);

        mSignUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }


}
