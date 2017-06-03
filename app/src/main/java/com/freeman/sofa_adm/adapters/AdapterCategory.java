package com.freeman.sofa_adm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freeman.sofa_adm.R;
import com.freeman.sofa_adm.model.CategoryTranslate;


import java.util.ArrayList;

/**
 * Created by Freeman on 20.05.2017.
 */

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.CategoryViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<CategoryTranslate> categories = new ArrayList<>();

    public AdapterCategory(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void updateList (ArrayList<CategoryTranslate> categoryTranslates){
        categories.clear();
        for (CategoryTranslate category: categoryTranslates) {
            categories.add(category);
        }
        notifyDataSetChanged();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        CategoryTranslate item = categories.get(position);
        holder.title.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.category_name);
        }
    }
}
