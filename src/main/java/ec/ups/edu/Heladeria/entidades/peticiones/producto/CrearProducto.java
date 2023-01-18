package ec.ups.edu.Heladeria.entidades.peticiones.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Transient;

public class CrearProducto {

    @JsonProperty
    private String nombre;
    @JsonProperty
    private int tiempo1;
    @JsonProperty
    private int tiempo2;
    @JsonProperty
    private int tiempo3;

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
}
