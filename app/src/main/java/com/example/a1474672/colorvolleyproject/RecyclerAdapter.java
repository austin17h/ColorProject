package com.example.a1474672.colorvolleyproject;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

        private List<Coloring> coloringList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView number, color, id;

            public MyViewHolder(View view) {
                super(view);
                number = (TextView) view.findViewById(R.id.number);
                id = (TextView) view.findViewById(R.id.idnum);
                color = (TextView) view.findViewById(R.id.color);
            }
        }


        public RecyclerAdapter(List<Coloring> coloringList) {
            this.coloringList = coloringList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.color_row_layout, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            Coloring color = coloringList.get(position);
            Log.i("Holder: ", "" + color.getIdNum());
            Log.i("Holder: ", "" + color.getMyColor());
            Log.i("Holder: ", "" + color.getNumber());

            int e = color.getIdNum();
            if(e == 1)
                holder.id.setBackgroundColor(Color.RED);
            else if(e == 2)
                holder.id.setBackgroundColor(Color.rgb(255	,165	,0));
            else if( e == 3)
                holder.id.setBackgroundColor(Color.rgb(255,255,0));
            else if(e == 4)
                holder.id.setBackgroundColor(Color.rgb(0,128,0));
            else if(e == 5)
                holder.id.setBackgroundColor(Color.rgb(0,0,255));
            else
                holder.id.setBackgroundColor(Color.rgb(128,0,128));
            holder.color.setText(color.getMyColor());
            holder.number.setText(color.getNumberString());
        }

        @Override
        public int getItemCount() {
            return coloringList.size();
        }

    }
