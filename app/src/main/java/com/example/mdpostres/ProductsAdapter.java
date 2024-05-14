package com.example.mdpostres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ProductsAdapter
        extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {


    private final List<Product> products;
    private final OnClickListener listener;
    private Context context;

    public ProductsAdapter(List<Product> products, OnClickListener listener) {
        this.products = products;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.setListener(product, listener);
        holder.tvName.setText(product.getName());
        Glide.with(context)
                .load(product.getUrl())
                .apply(new RequestOptions().centerCrop())
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        MaterialCardView viewContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            tvName = itemView.findViewById(R.id.tvName);
            viewContainer = (MaterialCardView)itemView;
        }
        protected void setListener(Product product, OnClickListener listener) {
            viewContainer.setOnClickListener(v -> {
                product.setSelected(!product.isSelected());
                viewContainer.setChecked(product.isSelected());
                listener.onClick(product);
            });
        }
    }
}
