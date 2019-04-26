package com.example.user.magasin;

import com.example.user.magasin.model.Articles;
import com.example.user.magasin.model.User;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by user on 10/03/2018.
 */

public interface IArticles {

    @GET("getAllArticles")
    Call<List<Articles>> getAllArticles();

    @GET("getFoodArticles")
    Call<List<Articles>> getFoodArticles();

    @GET("getDrinkArticles")
    Call<List<Articles>> getDrinkArticles();

    @GET("getAdsByKeyword/{keyWord}")
    Call<List<Articles>> getAdsByKeyword(@Path("keyWord") String  keyWord);




}
