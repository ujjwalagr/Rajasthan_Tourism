package rajasthantourism.com.tourrajasthan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private SignInButton signin;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE=9001;
    static String nameget,emailget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences pref = getSharedPreferences("First_Time_Launched", Context.MODE_PRIVATE);
        if (pref.getBoolean("activity_login", false)) {
            Intent intent = new Intent(LoginActivity.this, HorizontalNtbActivity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_login", true);
            ed.apply();
        }
        signin=findViewById(R.id.login);
        signin.setOnClickListener(this);
        GoogleSignInOptions signInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient =new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.login)
        {
            signin();
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    private void signin()
    {
        Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);

    }
    private void signout()
    {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
         //       updateUi(false);
            }
        });

    }
    private  void  handleresult(GoogleSignInResult result)
    {
        if(result.isSuccess())
        {
             GoogleSignInAccount account=result.getSignInAccount();
              nameget=account.getDisplayName();
              emailget=account.getEmail();
            String img_url=account.getPhotoUrl().toString();
            Toast.makeText(this, "Welcome "+nameget, Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(LoginActivity.this,HorizontalNtbActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "Unsuccessful login", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ_CODE)
        {
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleresult(result);
        }
    }
}
