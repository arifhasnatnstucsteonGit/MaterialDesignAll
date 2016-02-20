package com.android.arifhasnat.material;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by arif hasnat on 2/18/2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

   // public String data[];//={"Once upon a time ","Once upon a time","Once upon a time","Once upon a time ","Once upon a time ","Once upon a time","Once upon a time"};
   // Context mContext;

    ArrayList<String> arrayList=new ArrayList<>();


   // List datas= Collections.emptyList();


    public DataAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public void delete(int position){

       /* data.notify();
        datas.remove(position);*/
        arrayList.remove(position);
        notifyItemRemoved(position);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_layout,null);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;



    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewData.setText(String.valueOf(arrayList.get(position)));


    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewData;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewData= (TextView) itemView.findViewById(R.id.textView_data);

            //textViewData.setOnClickListener(this);



        }

/*
        @Override
        public void onClick(View v) {
            delete(getAdapterPosition());
            Toast.makeText(v.getContext(),"sdfsdfsdfsd"+getAdapterPosition(),Toast.LENGTH_LONG).show();

        }
*/

    }
}
