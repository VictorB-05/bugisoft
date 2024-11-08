package com.bugisoft;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class FuncianlidadesV {
    //mostrar juegos con dlc
    public static  void juegosDlc() throws JAXBException {
        ArrayList<Juego> juegos = generarJuegos();
        // pasamos por todos los juegos del array
        for(Juego juego : juegos){
            //Miramos si el juego tiene DLC
            if(juego.dclIsntNull()){
                System.out.print(juego.getNombre()+"\n DLC:\t");
                //Y sacas por pantalla el nombre de cada DLC
                for(String dlc : juego.getDLC()){
                    System.out.print(dlc+", ");
                }
                System.out.println("");
            }
        }
        // juegos.stream()
        //              .filter(Juego::isDlc)
        //              .forEach(juego -> System.out.println(juego.getNombre()));
    }
    //mostrar juegos por fecha
    public static void fechaJuego() throws JAXBException {
        ArrayList<Juego> juegos = generarJuegos();
        //generamos las fechas de los juegos
        for(Juego juego : juegos){
            juego.fechaGenerate();
        }
        //cogemos cuantos juegos hay
        int limite = juegos.size();
        // hacemos un for en el cual comaparmos cual es la fecha mayor
        for(int i = 0; i< limite;i++){
            Juego fecha = null;
            for(Juego juego : juegos){
                if(fecha == null){
                    fecha = juego;
                } else if (!fecha.getFechaL().isAfter(juego.getFechaL())) {
                    fecha = juego;
                }
            }
            // printeamos el precio y la fecha y removemos el juego de la lista
            System.out.println(fecha.getNombre()+"\t "+fecha.getFechaL()+"\t "+fecha.getPrecio().getEu()+"€");
            juegos.remove(fecha);
        }
    }

    //mostrar juegos con rebajas
    public static void rebajaJuego() throws JAXBException {
        ArrayList<Juego> juegos = generarJuegos();
        for(Juego juego : juegos){
            //Miramos si el juego tiene rebaja
            if(juego.rebajaIsNull()){
               juegos.remove(juego);
            }
        }
        //cogemos cuantos juegos hay
        int limite = juegos.size();
        // hacemos un for en el cual comaparmos cual es la rebaja mayor
        for(int i = 0; i< limite;i++){
            Juego rebaja = null;
            for(Juego juego : juegos){
                if(rebaja == null){
                    rebaja = juego;
                } else if (rebaja.getRebaja().getDescuento()<juego.getRebaja().getDescuento()) {
                    rebaja = juego;
                }
            }
            // printeamos el precio y el desucento y removemos el juego de la lista
            float precioD = rebaja.getPrecio().getEu()*rebaja.getRebaja().getDescuento()/100;
            System.out.println(rebaja.getNombre()+"\t "+ rebaja.getPrecio().getEu()+"€\t" + rebaja.getRebaja().getDescuento()
                    +"%\t "+ (precioD)+"€");
            juegos.remove(rebaja);
        }
    }

    public static ArrayList<Juego> generarJuegos() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Bugisoft.class);
        // Creo un objeto que me permita leer el XML
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Mi JAXB, me devuelve una clase librería por lo que habrá que castear mi unmarsaller
        Bugisoft bugisoft = (Bugisoft) unmarshaller.unmarshal(new File("src/main/resources/steam.xml"));
        //Metemos los juegos en un Arraylist y los returneamos
        ArrayList<Juego> juegoArrayList = bugisoft.getJuegos();
        return juegoArrayList;
    }
}
