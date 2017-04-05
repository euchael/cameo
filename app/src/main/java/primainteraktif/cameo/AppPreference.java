package primainteraktif.cameo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wenby on 3/29/2017.
 */

public class AppPreference {

    SharedPreferences preferences;

    private Context context;
    private  SharedPreferences.Editor editor;

    private  String KEY_USERNAME="USERNAME";
    private  String KEY_UID="UID";
    private  String KEY_TOKEN="TOKEN";


    public AppPreference(Context context) {
        this.context = context;
        preferences= context.getSharedPreferences("cameo", Context.MODE_PRIVATE);
        editor= preferences.edit();
    }

    public String getKEY_USERNAME() {
        return preferences.getString(KEY_USERNAME,"");
    }

    public void setKEY_USERNAME(String STR_KEY_USERNAME) {
        editor.putString(KEY_USERNAME,STR_KEY_USERNAME);
        editor.commit();
    }

    public String getKEY_UID() {
        return preferences.getString(KEY_UID,"");
    }

    public void setKEY_UID(String STR_KEY_UID) {
        editor.putString(KEY_UID,STR_KEY_UID);
        editor.commit();
    }

    public String getKEY_TOKEN() {
        return preferences.getString(KEY_TOKEN,"");
    }

    public void setKEY_TOKEN(String STR_KEY_TOKEN) {
        editor.putString(KEY_TOKEN,STR_KEY_TOKEN);
        editor.commit();
    }

    public  void clear(){
        editor.clear();
        editor.commit();
    }
}
