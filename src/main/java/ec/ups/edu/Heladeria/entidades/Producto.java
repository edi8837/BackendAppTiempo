package ec.ups.edu.Heladeria.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="tiempo1")
    private int tiempo1;
    @Column(name="tiempo2")
    private int tiempo2;
    @Column(name="tiempo3")
    private int tiempo3;


    public Producto() {

    }

    public Producto(long id, String nombre, int tiempo1, int tiempo2, int tiempo3) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo1 = tiempo1;
        this.tiempo2 = tiempo2;
        this.tiempo3 = tiempo3;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo1() {
        return tiempo1;
    }

    public void setTiempo1(int tiempo1) {
        this.tiempo1 = tiempo1;
    }

    public int getTiempo2() {
        return tiempo2;
    }

    public void setTiempo2(int tiempo2) {
        this.tiempo2 = tiempo2;
    }

    public int getTiempo3() {
        return tiempo3;
    }

    public void setTiempo3(int tiempo3) {
        this.tiempo3 = tiempo3;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tiempo1=" + tiempo1 +
                ", tiempo2=" + tiempo2 +
                ", tiempo3=" + tiempo3 +
                '}';
    }
}
