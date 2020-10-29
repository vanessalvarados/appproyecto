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
public class NowPlayingFragment extends Fragment {


    @BindView(R.id.rvMovies)
    RecyclerView rvProductos;
    private List<Articulo> articulos= new ArrayList<Articulo>();

    public NowPlayingFragment() {
        // Required empty public constructor
    }


    public void CargarLista(){
        articulos.removeAll(articulos);
        for(Articulo lista:ArticuloRepository.getListArticulo()){
            if(lista.getOferta().contains("N")) {
                articulos.add(lista);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);
        ButterKnife.bind(this, view);

        ArticuloRepository.inicializarData();
        CargarLista();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());

        rvProductos.setHasFixedSize(true);
        rvProductos.setLayoutManager(llm);

        TodosArticulosRecyclerViewAdapter adapter = new TodosArticulosRecyclerViewAdapter(getContext(), articulos);
        rvProductos.setAdapter(adapter);

        return view;
    }



}
