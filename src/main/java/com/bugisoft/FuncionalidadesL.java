package com.bugisoft;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class FuncionalidadesL {

    public static ArrayList<Juego> generarJuegos() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Bugisoft.class);
        // Creo un objeto que me permita leer el XML
        Unmarshaller unmarshaller = context.createUnmarshaller();
        // Mi JAXB, me devuelve una clase librería por lo que habrá que castear mi unmarsaller

        Bugisoft bugisoft = (Bugisoft) unmarshaller.unmarshal(new File("src/main/resources/steam.xml"));

        ArrayList<Juego> juegoArrayList = bugisoft.getJuegos();
        return juegoArrayList;
    }

    // Menu principal
    public static void menu(String[] args) throws JAXBException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Juego> juegos;

        try {
            juegos = generarJuegos();

        } catch (JAXBException e) {
            e.printStackTrace();
            return;

        }

        while (true) {

            System.out.println("\n MENU:");
            System.out.println("1- Mostrar catálogo");
            System.out.println("2- Mostrar juegos gratis");
            System.out.println("3- Mostrar juegos con sus DLC's");
            System.out.println("4- Mostrar precio con rebaja y su precio original");
            System.out.println("5- Mostrar fecha de lanzamiento de más nuevo a más antiguo");
            System.out.println("6- Mostrar precio por DOLLARS o EUROS");
            System.out.println("7- Salir");
            System.out.println("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            // Hacemos el Switch para elegir una opcion
            switch (opcion) {

                case 1:
                    juegosCatalogo(juegos);
                    break;
                case 2:
                    juegosGratis(juegos);
                    break;
                case 3:
                    juegosDlc(juegos);
                    break;
                case 4:
                    juegosRebaja(juegos);
                    break;
                case 5:
                    juegosFecha(juegos);
                    break;
                case 6:
                    juegosPrecio(juegos);
                    break;
                case 7:
                    System.out.println("Saliendo . . . ");
                    return;
                default:
                    System.out.println("Opción incorrecta. Intentalo de nuevo");

            }

        }

    }
    // Metodo 6 - muestra los juegos ordenados por precios en USD o EURO
    private static void juegosPrecio(ArrayList<Juego> juegos) {
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

    // Metodo 5 - Muestra los juegos por fecha de lanzamiento, de mas nmuevo a mas antiguo
    private static void juegosFecha(ArrayList<Juego> juegos) {

    }//

    // Metodo 4- Muestra los juegos con rebajas y su precio original
    private static void juegosRebaja(ArrayList<Juego> juegos) {

    }

    // Metodo 3 - Muestra los juegos con sus DLC's
    private static void juegosDlc(ArrayList<Juego> juegos) {

    }

    // Metodo 2 - Muestra los juegos que esten gratuitos
    private static void juegosGratis(ArrayList<Juego> juegos) {
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
