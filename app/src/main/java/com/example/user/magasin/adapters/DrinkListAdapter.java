package com.example.user.magasin.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.magasin.R;
import com.example.user.magasin.model.Articles;

import java.util.List;

/**
 * Created by user on 11/03/2018.
 */

public class DrinkListAdapter extends ArrayAdapter<Articles> {
    private Context context;
    private List<Articles> articles;

    public DrinkListAdapter(Context context,List<Articles> articles) {
        super(context, R.layout.drink_row_layout,articles);
        this.context=context;
        this.articles=articles;


    }
    public static String [] images2 = {

        /*pepsi*/           "http://www.dkmarket.fr/1746-thickbox_default/canette-pepsi.jpg",
        /*milkshake*/       "https://www.browneyedbaker.com/wp-content/uploads/2012/01/white-russian-milkshake-1-550.jpg",
         /*coke*/           "https://static-pepper.dealabs.com/threads/thread_large/default/409350_1.jpg",
           /*jus fruit*/    "https://statics.monoprix.fr/course/g_1864437_jus-de-fruit-pomme-et-mangue.jpg?t=20170909033553",
          /*fanta*/         "http://drive.ochagkafe.by/images/stories/virtuemart/product/fanta-05l.jpg",
         /*jus d'orange*/   "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQT0hu3c_Bxyb4sWpCmMuVmiQlP9oeSVGxDrOoa9HoERmPCX1zk",



    };
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.drink_row_layout, parent, false );
        Articles article =  articles.get(position);

        TextView textViewName = (TextView) convertView.findViewById(R.id.tvName);
        textViewName.setText(article.getNom());

        TextView textViewDescription = (TextView) convertView.findViewById(R.id.Desc);
        textViewDescription.setText(article.getDescription());

        TextView textViewPrice = (TextView) convertView.findViewById(R.id.tvPrice);
        textViewPrice.setText(article.getPrix());

        TextView textViewdt = (TextView) convertView.findViewById(R.id.textView11);


       // Button btncart = (Button) convertView.findViewById(R.id.btnCart);

        ImageView imageView  = (ImageView) convertView.findViewById(R.id.ivImage);
        Glide.with(convertView.getContext()).load(images2[position]).into(imageView);




        return convertView;

    }
}
