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

public class FoodListAdapter extends ArrayAdapter<Articles> {
    private Context context;
    private List<Articles> articles;

    public FoodListAdapter(Context context,List<Articles> articles) {
        super(context, R.layout.food_row_layout,articles);
        this.context=context;
        this.articles=articles;


    }
    public static String [] images = {

            /*sandwich*/      "https://3.bp.blogspot.com/-gCaYUUdzli0/WqajZOGMFGI/AAAAAAAAARg/ibMFiIV2NjU9_EsW2inbSyF2cI6detSmQCLcBGAs/s320/sandwich.jpg",
         /*makloub*/        "http://static.onamangepourvous.tn//uploads/2015/10/11866275_1606234756295835_3308694197108841829_n.jpg",
          /*pizza thon*/    "https://www.amourdecuisine.fr/wp-content/uploads/2014/12/pizza-au-thon-012-610x330.jpg",
          /*pepperoni*/     "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSizYfxEhesc6x8dET58LW5UTKQahGz9eLbKKMJaYMk9C0pqtY2fQ",
          /*panini*/        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDJxXT5ld8OkNSWl7hDNbA431QAM7jpQGJTVlw03Bs0_FYC9vReQ",
       /*roti*/             "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDP3NbBB3TMkfRQskIAo-W-xtVMYhs0D4F600WfRfGNq8qJnzT"



    };
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.food_row_layout, parent, false );
        Articles article =  articles.get(position);

        TextView textViewName = (TextView) convertView.findViewById(R.id.tvName);
        textViewName.setText(article.getNom());

        TextView textViewDescription = (TextView) convertView.findViewById(R.id.Desc);
        textViewDescription.setText(article.getDescription());

        TextView textViewPrice = (TextView) convertView.findViewById(R.id.tvPrice);
        textViewPrice.setText(article.getPrix());

        TextView textViewdt = (TextView) convertView.findViewById(R.id.textView11);


        //Button btncart = (Button) convertView.findViewById(R.id.btnCart);

        ImageView imageView  = (ImageView) convertView.findViewById(R.id.ivImage);
        Glide.with(convertView.getContext()).load(images[position]).into(imageView);



        return convertView;

    }
}
