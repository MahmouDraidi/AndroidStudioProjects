package com.draidi.test1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class product_adapter extends ArrayAdapter<prod_class> {
    public product_adapter(@NonNull Context context, ArrayList<prod_class> resource) {
        super(context,R.layout.prod_list_item, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inf=LayoutInflater.from(getContext());
        View customView=inf.inflate(R.layout.prod_list_item,parent,false);

        String prod_name=getItem(position).getProdName();
        String prod_owner=getItem(position).getOwnerName();
        String prod_views=getItem(position).getViews();
        String prod_img=getItem(position).getImg1();

        ImageView prodImg= customView.findViewById(R.id.proImgView);
        TextView prodName= customView.findViewById(R.id.prodNameView);
        TextView prodViewsNom= customView.findViewById(R.id.ViewsNum);
        TextView prodOwner=customView.findViewById(R.id.ownerView);

        Picasso.get().load("http://192.168.1.108/GradProj/productImages/"+prod_img).into(prodImg);
        prodName.setText(prod_name);
        prodOwner.setText(prod_owner);
        prodViewsNom.setText(prod_views);

        return customView;
    }
}
