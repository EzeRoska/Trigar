package com.example.claudiopc.trigar;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 42200543 on 25/8/2017.
 */

public class RssHandler extends DefaultHandler {
    boolean buscarCereal;


    MainActivity mainActivity;
    public String cotizTrigo = "";
    public String cotizMaiz = "";
    public String cotizSoja = "";
    public String cotizCebadaGirasol = "";
    boolean encontrado;
    boolean encontradoTrigo;
    boolean encontradoMaiz;
    boolean encontradoSoja;
    boolean encontradoCebadaGirasol;
    String cereal;

    public class Noticia {

    }

    private Cotizacion Cotizaciones;
    private Cotizacion Cotizacionactual;
    private StringBuilder builder;

    public Cotizacion getCotizaciones() {
        return Cotizaciones;
    }


    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        super.characters(ch, start, length);
        if (buscarCereal) {
            String nombreCereal = "";
            for (int i = 0; i < length; i++)
                nombreCereal += ch[i];
            cereal = nombreCereal;
            buscarCereal = false;

        }
        if (encontradoTrigo) {
            cotizTrigo = "";
            for (int i = 0; i < length; i++){

                cotizTrigo += ch[i];
            }
            float cotizTrigoFloat = Float.parseFloat(cotizTrigo);
            encontradoTrigo = false;
            Cotizaciones.setCotizTrigo(cotizTrigoFloat);
            Log.d("Encontre", cotizTrigo);
        }
        if (encontradoMaiz) {
            cotizMaiz = "";
            for (int i = 0; i < length; i++) {
                cotizMaiz += ch[i];
            }
            float cotizMaizFloat = Float.parseFloat(cotizMaiz);
            encontradoMaiz = false;
            Cotizaciones.setCotizMaiz(cotizMaizFloat);
            Log.d("Encontre", cotizMaiz);
        }
        if (encontradoSoja) {
            cotizSoja = "";
            for (int i = 0; i < length; i++) {
                cotizSoja += ch[i];
            }
            float cotizSojaFloat = Float.parseFloat(cotizSoja);
            encontradoSoja = false;
            Cotizaciones.setCotizSoja(cotizSojaFloat);
            Log.d("Encontre", cotizSoja);
        }
        if (encontradoCebadaGirasol) {
            cotizCebadaGirasol = "";
            for (int i = 0; i < length; i++) {
                cotizCebadaGirasol += ch[i];
            }
            float cotizCebadaFloat = Float.parseFloat(cotizCebadaGirasol);
            encontradoCebadaGirasol = false;
            Cotizaciones.setCotizCebada(cotizCebadaFloat);
            Log.d("Encontre", cotizCebadaGirasol);
        }
        if (this.Cotizacionactual != null) {
            builder.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {

        super.endElement(uri, localName, name);

        if (this.Cotizacionactual != null) {
            if (localName.equals("nombre")) {
                //Cotizacionactual.setNombre(builder.toString());
            }
            //Cotizaciones.add(Cotizacionactual);
/*
            if (localName.equals("title")) {
                Cotizacionactual.setTitulo(sbTexto.toString());
            } else if (localName.equals("link")) {
                Cotizacionactual.setLink(sbTexto.toString());
            } else if (localName.equals("description")) {
                Cotizacionactual.setDescripcion(sbTexto.toString());
            } else if (localName.equals("guid")) {
                Cotizacionactual.setGuid(sbTexto.toString());
            } else if (localName.equals("pubDate")) {
                Cotizacionactual.setFecha(sbTexto.toString());
            } else if (localName.equals("item")) {
                noticias.add(Cotizacionactual);
            }

            sbTexto.setLength(0);
            */
        }
    }

    @Override
    public void startDocument() throws SAXException {

        super.startDocument();

        Cotizaciones = new Cotizacion();
        builder = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName,
                             String name, Attributes attributes) throws SAXException {

        super.startElement(uri, localName, name, attributes);
        if (name.equals("nombre")) {
            buscarCereal = true;
        }

        if (name.equals("valor")) {
            String id = (String) attributes.getValue(0);
            if (id.equals("t_1_val")) {
                if (cereal.equals("Trigo")) {
                    encontradoTrigo = true;
                }
            }
            if (id.equals("m_1_val")) {
                if (cereal.equals("Maíz")) {
                    encontradoMaiz = true;
                }
            }
            if (id.equals("s_1_val")) {
                if (cereal.equals("Soja")) {
                    encontradoSoja = true;
                }
            }
            if (id.equals("g_1_val")) {
                if (cereal.equals("Girasol")) {
                    encontradoCebadaGirasol = true;
                }

            }
        }


        if (localName.equals("data")) {
            Cotizacionactual = new Cotizacion();
        }
    }

}



