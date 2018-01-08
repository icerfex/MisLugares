package com.nextsofts.mislugares;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

/*su clase base de la clse MainActivity es la clase ListActivity*/

public class MainActivity extends AppCompatActivity {
   public AdaptadorLugares adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adaptador=new AdaptadorLugares(MainActivity.this);
        //setListAdapter(adaptador);

    }
    /*metodo listener que lo que hace es mostrar un objeto cuadro de dialogo con una seria de texto*/
    /*se crea un objeto Vista anonimos para esta clase*/
     /*se crea un cuadro de dialogo en esta clase*/
     /*recupero el dato de entrada del cuadro de dialogo y ya que es entero lo convierto en texto y paso a id
     * ---------------------------------------------------------------*/
    public void lanzarVistaLugar(View v){

        final EditText entrada=new EditText(MainActivity.this);
        entrada.setText("0");
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Seleccion de lugar")
                .setMessage("indica su id")
                .setView(entrada)
                .setPositiveButton("ok",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int whichButton){
                        long id=Long.parseLong(entrada.getText().toString());
                        Intent i=new Intent(MainActivity.this,VistaLugar.class);
                        i.putExtra("id",(long)id);
                        startActivity(i);
                    }
                })
        .setNegativeButton("cancelar",null).show();
    }

    /*este metodo dispone de tres parametros el listview que se a pulsado la vista pulsada dentro de este listview
    * y el id del elemento*/
    /*@Override
    protected void onListItemClick(ListView listView,View vista,int posicion,long id){
        super.onListItemClick(listView,vista,posicion,id);
        Intent i=new Intent(MainActivity.this,VistaLugar.class);
        i.putExtra("id",(long) id);
        startActivity(i);
    }*/



}
