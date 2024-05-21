package com.example.ungdungbanhang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungbanhang.R;
import com.example.ungdungbanhang.model.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SpAdapter extends RecyclerView.Adapter<SpAdapter.ItemHolder> {
    Context context;
    private final ArrayList<SanPham> arraySanPham;

    public SpAdapter(Context context, ArrayList<SanPham> arraySanPham) {
        this.context = context;
        this.arraySanPham = arraySanPham;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_spmoinhat, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        SanPham sanPham = arraySanPham.get(position);
        holder.txttensanpham.setText(sanPham.getTensanpham());

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText(String.format("%sVNĐ", decimalFormat.format(sanPham.getGiasanpham())));

        Picasso.get().load(sanPham.getHinhanhsanpham())
                .placeholder(R.drawable.no_image)
                .error(R.drawable.error)
                .into(holder.imghinhsanpham);
    }

    @Override
    public int getItemCount() {
        return arraySanPham != null ? arraySanPham.size() : 0;
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imghinhsanpham;
        public TextView txttensanpham, txtgiasanpham;

        public ItemHolder(View itemView) {
            super(itemView);
            imghinhsanpham = itemView.findViewById(R.id.imageviewsp);
            txttensanpham = itemView.findViewById(R.id.textviewtensp);
            txtgiasanpham = itemView.findViewById(R.id.textviewgiasanpham);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,ChiTietSanPham.class);
                    intent.putExtra("thongtinsanpham",arraysanpham.get(getAdapterPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    checkconnect.ShowToast_Short(context,arraysanpham.get(getAdapterPosition()).getTensanpham());
                    context.startActivity(intent);
                }
            });*/
        }
    }
}
