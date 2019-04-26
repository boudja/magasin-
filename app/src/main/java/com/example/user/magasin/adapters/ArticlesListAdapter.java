package com.example.user.magasin.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.magasin.R;
import com.example.user.magasin.model.Articles;

import java.util.List;

/**
 * Created by user on 10/03/2018.
 */

public class ArticlesListAdapter extends ArrayAdapter<Articles> {

    private Context context;
    private List<Articles> articles;


    public ArticlesListAdapter(Context context,List<Articles> articles) {
        super(context, R.layout.articles_row_layout,articles);
        this.context=context;
        this.articles=articles;





    }
    public static String [] images = {
 /*sandwich*/      "https://3.bp.blogspot.com/-gCaYUUdzli0/WqajZOGMFGI/AAAAAAAAARg/ibMFiIV2NjU9_EsW2inbSyF2cI6detSmQCLcBGAs/s320/sandwich.jpg",
         /*makloub*/        "http://static.onamangepourvous.tn//uploads/2015/10/11866275_1606234756295835_3308694197108841829_n.jpg",
          /*pizza thon*/    "https://www.amourdecuisine.fr/wp-content/uploads/2014/12/pizza-au-thon-012-610x330.jpg",
          /*pepperoni*/     "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSizYfxEhesc6x8dET58LW5UTKQahGz9eLbKKMJaYMk9C0pqtY2fQ",
          /*panini*/        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDJxXT5ld8OkNSWl7hDNbA431QAM7jpQGJTVlw03Bs0_FYC9vReQ",
       /*roti*/             "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDP3NbBB3TMkfRQskIAo-W-xtVMYhs0D4F600WfRfGNq8qJnzT",


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
        convertView = layoutInflater.inflate(R.layout.articles_row_layout, parent, false );
        Articles article =  articles.get(position);

        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewName.setText(article.getNom());

        TextView textViewDescription = (TextView) convertView.findViewById(R.id.Desc);
        textViewDescription.setText(article.getDescription());

        TextView textViewPrice = (TextView) convertView.findViewById(R.id.txt);
        textViewPrice.setText(article.getPrix());

        ImageView imageView  = (ImageView) convertView.findViewById(R.id.ivImage);

        Glide.with(convertView.getContext()).load(images[position]).into(imageView);



    /*   String path = article.getImage();
        Log.v("PATH", path);
        File imgFile= new File(path);

        if(imgFile.exists())
        {
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(bitmap);
        }
        else
        {
            Log.v("IMAGE NOT FOUND", "IMAGE NOT FOUND");
        }*/

        return convertView;
    }
}
