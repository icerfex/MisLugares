package com.nextsofts.mislugares;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleccion de lugares
 * Created by ariel on 14-12-17.
 */
public class Lugares {

     public static List<Lugar> vectorLugares=ejemploLugares();

    public Lugares(){

        vectorLugares=ejemploLugares();
    }
    static Lugar elemento(int id)
    {
        return vectorLugares.get(id);
    }
    static void anyade(Lugar lugar){
       vectorLugares.add(lugar);
    }
    static int nuevo(){
        Lugar lugar=new Lugar();
        vectorLugares.add(lugar);
        return  vectorLugares.size()-1;
    }
    public static void borrar(int id){
        vectorLugares.remove(id);
    }
    public static int tamaño(){
        return vectorLugares.size();
    }

    public static ArrayList<Lugar> ejemploLugares(){
        ArrayList<Lugar> lugares=new ArrayList<Lugar>();

        lugares.add(new Lugar("Umss","oquendo",-0.16690,38.23454,72722039,"umss.edu.bo","bonito lugar",3,TipoLugar.EDUCACION));
        lugares.add(new Lugar("Teleferico","final heroinas",-2.343453,45.3434,34564544,"teleferico.com.bo","maravilloso",5,TipoLugar.NATURALEZA));
        return lugares;
    }
}
