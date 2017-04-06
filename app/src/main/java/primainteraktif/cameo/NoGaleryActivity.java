package primainteraktif.cameo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import primainteraktif.cameo.Adapter.GaleryAdapter;
import primainteraktif.cameo.Model.GaleryModel;

public class NoGaleryActivity extends AppCompatActivity {

    String[][] datagalery = new String[][]{
            {"Developer workplace", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRFZ3pncIW4TuH2Q7rIZNIqju_CM2Q-dTDukHmWf0wkcTzFanU1yQ",
                    "3/04/2017 15:17", "Jakarta Selatan"},
            {"My Home ", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZcX6CXKdCiOJAG89jezX7WYzqrONef3ntdp9G5bUrfYZYyNEOQQ",
                    "3/04/2017 15:17", "Jakarta Selatan"},
            {"My Room ", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRk64QJ8Y3_hx3Be8-IWo6ogYuqeDISFliJ-9IMXrN30GXrx0UN2A",
                    "3/04/2017 15:17", "Tangerang"},
            {"Developer workplace", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRFZ3pncIW4TuH2Q7rIZNIqju_CM2Q-dTDukHmWf0wkcTzFanU1yQ",
                    "3/04/2017 15:17", "Jakarta Selatan"},
            {"My Home ", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZcX6CXKdCiOJAG89jezX7WYzqrONef3ntdp9G5bUrfYZYyNEOQQ",
                    "3/04/2017 15:17", "Jakarta Selatan"},
            {"My Room ", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRk64QJ8Y3_hx3Be8-IWo6ogYuqeDISFliJ-9IMXrN30GXrx0UN2A",
                    "3/04/2017 15:17", "Tangerang"}
    };

    GridView gGalery;

    private ArrayList<GaleryModel> listitem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_galery);


        Toolbar toolbar = (Toolbar) findViewById(R.id.id_custom_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        gGalery = (GridView) findViewById(R.id.grid_list_galery_video);
        GaleryModel galeryCamera = null;

        listitem = new ArrayList<>();

        for (int i = 0; i < datagalery.length; i++) {
            galeryCamera = new GaleryModel();
            galeryCamera.setGaleryTitle(datagalery[i][0]);
            galeryCamera.setGaleryImg(datagalery[i][1]);

            listitem.add(galeryCamera);

        }

        GaleryAdapter adapter = new GaleryAdapter(listitem, NoGaleryActivity.this);
        gGalery.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_mysaveddata) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
