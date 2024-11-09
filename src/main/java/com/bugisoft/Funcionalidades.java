package com.bugisoft;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class Funcionalidades {

    public static ArrayList<Juego> generarJuegos() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Bugisoft.class);
        // Creo un objeto que me permita leer el XML
        Unmarshaller unmarshaller = context.createUnmarshaller();
        // Mi JAXB, me devuelve una clase librería por lo que habrá que castear mi unmarsaller

        Bugisoft bugisoft = (Bugisoft) unmarshaller.unmarshal(new File("src/main/resources/steam.xml"));

        ArrayList<Juego> juegoArrayList = bugisoft.getJuegos();
        return juegoArrayList;
    }


    // Metodo 6 - muestra los juegos ordenados por precios en USD o EURO
    public static void juegosPrecio(ArrayList<Juego> juegos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige la divisa (1- USD, 2- EURO)");
        int moneda = scanner.nextInt();

        // Ordena los juegos por precio en la moneda seleccionada
        Collections.sort(juegos, new Comparator<Juego>() {
            @Override
            public int compare(Juego o1, Juego o2) {
//              // Determina el precio de o1 en funcion de la moneda seleccionada 1 para USD y cualqier otro en EUR, de igual manera para o2
                double precio1 = moneda == 1 ? o1.getPrecio().getUsa() : o1.getPrecio().getEu();
                double precio2 = moneda == 1 ? o2.getPrecio().getUsa() : o2.getPrecio().getEu();
                // Compara los dos precios usando Double.compare
                return Double.compare(precio1, precio2);
            }
        });
        // For each para determinar el precio en funcion de la moneda selecciona junto con su divisa
        for (Juego juego : juegos) {
            double precio = moneda == 1 ? juego.getPrecio().getUsa() : juego.getPrecio().getEu();
            String divisa = moneda == 1 ? "$" : "€";
            System.out.println(juego.getNombre() + " - Precio: " + divisa + String.format("%.2f", precio));
        }
    }

    //mostrar juegos con dlc
    public static  void juegosDlc(ArrayList<Juego> juegos) throws JAXBException {
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
    }
    //mostrar juegos por fecha
    public static void juegosFecha(ArrayList<Juego> juegos) throws JAXBException {
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
    public static void juegosRebaja(ArrayList<Juego> juegos) throws JAXBException {
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

    // Metodo 2 - Muestra los juegos que esten gratuitos
    public static void juegosGratis(ArrayList<Juego> juegos) {
        // For each por el cual recorre los juegos del archivo XML e imprime por pantalla
        // aquellos que tienen tanto el precio en USD y EUR igual a 0
        for (Juego juego : juegos) {
            if (juego.getPrecio().getEu() == 0 && juego.getPrecio().getUsa() == 0) {
                System.out.println("Juego gratis: " + juego.getNombre());
            }
        }
    }

    // Metodo 1 - Muestra el catalogo completo con su descripcion
    public static void juegosCatalogo(ArrayList<Juego> juegos) throws JAXBException {
        // For each por el cual se toma el nombre del juego de la lista junto con su descripcion
        for (Juego juego : juegos) {
            System.out.println("Nombre: " + juego.getNombre());
            System.out.println("Descripción: " + juego.getDescripcion().trim());
            System.out.println();
        }
    }


}
