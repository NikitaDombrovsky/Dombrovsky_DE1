package com.example.dombrovsky_de.network.Cats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dombrovsky_de.R;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter  extends ArrayAdapter<CatsResponce>{
    private Context context;
    private List<CatsResponce> catsResponceList;
    public DataAdapter (Context context, List<CatsResponce> catsResponceList){
        super(context, R.layout.cats_item, catsResponceList);
        this.context = context;
        this.catsResponceList = catsResponceList;
    }
    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.cats_item, parent, false);
        CatsResponce catsResponce = catsResponceList.get(position); //
       // Contact contact = catsResponce.get(position);
        TextView Item_Cat_Name = (TextView) convertView.findViewById(R.id.Item_Cat_Name);
        TextView Item_Cat_City = (TextView) convertView.findViewById(R.id.Item_Cat_City);
        TextView Item_Cat_Skype = (TextView) convertView.findViewById(R.id.Item_Cat_Skype);
        TextView Item_Cat_Email = (TextView) convertView.findViewById(R.id.Item_Cat_Email);
        TextView Item_Cat_Mobile = (TextView) convertView.findViewById(R.id.Item_Cat_Mobile);
        Item_Cat_Name.setText(catsResponce.getName());
        Item_Cat_City.setText(catsResponce.getCity());
       // Item_Cat_Skype.setText();
        //Item_Cat_Email.setText(catsResponce.getName());
       // Item_Cat_Mobile.setText(catsResponce.getName());
        return convertView;
    }

}
//        extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
//
//    private Data dataResponse;
//    private LayoutInflater inflater;
//    private Context context;
//
//    public DataAdapter(Data dataResponse, LayoutInflater inflater, Context context) {
//        this.dataResponse = dataResponse;
//        this.inflater = inflater;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        context = parent.getContext();
//        View view = inflater.inflate(R.layout.cats_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//       // Data dataResponses = dataResponse.get(position); //
//       // holder.setTextCat(dataResponses.getData()); //
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        final private TextView Item_Cat_Name;
//        final private TextView Item_Cat_City;
//        final private TextView Item_Cat_Mobile;
//        final private TextView Item_Cat_Email;
//        final private TextView Item_Cat_Skype;
//
//
//        private ViewHolder(View view) {
//            super(view);
//            this.Item_Cat_Name = view.findViewById(R.id.Item_Cat_Name);
//            this.Item_Cat_City = view.findViewById(R.id.Item_Cat_City);
//            this.Item_Cat_Mobile = view.findViewById(R.id.Item_Cat_Mobile);
//            this.Item_Cat_Email = view.findViewById(R.id.Item_Cat_Email);
//            this.Item_Cat_Skype = view.findViewById(R.id.Item_Cat_Skype);
//        }
//        public void setTextCat(String text) {
//            this.Item_Cat_Name.setText(text);
//            this.Item_Cat_City.setText(text);
//            this.Item_Cat_Mobile.setText(text);
//            this.Item_Cat_Email.setText(text);
//            this.Item_Cat_Skype.setText(text);
//        }
//
//    }
//}