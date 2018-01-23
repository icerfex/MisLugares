package com.nextsofts.mislugares;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

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


    private ImageView imageView;
    public final static  int RESULTADO_EDITAR=1;
    public final static  int RESULTADO_GALERIA=2;
    public final static int RESULTADO_FOTO=3;

    private Uri urifoto;

    @TargetApi(24)
    @Override
    protected void onCreate(Bundle guardarestado){
        super.onCreate(guardarestado);
        setContentView(R.layout.vista_lugar);
        /*recuperando datos desde el cuadro de dialogo de la clase MainActivity*/
        Bundle extras=getIntent().getExtras();
        id =extras.getLong("id");
        lugar=Lugares.elemento((int)id);
        imageView=(ImageView) findViewById(R.id.foto);
        actualizarVistas();
    }

    public void tomarFoto(View view){
        Intent i=new Intent("android.media.action.IMAGE_CAPTURE");
        urifoto=Uri.fromFile(new File(Environment.getExternalStorageDirectory()+ File.separator+"img_"+(System.currentTimeMillis()/1000)+"jpg"));
        i.putExtra(MediaStore.EXTRA_OUTPUT,urifoto);
        startActivityForResult(i,RESULTADO_FOTO);
    }


    public void galeria(View view){
      Intent i=new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        startActivityForResult(i,RESULTADO_GALERIA);
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
    /*metodo que nos permite navegar de esta actividad a otra actividad para esto nos tenemos que preguntar
    * que necesito para editar un elemento de un grupo de elementos pues su identificador la misma le mandamos por medio
    * de la inension con el metodo putExtra()*/
    public void lanzarEdicionLugar(){
        Intent i=new Intent(VistaLugar.this,EdicionLugar.class);
        i.putExtra("id",(long) id);
        startActivityForResult(i,1234);
    }
    @Override
    /*con el metodo actualizarVistas() lo que se queiere lograr es refrscar la vista del iu*/
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
       if(requestCode==RESULTADO_EDITAR){
           actualizarVistas();
           //findViewById(R.id.scrollView1).invalidate();
       }else if(requestCode==RESULTADO_GALERIA && resultCode== Activity.RESULT_OK){
           lugar.setFoto(data.getDataString());
           ponerFoto(imageView,lugar.getFoto());
           Log.d("l","hola");
       }else if(requestCode==RESULTADO_FOTO&&resultCode==Activity.RESULT_OK&&lugar!=null&&urifoto!=null){
         lugar.setFoto(urifoto.toString());
           ponerFoto(imageView,lugar.getFoto());
       }
    }

    protected void ponerFoto(ImageView imageView,String uri){
        if(uri!=null){
            imageView.setImageURI(Uri.parse(uri));
        }else{
            imageView.setImageBitmap(null);
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

        ponerFoto(imageView,lugar.getFoto());
    }
}
