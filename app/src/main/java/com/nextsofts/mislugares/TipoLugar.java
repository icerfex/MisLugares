package com.nextsofts.mislugares;

/**
 * Created by ariel on 14-12-17.
 */
public enum  TipoLugar {
    /*se crean instancias de clase TipoLugar haciendo uso de su constructor*/
    OTROS("Otros",R.drawable.otros),
    RESTAURANTE("Restaurante",R.drawable.restaurante),
    BAR("Bar",R.drawable.bar),
    COPAS("Copas",R.drawable.copas),
    ESPECTACULO("Espectaculo",R.drawable.espectaculos),
    HOTEL("Hotel",R.drawable.hotel),
    COMPRAS("Compras",R.drawable.compras),
    EDUCACION("Educacion",R.drawable.educacion),
    DEPORTE("Deporte",R.drawable.deporte),
    NATURALEZA("Naturaleza",R.drawable.naturaleza),
    GASOLINERA("Gasolinera",R.drawable.gasolinera);
    private  final String texto;
    private  final int recurso;
    /*constructor de la clase TipoLugar*/
    private TipoLugar(String texto, int recurso) {
        this.texto = texto;
        this.recurso = recurso;
    }
    /*metodo geter que devuelve el nombre del tipo de lugar*/
    public String getTexto() {
        return texto;
    }
    /*metodo geter que me devuelve el nro de identificacion de la imagen*/
    public int getRecurso() {
        return recurso;
    }
    /*es un vector que me va a devolver un vector de cadenas de texto plaro
    * debuelve un vector lleno de nombres de tipos de lugares*/

    public static String[] getNombres(){
        String[] resultado=new String[TipoLugar.values().length];
        for (TipoLugar tipo:TipoLugar.values()){
            resultado[tipo.ordinal()]=tipo.texto;
        }
        return resultado;
    }
}
