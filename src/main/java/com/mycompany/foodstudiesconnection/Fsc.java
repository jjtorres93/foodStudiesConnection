package com.mycompany.foodstudiesconnection;

import java.io.*;
import java.util.Scanner;

//Se llama FSC por que es la abreviación de FoodStudiesConnecction
public class Fsc {

    private BufferedReader in;
    private BufferedWriter wr;
    String autor;
    Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println("");
        System.out.println("1. Crear usuario");
        System.out.println("2. Borrar usuario");
        System.out.println("3. Leer artículo");
        System.out.println("4. Escribir un artículo");
        System.out.println("5. Listar");
        System.out.println("6. Ordenar usuarios por nick");
        System.out.println("7. Salir");
        System.out.println("");
        return sc.nextInt();

    }

    public Usuario darDeAlta() {
        System.out.println("Nick:");
        String alias = sc.nextLine();
        System.out.println("Nombre:");
        String nombreUser = sc.nextLine();
        System.out.println("Apellido/s:");
        String apellisdoUser = sc.nextLine();
        return new Usuario(alias, nombreUser, apellisdoUser);

    }

    public boolean borrarUsuario(Usuario[] listaUsers, int capacidadOcupada) {
        boolean existeUsuario = false;
        System.out.println("Introduzca el nick del usuario que desea borrar:");
        String usuario = sc.nextLine();
        int posicion = 0;
        for (int i = 0; i < capacidadOcupada && !existeUsuario; i++) {
            existeUsuario = listaUsers[i].nick.equals(usuario);
            posicion++;
        }
        if (existeUsuario) {
            for (int i = posicion; i < capacidadOcupada - 1; i++) {
                listaUsers[posicion] = listaUsers[posicion + 1];
            }
        }
        return existeUsuario;
    }

    public void mostrarUsuarios(Usuario[] listaUsers, int capacidadOcupada) {
        for (int i = 0; i < capacidadOcupada; i++) {
            System.out.println(listaUsers[i].nick + " " + listaUsers[i].nombre + " " + listaUsers[i].apellido);
        }
    }

    public void leerPublicacion() throws FileNotFoundException, IOException {
        System.out.println("¿Qué artículo quiere leer?");
        String titulo = sc.nextLine();
        in = new BufferedReader(new FileReader(titulo));
        String linea = in.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = in.readLine();
        }
    }

    public void escribirPublicacion(Publicacion publicacion) throws IOException {

        wr = new BufferedWriter(new FileWriter(publicacion.titulo));
        System.out.println("Escriba línea a línea usando intro para cada salto de línea");
        System.out.println("Para cerrar el documento escriba fin");
        String linea = sc.nextLine();
        while (!linea.equals("fin")) {
            wr.write(sc.nextLine());
            linea = sc.nextLine();
        }
        System.out.println("Publicación " + publicacion.titulo + " de " + publicacion.autor + " creada con éxito.");
    }

    public Publicacion crearArticulo() {
        System.out.println("Título:");
        String elTitulo = sc.nextLine();
        System.out.println("Autor:");
        String elAutor = sc.nextLine();
        return new Publicacion(elTitulo, elAutor);
    }
}
