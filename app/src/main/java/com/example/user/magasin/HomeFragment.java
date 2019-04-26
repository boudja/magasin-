package com.example.user.magasin;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.magasin.adapters.ArticlesListAdapter;
import com.example.user.magasin.config.ConfigRetrofit;
import com.example.user.magasin.model.Articles;
import com.squareup.picasso.Picasso;


import java.io.File;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by user on 09/03/2018.
 */

public class HomeFragment extends Fragment {


    ConfigRetrofit config = new ConfigRetrofit();
    Retrofit retrofit = config.getConfig();
    private ListView listView;
    private List<Articles> articles;
    private SearchView sv;
    View view;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.home_fragment,null);


        listView = view.findViewById(R.id.list);
        /*
        sv.setQueryHint("Search...");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String txt) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String txt) {
                new ArticlesListAdapter(HomeFragment.this.getActivity(),articles).getFilter().filter(txt);

                return false;
            }
        });*/
        IArticles iArticles = retrofit.create(IArticles.class);
        Call call = iArticles.getAllArticles();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                articles = (List<Articles>) response.body();
                listView.setAdapter(new ArticlesListAdapter(HomeFragment.this.getActivity(),articles));



            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getActivity(), " Failed ! ", Toast.LENGTH_SHORT).show();

            }
        });





        return view;

    }




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
