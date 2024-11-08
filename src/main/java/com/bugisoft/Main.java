package com.bugisoft;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //aplicar metodos javax
        try{

            FuncianlidadesV.juegosDlc();
            FuncianlidadesV.fechaJuego();
            FuncianlidadesV.rebajaJuego();


//            JAXBContext context = JAXBContext.newInstance(Bugisoft.class);
//            // Creo un objeto que me permita leer el XML
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            //Mi JAXB, me devuelve una clase librería por lo que habrá que castear mi unmarsaller
//
//            Bugisoft bugisoft = (Bugisoft) unmarshaller.unmarshal(new File("src/main/resources/steam.xml"));
//
//            ArrayList<Juego> juegoArrayList = bugisoft.getJuegos();
//
//            for (Juego juego : juegoArrayList){
//                System.out.println(juego.getNombre()+" USA:"+juego.getPrecio().getUsa()+"$ EU:"+juego.getPrecio().getEu()+"€");
//            }
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}