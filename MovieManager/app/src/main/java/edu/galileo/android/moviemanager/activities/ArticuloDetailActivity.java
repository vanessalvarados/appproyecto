package edu.galileo.android.moviemanager.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import edu.galileo.android.moviemanager.R;


public class ArticuloDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Mi Factura");

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
