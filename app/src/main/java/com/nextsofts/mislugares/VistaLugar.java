package com.nextsofts.mislugares;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class VistaLugar extends AppCompatActivity {
    /*declaracion de atributo para contener un nro entero de longitud grande*/
    private long id;
    /*declaracion de atributo para contener un objeto de la clase lugar*/
    public Lugar lugar;
    /*declaracion de atributos para contener objetos Vista*/
    TextView nombre;
    ImageView logo_tipo;
    TextView tipo;
    TextView direccion;
    TextView telefono;
    TextView url;
    TextView comentario;
    TextView fecha;
    TextView hora;
    @TargetApi(24)
    @Override
    protected void onCreate(Bundle guardarestado){
        super.onCreate(guardarestado);
        setContentView(R.layout.vista_lugar);
        /*recuperando datos desde el objeto VistaLugar*/
        Bundle extras=getIntent().getExtras();
        id =extras.getLong("id");
        /*recuperando un objeto del vector por medio de su id.*/
        lugar=Lugares.elemento((int)id);

        actualizarVistas();
    }
    /*metodos para poder inflar menus en la barra de acciones*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.vista_lugar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.accion_compartir:
                return true;
            case R.id.accion_llegar:
                return true;
            case R.id.accion_editar:
                lanzarEdicionLugar();
                return true;
            case R.id.accion_borrar:
                Lugares.borrar((int)id);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /*metodo que nos permite navegar de esta actividad a otra actividad*/
    public void lanzarEdicionLugar(){
        Intent i=new Intent(VistaLugar.this,EdicionLugar.class);
        i.putExtra("id",(long) id);
        startActivityForResult(i,1234);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
       if(requestCode==1234){
           actualizarVistas();
           findViewById(R.id.scrollView1).invalidate();
       }
    }

    public void actualizarVistas(){
       /*asignacion de objetos View a los atributos declarados anteriormente*/
        nombre= (TextView) findViewById(R.id.nombre);
        nombre.setText(lugar.getNombre());
        logo_tipo= (ImageView) findViewById(R.id.LogoTipo);
        logo_tipo.setImageResource(lugar.getTipo().getRecurso());
        tipo= (TextView) findViewById(R.id.tipo);
        tipo.setText(lugar.getTipo().getTexto());
        direccion= (TextView) findViewById(R.id.direccion);
        direccion.setText(lugar.getDireccion());
        telefono= (TextView) findViewById(R.id.telefono);
        telefono.setText(Integer.toString(lugar.getTelefono()));
        url= (TextView) findViewById(R.id.url);
        url.setText(lugar.getUrl());
        comentario= (TextView) findViewById(R.id.comentario);
        comentario.setText(lugar.getComentario());
        fecha = (TextView) findViewById(R.id.fecha);
        fecha.setText(lugar.getFecha());
        hora= (TextView) findViewById(R.id.hora);
        hora.setText(lugar.getHora());

        final RatingBar valoracion= (RatingBar) findViewById(R.id.valoracion);
        valoracion.setRating(lugar.getValoracion());
        valoracion.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        lugar.setValoracion(v);
                    }
                });
    }
}
