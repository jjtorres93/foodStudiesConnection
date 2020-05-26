package com.mycompany.foodstudiesconnection;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Fsc appManager = new Fsc();
        Usuario[] usuarios = new Usuario[10];
        Publicacion[] publicaciones = new Publicacion[10];
        int capacidadUsers = 0;
        int capacidadArticulos = 0;
        int opcion = appManager.menu();
        ComparadorDeNick c = new ComparadorDeNick();

        while (opcion != 7) {
            switch (opcion) {
                case 1:
                    if (capacidadUsers < usuarios.length) {
                        usuarios[capacidadUsers] = appManager.darDeAlta();
                        capacidadUsers++;
                    } else {
                        System.out.println("Capacidad máxima alcanzada.");
                    }
                    break;
                case 2:
                    boolean borrado = appManager.borrarUsuario(usuarios, capacidadUsers);
                    if (borrado) {
                        capacidadUsers--;
                    } else {
                        System.out.println("Usuario no existe.");
                    }
                    break;
                case 3:
                    appManager.leerPublicacion();
                    break;
                case 4:
                    if (capacidadArticulos < publicaciones.length) {
                        publicaciones[capacidadArticulos] = appManager.crearArticulo();
                        capacidadArticulos++;
                    } else {
                        System.out.println("Capacidad náxima alcanzada.");
                    }
                    break;
                case 5:
                    for (int i = 0; i < capacidadUsers; i++) {
                        System.out.println(usuarios[i].nombre + " " + usuarios[i].nick + " " + usuarios[i].apellido);
                    }
                    break;
                case 6:
                    Arrays.sort(usuarios, 0, capacidadUsers, c);
                    appManager.mostrarUsuarios(usuarios, capacidadUsers);

                    break;

            }
        }

    }

}
