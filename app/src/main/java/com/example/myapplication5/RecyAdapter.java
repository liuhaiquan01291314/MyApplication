package com.example.myapplication5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication5.Bean.BeanData;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter {
    private ArrayList<BeanData.T1348647909107Bean> list;
    private Context context;
    public boolean mBoolean=false;
    public RecyAdapter(ArrayList<BeanData.T1348647909107Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recy, null);
        return new ViewHandles(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ViewHandles holder1= (ViewHandles) holder;
       holder1.name.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImgsrc()).into(holder1.img);
        if (mBoolean)
        {
              holder1.checkBox.setVisibility(View.VISIBLE);
        }else {
            holder1.checkBox.setVisibility(View.INVISIBLE);
        }
        boolean xuan = list.get(position).isXuan();
        holder1.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                list.get(position).setXuan(b);
            }
        });
        holder1.checkBox.setChecked(xuan);
    }

    public void setData(boolean b) {
        mBoolean=b;
    }

    public void setDataa(boolean b) {
        mBoolean=b;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHandles extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView img;
        CheckBox checkBox;
        public ViewHandles(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            img=itemView.findViewById(R.id.img);
            checkBox=itemView.findViewById(R.id.check);
        }
    }
}
