package com.example.asmaulhusna_app;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    private List<MainModel.Data> datas;
    private OnAdapterListener listener;

    public MainAdapter(List<MainModel.Data> datas, OnAdapterListener listener){

        this.datas = datas;
        this.listener = listener;

    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
    MainModel.Data data = datas.get(position);
    holder.no.setText(Integer.toString(data.getId()));
    holder.bacaan.setText( data.getLatin() );
    holder.ayat.setText( data.getArabic() );
    holder.arti.setText( data.getTerjemahan() );

    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.OnClick( data );
        }
    });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ayat, bacaan, arti, no;
        CardView cardView;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ayat = (TextView) itemView.findViewById(R.id.tv_ayat);
            bacaan = (TextView) itemView.findViewById(R.id.tv_bacaan);
            arti = (TextView) itemView.findViewById(R.id.tv_arti);
            no = (TextView) itemView.findViewById(R.id.tv_no);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.tes);
        }
    }

    public void setData(List<MainModel.Data> data){
        datas.clear();
        datas.addAll(data);
        notifyDataSetChanged();
    }

    interface OnAdapterListener{

        void OnClick(MainModel.Data data);

    }
}
