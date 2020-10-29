package edu.galileo.android.moviemanager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.adapters.TodosArticulosRecyclerViewAdapter;
import edu.galileo.android.moviemanager.models.Articulo;
import edu.galileo.android.moviemanager.models.ArticuloRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {

    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;
    private List<Articulo> ListaOfertas = new ArrayList<>();



    public UpcomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);

        ButterKnife.bind(this, view);

        //carga los datos
        initializeData();

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);

        TodosArticulosRecyclerViewAdapter adapter = new TodosArticulosRecyclerViewAdapter(this.getContext(), ListaOfertas);
        rvMovies.setAdapter(adapter);

        return view;
    }


    //carga la lista de ofertas
    private void initializeData() {
        ListaOfertas.removeAll(ListaOfertas);
        for(Articulo listaJuegos: ArticuloRepository.getListArticulo()){
            if(listaJuegos.getOferta().contains("S")){
                listaJuegos.setValorDescuento(String.valueOf(listaJuegos.getPrecioArticulo()-(listaJuegos.getPrecioArticulo()*listaJuegos.getPorcentajeDescuento()/100)));
                ListaOfertas.add(listaJuegos);
            }

        }
    }

}
