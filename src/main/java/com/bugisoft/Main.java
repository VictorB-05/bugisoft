package com.bugisoft;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Menu principal
    public static void main(String[] args) throws JAXBException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Juego> juegos;

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
            try {
                juegos = Funcionalidades.generarJuegos();
                // Hacemos el Switch para elegir una opcion
                switch (opcion) {

                    case 1:
                        Funcionalidades.juegosCatalogo(juegos);
                        break;
                    case 2:
                        Funcionalidades.juegosGratis(juegos);
                        break;
                    case 3:
                        Funcionalidades.juegosDlc(juegos);
                        break;
                    case 4:
                        Funcionalidades.juegosRebaja(juegos);
                        break;
                    case 5:
                        Funcionalidades.juegosFecha(juegos);
                        break;
                    case 6:
                        Funcionalidades.juegosPrecio(juegos);
                        break;
                    case 7:
                        System.out.println("Saliendo . . . ");
                        return;
                    default:
                        System.out.println("Opción incorrecta. Intentalo de nuevo");

                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}