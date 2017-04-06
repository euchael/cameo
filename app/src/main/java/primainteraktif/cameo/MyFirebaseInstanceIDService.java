package primainteraktif.cameo;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by wenby on 4/5/2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "FBsID";

    public static String getFCMToken(){
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        return refreshedToken;
    }

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
    }
}
