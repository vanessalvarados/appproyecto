package edu.galileo.android.moviemanager.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.moviemanager.R;
import edu.galileo.android.moviemanager.models.Articulo;

public class ArticuloRecyvlerViewAdapter extends RecyclerView.Adapter<ArticuloRecyvlerViewAdapter.ViewHolder> {


    List<Articulo> productos;
    Context context;
    //Array para el filtro
   /* public static ArrayList<Producto> imageModelArrayList= new ArrayList<Producto>();
    private ArrayList<Producto> arraylist;*/



    public ArticuloRecyvlerViewAdapter(Context context, List<Articulo> movies){
        this.productos = movies;
        this.context = context;

    }

    private Context getContext(){
        return context;
    }

    @Override
    public ArticuloRecyvlerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articulo_fact, parent, false);

        return new ArticuloRecyvlerViewAdapter.ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(ArticuloRecyvlerViewAdapter.ViewHolder holder, int position) {

        Articulo producto = productos.get(position);
        holder.txtTitulo.setText(producto.getNombArticulo());
        if(producto.getOferta().contains("S")){
            //Normal
            holder.txtPrecio.setText(String.valueOf(producto.getValorDescuento()));
            holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));
            //Tachado
            holder.textPrecioDescuento.setPaintFlags(holder.textPrecioDescuento.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);

            //descuesto
            holder.textViewPrice_s2.setText("$");
            holder.textViewPrice_s2.setTextColor(Color.parseColor("#c0c0c0"));
            holder.textPrecioDescuento.setText(String.valueOf(producto.getPrecioArticulo()));
            holder.textPrecioDescuento.setTextColor(Color.parseColor("#c0c0c0"));
            //holder.txtPrecio.setTextColor(Color.parseColor("#ff0000"));

        }else{
            holder.txtPrecio.setText(String.valueOf(producto.getPrecioArticulo()));
        }

        ObtenerImagenes(producto,holder);


    }



    //Obtener Imagenes
    public void ObtenerImagenes(Articulo producto,ArticuloRecyvlerViewAdapter.ViewHolder holder){
        if (producto.getUrl_imagen().isEmpty()) { //url.isEmpty()
            Picasso.with(context)
                    .load(R.drawable.ntfound)
                    .placeholder(R.drawable.ntfound)
                    .error(R.drawable.ntfound)
                    .into(holder.imPortada);

        }else{
            Picasso.with(context)
                    .load(producto.getUrl_imagen())
                    .error(R.drawable.ntfound)
                    .placeholder(R.drawable.ntfound)
                    .into(holder.imPortada); //this is your ImageView
        }

    }


    @Override
    public int getItemCount() {
        return productos.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivImagenJuego)
        ImageView imPortada;
        @BindView(R.id.textNombreJuego)
        TextView txtTitulo;
        @BindView(R.id.textViewPrices)
        TextView txtPrecio;
        @BindView(R.id.cvGamesFact)
        CardView cvFactura;
        @BindView(R.id.textPrecioDescuentos)
        TextView textPrecioDescuento;
        @BindView(R.id.textViewPrice_ss2)
        TextView textViewPrice_s2;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            //view.setOnClickListener(this);

        }

       /* @Override
        public void onClick(View v) {

            Producto movie = productos.get(getAdapterPosition());

            Intent intent = new Intent(getContext(), MovieDetailActivity.class);
            intent.putExtra("MOVIE", movie);
            getContext().startActivity(intent);

        }*/
    }

}
