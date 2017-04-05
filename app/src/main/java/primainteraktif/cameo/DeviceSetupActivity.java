package primainteraktif.cameo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class DeviceSetupActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    Button btnlogout, submitnext;
    ImageView viewCamera , viewViewer , iconViewer, iconCamera ;
    private GoogleApiClient mGoogleApiClient; GoogleSignInOptions gso;

    FrameLayout frameLayoutcamera, frameLayoutviewer;

    boolean flaqOption =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_setup);
        getSupportActionBar().hide();

        gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        mGoogleApiClient= new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();


        frameLayoutviewer= (FrameLayout) findViewById(R.id.frame_layout_viewer);
        frameLayoutcamera= (FrameLayout) findViewById(R.id.frame_layout_camera);
        submitnext= (Button) findViewById(R.id.sbm_setup_device);
        viewCamera= (ImageView) findViewById(R.id.imageView_camera);
        viewViewer= (ImageView) findViewById(R.id.imageView_viewer);
        iconCamera= (ImageView) findViewById(R.id.centang_camera);
        iconViewer= (ImageView) findViewById(R.id.centang_viewer);
        viewCamera.setImageAlpha(128);
        viewViewer.setImageAlpha(128);

        frameLayoutcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               settingCamera();
            }
        });

        frameLayoutviewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               settingViewer();

            }
        });

        submitnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flaqOption==true){
                    Intent i = new Intent(DeviceSetupActivity.this,NoGaleryActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "Pilih setting device terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });



       // btnlogout= (Button) findViewById(R.id.btnlogout);

       /* btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Auth.GoogleSignInApi.signOut(mGoogleApiClient);
                Intent i = new Intent(DeviceSetupActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });*/
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("googlepost","gagal");
    }

    public void settingCamera(){
        viewCamera.setImageAlpha(255);
        iconCamera.setVisibility(View.VISIBLE);
        viewViewer.setImageAlpha(128);
        iconViewer.setVisibility(View.GONE);
        submitnext.setBackgroundResource(R.drawable.buttonshapehover);
        submitnext.setTextColor(ContextCompat.getColor(this,R.color.bgblue));
        flaqOption=true;
    }

    public void settingViewer(){
        viewViewer.setImageAlpha(255);
        iconViewer.setVisibility(View.VISIBLE);
        viewCamera.setImageAlpha(128);
        iconCamera.setVisibility(View.GONE);
        submitnext.setBackgroundResource(R.drawable.buttonshapehover);
        submitnext.setTextColor(ContextCompat.getColor(this,R.color.bgblue));
        flaqOption=true;
    }


}
