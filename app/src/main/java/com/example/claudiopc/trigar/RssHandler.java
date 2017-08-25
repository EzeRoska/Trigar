package com.example.claudiopc.trigar;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 42200543 on 25/8/2017.
 */

public class RssHandler extends DefaultHandler {
    public class Noticia
    {

    }
    private List<Cotizacion> Cotizaciones;
    private Cotizacion Cotizacionactual;
    private StringBuilder builder;

    public List<Cotizacion> getCotizaciones(){
        return Cotizaciones;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        super.characters(ch, start, length);

        if (this.Cotizacionactual != null){
            builder.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {

        super.endElement(uri, localName, name);

        if (this.Cotizacionactual != null) {
            if (localName.equals("nombre")) {
                Cotizacionactual.setNombre(builder.toString());
            }
            Cotizaciones.add(Cotizacionactual);
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

        Cotizaciones = new ArrayList<Cotizacion>();
        builder = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName,
                             String name, Attributes attributes) throws SAXException {

        super.startElement(uri, localName, name, attributes);

        if (localName.equals("data")) {
            Cotizacionactual = new Cotizacion();
        }
    }
}

