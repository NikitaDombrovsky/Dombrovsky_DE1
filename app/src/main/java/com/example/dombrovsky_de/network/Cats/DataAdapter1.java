package com.example.dombrovsky_de.network.Cats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dombrovsky_de.MainActivity;
import com.example.dombrovsky_de.R;

import java.util.List;

public class DataAdapter1 extends BaseAdapter {
    private Context context;
    private List<CatsResponce> catsResponces;
    private LayoutInflater inflater;
    //private LayoutInflater inflater;
    private int resId;


    public DataAdapter1(Context context, List<CatsResponce> catsResponces, LayoutInflater inflater, int resId) {
        this.context = context;
        this.catsResponces = catsResponces;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resId = resId;
    }



    @Override
    public int getCount() {
        return catsResponces.size();
    }

    @Override
    public CatsResponce getItem(int i) {
        return catsResponces.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null){
            v = inflater.inflate(resId, viewGroup, false);
        }
        TextView Item_Cat_Name = view.findViewById(R.id.Item_Cat_Name);
        TextView Item_Cat_City = view.findViewById(R.id.Item_Cat_City);
        TextView Item_Cat_Mobile = view.findViewById(R.id.Item_Cat_Mobile);
        TextView Item_Cat_Email = view.findViewById(R.id.Item_Cat_Email);
        TextView Item_Cat_Skype = view.findViewById(R.id.Item_Cat_Skype);

        CatsResponce catsResponce = getItem(i);
        Item_Cat_Name.setText(catsResponce.getName());
        Item_Cat_City.setText(catsResponce.getCity());
        //Item_Cat_Mobile.setText(catsResponce.());
        //Item_Cat_Email.setText(catsResponce.getCity());

        return v;
    }
}