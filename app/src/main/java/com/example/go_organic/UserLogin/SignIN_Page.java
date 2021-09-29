package com.example.go_organic.UserLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.go_organic.HomePage;
import com.example.go_organic.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class SignIN_Page extends AppCompatActivity {

    private View decorView;

    ImageButton btnGo;
    EditText email, password;
    TextView txtSignUp, txtFPassword;

    //Firebase Connection
    FirebaseAuth auth;

    //progress bar
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        //firebase connection
        auth = FirebaseAuth.getInstance();

        //progress bar
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        email = (EditText) findViewById(R.id.txtEmail);
        password = (EditText) findViewById(R.id.txtPassword);
        btnGo = (ImageButton) findViewById(R.id.img_btn);
        txtFPassword = (TextView) findViewById(R.id.txtForgetPW);
        txtSignUp = (TextView) findViewById(R.id.txtsignUp);

        //After click "Sign Up" textView it will redirect to Sign Up Page
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignIN_Page.this, SignUP_Page.class);
                startActivity(i);
            }
        }); //End code


        //button click login to app
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
                progressBar.setVisibility(View.VISIBLE);
            }
        });



        //remove bottom status bar
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });//end code
    }

    //remove bottom status bar
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
        {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars()
    {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
    //End of remove bottom status bar


    //login to app using login forum
    private void LoginUser() {

        //creating variables
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if (TextUtils.isEmpty(userEmail))
        {
            Toast.makeText(this,"Fill the Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userPassword))
        {
            Toast.makeText(this,"Fill the Password", Toast.LENGTH_SHORT).show();
            return;
        }


        //Login User Validation
        auth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                    progressBar.setVisibility(View.GONE);

                    new AlertDialog.Builder(SignIN_Page.this)
                            .setIcon(R.drawable.ic_check)
                            .setTitle(" Login Successfully")
                            .setMessage("Here's Your First Step With Us !!")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(SignIN_Page.this, HomePage.class);
                                    startActivity(i);
                                }
                            }).show();

                }else
                {
                    progressBar.setVisibility(View.GONE);

                    new AlertDialog.Builder(SignIN_Page.this)
                            .setIcon(R.drawable.warning)
                            .setTitle(" Login Unsuccessful")
                            .setMessage("Please Register Your Self First !!")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(SignIN_Page.this, SignUP_Page.class);
                                    startActivity(i);
                                }
                            }).setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();

                }

            }
        });
    }
}