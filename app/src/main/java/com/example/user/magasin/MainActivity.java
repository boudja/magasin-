package com.example.user.magasin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.magasin.config.ConfigRetrofit;
import com.example.user.magasin.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    EditText login, pwd;
    TextView _mail, _nom;
    String uMail,uName;

     Button btConnect, btInscri ;

    ConfigRetrofit config = new ConfigRetrofit();
    Retrofit retrofit = config.getConfig();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Boudja Shop");

        login = (EditText) findViewById(R.id.editText2);
        pwd = (EditText) findViewById(R.id.editText3);

        btInscri = (Button) findViewById(R.id.button);
        btInscri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Inscription.class));

            }
        });




        btConnect = (Button) findViewById(R.id.button4);

        login();

    }



    public void login() {



        btConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(MainActivity.this,Acceuil.class));

           //     _mail = (TextView) findViewById(R.id.textView3);
             //   _nom = (TextView) findViewById(R.id.text1);

                final String email = login.getText().toString();
                final String password = pwd.getText().toString();
                if (!email.equals("") && !password.equals("")) {


                    IUser user = retrofit.create(IUser.class);
                    Call<User> call = user.login(email, password);
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {

                            String mail=response.body().getMail().toString();
                            String name=response.body().getNom().toString();


                            startActivity(new Intent(MainActivity.this,Acceuil.class));

                            Toast.makeText(MainActivity.this, " Salut : " + response.body().getPrenom().toString() , Toast.LENGTH_SHORT).show();
                            SharedPreferences sp=getSharedPreferences("Login", Context.MODE_PRIVATE);
                            SharedPreferences.Editor Ed=sp.edit();
                            Ed.putString("email",mail );
                            Ed.putString("ename",name );
                            Ed.apply();




                           /* _mail.setText(uMail);
                            _nom.setText(uName);*/


                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(MainActivity.this, " Email ou Mot de passe Incorrect ! ", Toast.LENGTH_SHORT).show();
                        }
                    });


                } 
                else 
                {
                    Toast.makeText(MainActivity.this, " Veuillez saisir votre email et mot de passe ", Toast.LENGTH_SHORT).show();
                }
            }
            });

    }







}





