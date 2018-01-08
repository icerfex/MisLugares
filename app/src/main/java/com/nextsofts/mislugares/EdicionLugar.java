package com.nextsofts.mislugares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EdicionLugar extends AppCompatActivity {

    /*declaracion de atributos para contener objetos Vista*/
    EditText nombre;
    Spinner tipo;
    EditText direccion;
    EditText telefono;
    EditText url;
    EditText comentario;
    long id;
    Lugar lugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicion_lugar);
        /*asignacion de objetos vista a las variables declaradas en esta clase*/
        nombre= (EditText) findViewById(R.id.nombre);
        tipo= (Spinner) findViewById(R.id.tipo);
        direccion= (EditText) findViewById(R.id.direccion);
        telefono= (EditText) findViewById(R.id.telefono);
        url= (EditText) findViewById(R.id.url);
        comentario= (EditText) findViewById(R.id.comentario);
        /*creamos una coleccion ArrayAdapter que almacenara un conjunto de objetos para luego pasarla al tipo Spiner*/
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(EdicionLugar.this,
                                       android.R.layout.simple_spinner_item,
                                       TipoLugar.getNombres());
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adaptador);
        //tipo.setSelection(lugar.getTipo().ordinal());

        Bundle extras=getIntent().getExtras();
        id =extras.getLong("id");
        lugar=Lugares.elemento((int)id);

        nombre.setText(lugar.getNombre());
        direccion.setText(lugar.getDireccion());
        telefono.setText(Integer.toString(lugar.getTelefono()));
        url.setText(lugar.getUrl());
        comentario.setText(lugar.getComentario());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.edicion_lugar,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_save:
                guardarCambios();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void guardarCambios(){
        lugar.setNombre(nombre.getText().toString());
        lugar.setTipo(TipoLugar.values()[tipo.getSelectedItemPosition()]);
        lugar.setDireccion(direccion.getText().toString());
        lugar.setTelefono(Integer.parseInt(telefono.getText().toString()));
        lugar.setUrl(url.getText().toString());
        lugar.setComentario(comentario.getText().toString());
        finish();
    }
}
