package com.example.user.magasin;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.Fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.magasin.adapters.ArticlesListAdapter;
import com.example.user.magasin.config.ConfigRetrofit;
import com.example.user.magasin.model.Articles;
import com.quinny898.library.persistentsearch.SearchBox;
import com.quinny898.library.persistentsearch.SearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Acceuil extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToogle;
    private Toolbar nToolbar;

    private SearchBox box;
    private SearchResult option;
    private EditText search;
    private List<Articles> articles;
    private ListView listView;
    private TextView tvEmail,tvName;


    ConfigRetrofit config = new ConfigRetrofit();
    Retrofit retrofit = config.getConfig();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Boudja Shop");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        nToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(nToolbar);

        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        nToogle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.open, R.string.close);

        nDrawerLayout.addDrawerListener(nToogle);
        nToogle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.idnav);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (ListView) findViewById(R.id.list);
        /*search = (EditText) findViewById(R.id.search);
        search.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    final String keyWord = search.getText().toString();
                    IArticles ad = retrofit.create(IArticles.class);
                    if (!keyWord.equals("")) {
                        Call<List<Articles>> call = ad.getAdsByKeyword(keyWord);
                        call.enqueue(new Callback<List<Articles>>() {
                            @Override
                            public void onResponse(Call<List<Articles>> call, Response<List<Articles>> response) {

                                articles = (List<Articles>) response.body();
                                if(articles.size() != 0)
                                {
                                    listView.setAdapter(new ArticlesListAdapter(getApplicationContext(), articles));

                                    Toast.makeText(Acceuil.this, "Recherche par le mot clé : " + keyWord, Toast.LENGTH_SHORT).show();


                                }
                                else
                                {
                                    Toast.makeText(Acceuil.this, "Aucun emploi ne correspond au mot clé saisi, veuillez réessayer", Toast.LENGTH_LONG).show();
                                   // callAdsList();
                                }
                            }

                            @Override
                            public void onFailure(Call<List<Articles>> call, Throwable t) {
                                Toast.makeText(Acceuil.this, "Erreur : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else
                    {
                    //    callAdsList();
                    }

                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    return true;
                }
                return  false;

            }


        });*/
        LayoutInflater layoutInflater =LayoutInflater.from(getApplicationContext());
        View view = layoutInflater.inflate(R.layout.navigation_header,null);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvName = (TextView) view.findViewById(R.id.tvName);

        SharedPreferences sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        String uMail = sharedPreferences.getString("email","dss");
        String uName = sharedPreferences.getString("name", "kkj");

       // Toast.makeText(this, "Email : " + uMail +" NOM " +uName, Toast.LENGTH_SHORT).show();

        tvEmail.setText(uMail);
        tvName.setText(uName);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;


        int id = item.getItemId();

        if ( id==R.id.nav_home) {

            fragment = new HomeFragment();



        } else if ( id==R.id.nav_food) {

            fragment = new FoodFragment();


        } else if ( id==R.id.nav_drinks) {
            fragment = new DrinkFragment();




        } else if ( id==R.id.nav_logout) {
            startActivity(new Intent(Acceuil.this, MainActivity.class));


        }


        if (fragment!=null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();

            ft.replace(R.id.l_layout,fragment);
            ft.commit();


        }

        nDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (nToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }