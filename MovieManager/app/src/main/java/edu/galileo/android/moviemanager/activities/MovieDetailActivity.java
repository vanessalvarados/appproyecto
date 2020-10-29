package edu.galileo.android.moviemanager.activities;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.fragments.carrito_fragment;
import edu.galileo.android.moviemanager.models.Articulo;

public class MovieDetailActivity extends AppCompatActivity {
/*
    Articulo articulo;
    @BindView(R.id.ivMovieBackdrop)
    ImageView ivMovieBackdrop;
    @BindView(R.id.tvOverview)
    TextView tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Articulo saved as favorite", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            articulo = (Articulo) extras.getSerializable("MOVIE");
            this.setTitle(articulo.getNombArticulo());
            tvOverview.setText(articulo.getMarca());

            Picasso.with(this)
                    .load(articulo.getUrl_imagen_poster())
                    .into(ivMovieBackdrop);

        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }*/
static Articulo producto;
    @BindView(R.id.ivMovieBackdrop)
    ImageView ivMovieBackdrop;
    @BindView(R.id.tvOverview)
    TextView tvOverview;
    /*@BindView(R.id.imagenJuego)
    ImageView imagenJuego;*/

    Context context;
    carrito_fragment carrritoC;
    static List<Articulo> listaCarrito = new ArrayList<Articulo>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = findViewById(R.id.fab);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();

        //obtiene los datos del Inten
        obtenerDatos(extras);

        //Para que se cambien los iconos
        cambiarIcono(fab);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(validaRepetido()){
                    listaCarrito.remove(producto);
                    fab.setImageResource(R.drawable.ic_add_black_24dp);
                    //fab.setBackgroundColor(123456);

                    Snackbar.make(view, "Juego retirado del carrito de compras", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else{
                    listaCarrito.add(producto);
                    fab.setImageResource(R.drawable.ic_remove_black_24dp);
                    //fab.setBackgroundColor(123456);
                    Snackbar.make(view, "Juego agregado al carrito de compras", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }


            }


        });

    }

    public void cambiarIcono(FloatingActionButton fab){
        if(validaRepetido()){
            fab.setImageResource(R.drawable.ic_remove_black_24dp);

        }else{
            fab.setImageResource(R.drawable.ic_add_black_24dp);


        }
    }
    //Obtener Datos
    public void obtenerDatos(Bundle extras){
        if (extras != null) {
            producto = (Articulo) extras.getSerializable("MOVIE");
            this.setTitle(producto.getNombArticulo());
            tvOverview.setText(producto.getMarca());
            //ObtenerImagenes(context,imagenJuego,producto.getUrl_image());
            ObtenerImagenes(context,ivMovieBackdrop,producto.getUrl_imagen_poster());

        }
    }

    //valida producto repetido
    public boolean validaRepetido(){
        for(Articulo listaNew:getListaCarrito()){
            if(listaNew.getId()==(producto.getId())){
                return true;
            }
        }
        return false;
    }

    //Obtine las imagenes
    public void ObtenerImagenes(Context contex,ImageView ivPoster,String recurso){
        if (recurso.isEmpty()) { //url.isEmpty()
            Picasso.with(context)
                    .load(R.drawable.ntfound)
                    .placeholder(R.drawable.ntfound)
                    .error(R.drawable.ntfound)
                    .into(ivPoster);

        }else{
            Picasso.with(context)
                    .load(recurso)
                    .error(R.drawable.ntfound)
                    .placeholder(R.drawable.ntfound)
                    .into(ivPoster); //this is your ImageView
        }

    }
    //Obtenemos la lista Carrito
    public static List<Articulo> getListaCarrito() {
        return listaCarrito;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
