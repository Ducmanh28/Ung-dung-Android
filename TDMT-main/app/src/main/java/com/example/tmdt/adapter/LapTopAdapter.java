package com.example.tmdt.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tmdt.Interface.ItemclickListener;
import com.example.tmdt.R;
import com.example.tmdt.activity.ChiTietActivity;
import com.example.tmdt.model.SanPhamMoi;

import java.text.DecimalFormat;
import java.util.List;

public class LapTopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<SanPhamMoi> array;
    private static final int VIEW_TYPE_DATA = 0;
    private static final int VIEW_TYPE_LOADING = 1;


    public LapTopAdapter(Context context, List<SanPhamMoi> array) {
        this.context = context;
        this.array = array;
    }






    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_DATA) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laptop, parent, false);
            return new MyViewHolder(view);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }

    }
    public class LoadingViewHolder extends RecyclerView.ViewHolder{
        ProgressBar progressBar;
        public LoadingViewHolder(@NonNull View itemView)    {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressbar);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            SanPhamMoi sanPham = array.get(position);
            myViewHolder.tensplt.setText(sanPham.getTensanpham());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            myViewHolder.giasplt.setText("Giá: "+decimalFormat.format(Double.parseDouble(sanPham.getGiasanpham()))+"Đ");
            myViewHolder.motalt.setText(sanPham.getMotasanpham());
            Glide.with(context).load(sanPham.getHinhanhsanpham()).into(myViewHolder.hinhanhlt);
            myViewHolder.setItemclickListener(new ItemclickListener() {
                @Override
                public void onClick(View view, int pos, boolean isLongClick) {
                    if (!isLongClick) {
                        Intent intent = new Intent(context, ChiTietActivity.class);
                        intent.putExtra("chitiet",sanPham);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });

        }
        else {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return array.get(position) ==null ? VIEW_TYPE_LOADING:VIEW_TYPE_DATA;
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tensplt, giasplt, motalt;
        ImageView hinhanhlt;
        private ItemclickListener itemclickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tensplt = itemView.findViewById(R.id.itemlt_ten);
            giasplt = itemView.findViewById(R.id.itemlt_gia);
            motalt = itemView.findViewById(R.id.itemlt_mota);
            hinhanhlt = itemView.findViewById(R.id.itemlt_image);
            itemView.setOnClickListener(this);
        }

        public void setItemclickListener(ItemclickListener itemclickListener) {
            this.itemclickListener = itemclickListener;
        }

        @Override
        public void onClick(View view) {
            itemclickListener.onClick(view, getAdapterPosition(), false);
        }
    }
}
