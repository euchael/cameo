package primainteraktif.cameo.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import primainteraktif.cameo.Model.GaleryModel;
import primainteraktif.cameo.R;

/**
 * Created by wenby on 4/5/2017.
 */

public class GaleryAdapter extends BaseAdapter {
    ArrayList<GaleryModel> listitem;
    Activity activity;

    public GaleryAdapter(ArrayList<GaleryModel> listitem, Activity activity) {
        this.listitem = listitem;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listitem.size();
    }

    @Override
    public Object getItem(int i) {
        return listitem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        View view = convertview;
        ViewHolder holder = null;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_grid_galery_video,null);
            holder.txtTitle=(TextView) view.findViewById(R.id.titlegaleryvideo);
            holder.imgGalery=(ImageView) view.findViewById(R.id.imgviewpicture);


            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        GaleryModel itemcamera = (GaleryModel) getItem(i);
        final String galeryTitle= itemcamera.getGaleryTitle();
        final String imgGalery= itemcamera.getGaleryImg();

        holder.txtTitle.setText(galeryTitle);
        Picasso.with(activity).load(imgGalery).into(holder.imgGalery);

        return  view;
    }

    static class ViewHolder {
        ImageView imgGalery;
        TextView txtTitle;
    }
}
