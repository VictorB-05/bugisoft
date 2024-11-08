package com.bugisoft;
import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;

@XmlRootElement(name="juego")
@XmlType(propOrder={"id", "nombre", "precio", "fecha", "descripcion", "DLC", "rebaja"})
public class Juego {
    //Añadir datos de juegos
    private String id;
    private String nombre;
    private Precio precio;
    private Fecha fecha;
    private String descripcion;
    private ArrayList<String> DLC;
    private Rebaja rebaja;
    private LocalDate fechaL;

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name="precio")
    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    @XmlElement(name="fecha")
    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    @XmlElement(name="descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlElementWrapper(name="DLC")
    @XmlElement(name = "nombre")
    public ArrayList<String> getDLC() {
        return DLC;
    }

    public void setDLC(ArrayList<String> DLC) {
        this.DLC = DLC;
    }

    @XmlElement(name="rebaja")
    public Rebaja getRebaja() {
        return rebaja;
    }

    public void setRebaja(Rebaja rebaja) {
        this.rebaja = rebaja;
    }

    public boolean dclIsntNull(){
        return DLC!=null;
    }

    public void fechaGenerate(){
        fechaL =  LocalDate.of(getFecha().getAnyo(),getFecha().getMes(),getFecha().getDia());
    }

    public LocalDate getFechaL() {
        return fechaL;
    }

    public boolean rebajaIsNull(){
        return rebaja==null;
    }

}
