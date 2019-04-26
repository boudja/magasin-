package com.example.user.magasin;

import com.example.user.magasin.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by user on 03/03/2018.
 */

public interface IUser {

    @GET("getAllUsers")
    Call<List<User>> getAllUsers();

    @GET("getUserByID{id}")
    Call<User> getUserByID(@Path("id") long id );


    @GET("login/{username}/{password}")
    Call<User> login (@Path("username") String login , @Path("password") String password);
    /*
    @GET("insertUserByID/{mail}/{mdp}/{nom}/{prenom}/{tel}")
    Call<String> insertUserByID (@Path("mail") String mail , @Path("mdp") String mdp , @Path("nom") String nom , @Path("prenom") String prenom , @Path("tel") String tel);
*/
    @POST("addUser")
    Call<User> addUser(@Body User user);

}

