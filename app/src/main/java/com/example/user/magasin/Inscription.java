package com.example.user.magasin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.magasin.config.ConfigRetrofit;
import com.example.user.magasin.model.User;


import org.apache.commons.validator.routines.EmailValidator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;




public class Inscription extends AppCompatActivity {
    public boolean isValidEmail(String e) {
        boolean valid = EmailValidator.getInstance().isValid(e);
        return valid;
    }

    EditText nom,prenom,email,pwd,tel;
    ConfigRetrofit config = new ConfigRetrofit();
    Retrofit retrofit = config.getConfig();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        Button btnAnnuler = (Button) findViewById(R.id.button2);


        btnAnnuler.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        Button btnValider = (Button) findViewById(R.id.button);



            btnValider.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view) {

                nom = (EditText) findViewById(R.id.editText1);
                prenom = (EditText) findViewById(R.id.editText2);
                email = (EditText) findViewById(R.id.editText3);
                tel = (EditText) findViewById(R.id.editText5);
                pwd = (EditText) findViewById(R.id.editText4);
            String Nom = nom.getText().toString();
            String Prenom = prenom.getText().toString();
            String Email = email.getText().toString();
            String Tel = tel.getText().toString();



            String Pwd = pwd.getText().toString();

            if(Nom.equals("") || Prenom.equals("") || Email.equals("")|| Tel.equals("") || Pwd.equals(""))

            {
                Toast.makeText(Inscription.this, " Veuillez Remplir tout les champs ", Toast.LENGTH_SHORT).show();
            }
            else if (isValidEmail(Email) && tel.length()==8)
            {
                IUser user = retrofit.create(IUser.class);
                User _user = new User(Email,Pwd,Nom,Prenom,Tel);
                Call<User> call = user.addUser(_user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(getApplicationContext(), " Ajout Effectué Mr : " + response.body().getNom(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(Inscription.this, "Erreur : " +t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            } else {

                Toast.makeText(Inscription.this, "Mail ou Numéro de tel invalid ", Toast.LENGTH_SHORT).show();

            }

            }
        });
    }
}
