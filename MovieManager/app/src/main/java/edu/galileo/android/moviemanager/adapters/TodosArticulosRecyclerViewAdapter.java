package edu.galileo.android.moviemanager.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.activities.MovieDetailActivity;
import edu.galileo.android.moviemanager.models.Articulo;

/**
 * Created by isabelpalomar.
 */

public class TodosArticulosRecyclerViewAdapter extends RecyclerView.Adapter<TodosArticulosRecyclerViewAdapter.ViewHolder> {

    List<Articulo> articulos;
    Context context;

    public TodosArticulosRecyclerViewAdapter(Context context, List<Articulo> articulos){
        this.articulos = articulos;
        this.context = context;

    }

    private Context getContext(){
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Articulo articulo = articulos.get(position);

        holder.txtTitulo.setText(articulo.getNombArticulo());
        holder.txtDescripcion.setText(articulo.getMarca());
        //holder.ratingBar.setNumStars((int)articulo.getRating());
        holder.ratingBar.setRating((float) articulo.getRating());
        if(articulo.getOferta().contains("S")){
            holder.txtPalaraOferta.setText("OFERTA");
            holder.txtPalaraOferta.setTextColor(Color.parseColor("#FF4081"));

            //Normal
            holder.txtPrecio.setText("$ "+String.valueOf(articulo.getValorDescuento()));
            holder.txtPrecio.setTextColor(Color.parseColor("#FF4081"));
            //Tachado
            holder.textPrecioDescuento.setPaintFlags(holder.textPrecioDescuento.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);

            //descuesto
           // holder.textViewPrice_s2.setText("$");
           // holder.textViewPrice_s2.setTextColor(Color.parseColor("#c0c0c0"));
            holder.textPrecioDescuento.setText("$ "+String.valueOf(articulo.getPrecioArticulo()));
            holder.textPrecioDescuento.setTextColor(Color.parseColor("#c0c0c0"));
            //holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));




        }else{
            holder.textPrecioDescuento.setText("$ "+String.valueOf(articulo.getPrecioArticulo()));
        }


        Picasso.with(getContext())
                .load(articulo.getUrl_imagen())
                .into(holder.ivMovieImage);

    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.ivMovieImage)
        ImageView ivMovieImage;
        @BindView(R.id.tvTitle)
        TextView txtTitulo;
        @BindView(R.id.tvOverview)
        TextView txtDescripcion;
        @BindView(R.id.cvMovie)
        CardView cvMovie;
        @BindView(R.id.txtPalaraOferta)
        TextView txtPalaraOferta;
        @BindView(R.id.myRatingBar)
        RatingBar ratingBar;
        @BindView(R.id.precio1)
        TextView txtPrecio;
        @BindView(R.id.precio2)
        TextView textPrecioDescuento;


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Articulo articulo = articulos.get(getAdapterPosition());

            Intent intent = new Intent(getContext(), MovieDetailActivity.class);
            intent.putExtra("MOVIE", articulo);
            getContext().startActivity(intent);

        }
    }
}
