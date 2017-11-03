package com.example.claudiopc.trigar;

/**
 * Created by 42200543 on 25/8/2017.
 */

public class Cotizacion {
    float cotizTrigo;
    float cotizMaiz;
    float cotizSoja;
    float cotizCebada;
    String cotizFecha;
        public void setCotizFecha(String cotizFecha) {
        this.cotizFecha = cotizFecha;
    }
    public void setCotizTrigo(float cotizTrigo) {
        this.cotizTrigo = cotizTrigo;
    }

    public void setCotizMaiz(float cotizMaiz) {
        this.cotizMaiz = cotizMaiz;

    }

    public void setCotizSoja(float cotizSoja) {
        this.cotizSoja = cotizSoja;
    }

    public void setCotizCebada(float cotizCebada) {
        this.cotizCebada = cotizCebada;
    }

   public String getCotizFecha()
   {
       return cotizFecha;
   }
    public float getCotizTrigo()
    {
        return cotizTrigo;
    }

    public float getCotizMaiz()
    {
        return cotizMaiz;
    }

    public float getCotizSoja()
    {
        return cotizSoja;
    }

    public float getCotizCebada()
    {
        return cotizCebada;
    }


}
