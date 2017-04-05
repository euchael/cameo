package primainteraktif.cameo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    //isi ga bole kosong jd angka apa aja
    private static final int GPLUS_SIGN_IN =7;
    TextView txtDemoMode;

    AppPreference appPref;

    ImageButton btngoogle;

    private GoogleApiClient mGoogleApiClient; GoogleSignInOptions gso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();


        appPref= new AppPreference(this);


        btngoogle= (ImageButton) findViewById(R.id.btngoogleimage);

        gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        mGoogleApiClient= new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();

        btngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    GoogleSignIn();
            }
        });
    }

    private void GoogleSignIn(){
        Intent signInIntent= Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, GPLUS_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== GPLUS_SIGN_IN){
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleGoogleSignInResult(result);
        }
    }

    private void handleGoogleSignInResult(GoogleSignInResult result){
        //Log.d("googlepost","Handle result"+result.getSignInAccount().getDisplayName());
        if (result.isSuccess()){
            GoogleSignInAccount acct= result.getSignInAccount();
            String Name= acct.getDisplayName();
            String Email= acct.getEmail();
            String Id= acct.getId();

            appPref.setKEY_USERNAME(Name);

            Intent i = new Intent(LoginActivity.this, DeviceSetupActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        txtDemoMode= (TextView) findViewById(R.id.DemoMode);

        txtDemoMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DeviceSetup= new Intent(LoginActivity.this, DeviceSetupActivity.class);
                startActivity(DeviceSetup);
            }
        });

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("googlepost","koneksi fail");
    }
}
