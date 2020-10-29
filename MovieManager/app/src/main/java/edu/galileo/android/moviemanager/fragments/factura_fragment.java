package edu.galileo.android.moviemanager.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.MovieDetailActivity;
import edu.galileo.android.moviemanager.adapters.ArticuloRecyvlerViewAdapter;
import edu.galileo.android.moviemanager.adapters.TodosArticulosRecyclerViewAdapter;
import edu.galileo.android.moviemanager.models.Articulo;


public class factura_fragment extends Fragment {


    @BindView(R.id.rvJuegos)
    RecyclerView rvJuegos;
    @BindView(R.id.txtTotal)
    TextView txtTotal;
    @BindView(R.id.txtDesceuntos)
    TextView txtDesceuntos;
    @BindView(R.id.txtTotalPagar)
    TextView txtTotalPagar;


   /* @BindView(R.id.search)
    SearchView searchView;*/

    //private TodosArticulosRecyclerViewAdapter adapter;
    // private List<Movie> movies;
    public static ArrayList<Articulo> imageMovieArrayList2= new ArrayList<Articulo>();

    public factura_fragment() {
        // Required empty public constructor
    }

    // @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_factura_fragment, container, false);
        ButterKnife.bind(this, view);
        //ProductoRepository.initializeData();
        //CargarLista();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvJuegos.setHasFixedSize(true);
        rvJuegos.setLayoutManager(llm);

        ArticuloRecyvlerViewAdapter adapter = new ArticuloRecyvlerViewAdapter(this.getContext(), MovieDetailActivity.getListaCarrito());
        rvJuegos.setAdapter(adapter);

        //idNitems.setText(String.valueOf(MovieDetailActivity.getListaCarrito().size()));
        txtTotal.setText(Obtener_SubTotal());
        txtDesceuntos.setText("- "+Obtener_TotalDescuestos());
        txtDesceuntos.setTextColor(Color.parseColor("#ff0000"));
        txtTotalPagar.setText(Obtener_TotalFactura());

        return view;
    }

    //Calcula la factura
    public String Obtener_TotalFactura() {
        DecimalFormat formateador = new DecimalFormat("####.##");
        String result = "";
        double total = 0.0;
        for (Articulo listaJuegos : MovieDetailActivity.getListaCarrito()) {
            if (listaJuegos.getOferta().contains("N")) {
                total = total + listaJuegos.getPrecioArticulo();
            } else {
                total = total + Double.parseDouble(listaJuegos.getValorDescuento());
            }
        }
        return result=(String.valueOf(total));
    }

    //Calcula la factura
    public String Obtener_TotalDescuestos() {
        String result = "";
        String results = "";
        double descuestos=0.0;
        DecimalFormat formateador = new DecimalFormat("###.##");
        try {

            for (Articulo listaJuegos : MovieDetailActivity.getListaCarrito()) {
                if (listaJuegos.getOferta().contains("S")) {
                    descuestos = descuestos + ( listaJuegos.getPrecioArticulo()-Double.parseDouble(listaJuegos.getValorDescuento()));
                }
            }
            result=String.valueOf(descuestos);
            descuestos = formateador.parse(result).doubleValue();
        } catch (ParseException e) {
            // Error. El usuario ha escrito algo que no se puede convertir
            // a número.
        }

        return results=String.valueOf(descuestos);
    }

    //Calcula la factura
    public String Obtener_SubTotal() {
        String result = "";
        double total = 0.0;
        String results = "";
        DecimalFormat formateador = new DecimalFormat("###.##");
        try {

            for (Articulo listaJuegos : MovieDetailActivity.getListaCarrito()) {
                total = total + listaJuegos.getPrecioArticulo();
            }
            result=String.valueOf(total);
            total = formateador.parse(result).doubleValue();
        } catch (ParseException e) {
            // Error. El usuario ha escrito algo que no se puede convertir
            // a número.
        }

        return results=String.valueOf(total);
    }

}
