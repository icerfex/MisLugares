package com.nextsofts.mislugares;

/**
 * Created by ariel on 13-12-17.
 */
public class GeoPunto {
    private double longitud,latitud;

  public GeoPunto(double longitud,double latitud){
     this.longitud=longitud;
      this.latitud=latitud;
  }
  @Override
  public String toString(){
      return new String("longitud="+longitud+",latitud="+latitud);
  }
  /*
  public double distancia(GeoPunto punto){

      final double RADIO_TIERRA=631000;
      double dLat=Math.toRadians(latitud-punto.latitud);
  }*/

    public double getLongitud() {return longitud;}

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
}
