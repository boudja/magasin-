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
import com.example.user.magasin.adapters.DrinkListAdapter;
import com.example.user.magasin.config.ConfigRetrofit;
import com.example.user.magasin.model.Articles;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by user on 09/03/2018.
 */

public class DrinkFragment extends Fragment {
    ConfigRetrofit config = new ConfigRetrofit();
    Retrofit retrofit = config.getConfig();
    private ListView listView;
    private List<Articles> articles;
    View view;
    public static String [] images2 = {

        /*pepsi*/           "http://www.dkmarket.fr/1746-thickbox_default/canette-pepsi.jpg",
        /*milkshake*/       "https://www.browneyedbaker.com/wp-content/uploads/2012/01/white-russian-milkshake-1-550.jpg",
         /*coke*/           "https://static-pepper.dealabs.com/threads/thread_large/default/409350_1.jpg",
           /*jus fruit*/    "https://statics.monoprix.fr/course/g_1864437_jus-de-fruit-pomme-et-mangue.jpg?t=20170909033553",
          /*fanta*/         "http://drive.ochagkafe.by/images/stories/virtuemart/product/fanta-05l.jpg",
         /*jus d'orange*/   "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQT0hu3c_Bxyb4sWpCmMuVmiQlP9oeSVGxDrOoa9HoERmPCX1zk",



    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.drink_framgent,null);
        listView = view.findViewById(R.id.list2);
        IArticles iArticles = retrofit.create(IArticles.class);
        Call call = iArticles.getDrinkArticles();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                articles = (List<Articles>) response.body();
                listView.setAdapter(new DrinkListAdapter(DrinkFragment.this.getActivity(),articles));
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
