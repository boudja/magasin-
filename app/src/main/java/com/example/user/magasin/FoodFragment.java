package com.example.user.magasin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.magasin.adapters.ArticlesListAdapter;
import com.example.user.magasin.adapters.FoodListAdapter;
import com.example.user.magasin.config.ConfigRetrofit;
import com.example.user.magasin.model.Articles;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by user on 08/03/2018.
 */

public class FoodFragment extends Fragment {
    ConfigRetrofit config = new ConfigRetrofit();
    Retrofit retrofit = config.getConfig();
    private ListView listView;
    private List<Articles> articles;
    View view;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.food_fragment,null);
        listView = view.findViewById(R.id.list1);
        IArticles iArticles = retrofit.create(IArticles.class);
        Call call = iArticles.getFoodArticles();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                articles = (List<Articles>) response.body();
                listView.setAdapter(new FoodListAdapter(FoodFragment.this.getActivity(),articles));
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
