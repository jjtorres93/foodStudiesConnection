package com.mycompany.foodstudiesconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listaAutores")
public class Autor implements Comparable<Autor> {

    String nombre;
    String apellido;
    List<Publicacion> articulosPublicados = new ArrayList();
    List<Autor> listaDeAutores = new ArrayList();
    String[] tituloArticulo;
    Connection conexion;

    public void getConexion() {
        conexion = new DBConector().getConexion();
    }

    public void closeConexion() throws SQLException {
        conexion.close();
    }

    public void cargarBD() throws SQLException {
        String sql = "SELECT * FROM Autores";
        Statement stm = conexion.createStatement();
        ResultSet data = stm.executeQuery(sql);
        while (data.next()) {
            listaDeAutores.add(new Autor(data.getString("nombre"), data.getString("apellido")));
        }

    }

    public List<Autor> getListaDeAutores() {
        return listaDeAutores;
    }

    public void setListaDeAutores(List<Autor> listaDeAutores) {
        this.listaDeAutores = listaDeAutores;
    }

    public String[] getTituloArticulos() {
        return tituloArticulo;
    }

    public void setTituloArticulos(String[] tituloArticulos) {
        this.tituloArticulo = tituloArticulos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
//constructor

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public int compareTo(Autor o) {
        String nombrecompleto = getNombre() + getApellido();
        String oNombrecompleto = o.nombre + o.apellido;
        return nombrecompleto.compareTo(oNombrecompleto);
    }
}
