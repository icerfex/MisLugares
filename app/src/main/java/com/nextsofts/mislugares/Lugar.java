package com.nextsofts.mislugares;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ariel on 13-12-17.
 */
public class Lugar {
    private String nombre;
    private String direccion;
    private  GeoPunto posicion;
    private String foto;
    private int telefono;
    private  String url;
    private String comentario;
    private Calendar calendario;
    private SimpleDateFormat formatoSimpleDato;
    private SimpleDateFormat formatoDatoHora;
    private String fecha;
    private String hora;
    private float valoracion;
    private TipoLugar tipo;

    /*(entradas de la actividad principal)nombre, tipo,direccion,telefono,url,comentrio*/
    public Lugar(String nombre,String direccion,double longitud,double latitud,
                 int telefono, String url,String comentario,int valoracion,
                 TipoLugar tipo){

        this.nombre=nombre;
        this.direccion=direccion;
        posicion=new GeoPunto(longitud,latitud);
        this.telefono=telefono;
        this.url=url;
        this.comentario=comentario;
        calendario=Calendar.getInstance();
        formatoSimpleDato=new SimpleDateFormat("dd-MM-yy");
        fecha=formatoSimpleDato.format(calendario.getTime());
        formatoDatoHora=new SimpleDateFormat("HH:mm:ss");
        hora=formatoDatoHora.format(calendario.getTime());
        this.valoracion=valoracion;
        this.tipo=tipo;
    }
    public Lugar(){
        calendario=Calendar.getInstance();
        formatoSimpleDato=new SimpleDateFormat("dd-MM-yy");
        fecha=formatoSimpleDato.format(calendario.getTime());
        formatoDatoHora=new SimpleDateFormat("HH:mm:ss");
        hora=formatoDatoHora.format(calendario.getTime());
        posicion=new GeoPunto(0,0);
        tipo=TipoLugar.OTROS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public GeoPunto getPosicion() {
        return posicion;
    }

    public void setPosicion(GeoPunto posicion) {
        this.posicion = posicion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha(){return fecha;}

    public String getHora(){return hora;}

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public TipoLugar getTipo() {
        return tipo;
    }

    public void setTipo(TipoLugar tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", posicion=" + posicion +
                ", foto='" + foto + '\'' +
                ", telefono=" + telefono +
                ", url='" + url + '\'' +
                ", comentario='" + comentario + '\'' +
                ", fecha=" + fecha +
                ", valoracion=" + valoracion +
                ", tipo=" + tipo +
                '}';
    }

}
