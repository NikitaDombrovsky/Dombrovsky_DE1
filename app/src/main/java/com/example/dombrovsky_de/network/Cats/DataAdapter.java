package com.example.dombrovsky_de.network.Cats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dombrovsky_de.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private Data dataResponse;
    private LayoutInflater inflater;
    private Context context;

    public DataAdapter(Data dataResponse, LayoutInflater inflater, Context context) {
        this.dataResponse = dataResponse;
        this.inflater = inflater;
        this.context = context;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.cats_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       // Data dataResponses = dataResponse.get(position); //
       // holder.setTextCat(dataResponses.getData()); //
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final private TextView Item_Cat_Name;
        final private TextView Item_Cat_City;
        final private TextView Item_Cat_Mobile;
        final private TextView Item_Cat_Email;
        final private TextView Item_Cat_Skype;


        private ViewHolder(View view) {
            super(view);
            this.Item_Cat_Name = view.findViewById(R.id.Item_Cat_Name);
            this.Item_Cat_City = view.findViewById(R.id.Item_Cat_City);
            this.Item_Cat_Mobile = view.findViewById(R.id.Item_Cat_Mobile);
            this.Item_Cat_Email = view.findViewById(R.id.Item_Cat_Email);
            this.Item_Cat_Skype = view.findViewById(R.id.Item_Cat_Skype);
        }
        public void setTextCat(String text) {
            this.Item_Cat_Name.setText(text);
            this.Item_Cat_City.setText(text);
            this.Item_Cat_Mobile.setText(text);
            this.Item_Cat_Email.setText(text);
            this.Item_Cat_Skype.setText(text);
        }

    }
}