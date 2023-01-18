package ec.ups.edu.Heladeria.entidades.peticiones.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalcularProducto {

    @JsonProperty
    private long  id;
    @JsonProperty
    private String NombreProducto;
    @JsonProperty
    private String cantidad;
    @JsonProperty
    private String timepo1;
    @JsonProperty
    private String tiempo2;
    @JsonProperty
    private String tiempo3;

    @JsonProperty
    private String tiempofinal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTimepo1() {
        return timepo1;
    }

    public void setTimepo1(String timepo1) {
        this.timepo1 = timepo1;
    }

    public String getTiempo2() {
        return tiempo2;
    }

    public void setTiempo2(String tiempo2) {
        this.tiempo2 = tiempo2;
    }

    public String getTiempo3() {
        return tiempo3;
    }

    public void setTiempo3(String tiempo3) {
        this.tiempo3 = tiempo3;
    }

    public String getTiempofinal() {
        return tiempofinal;
    }

    public void setTiempofinal(String tiempofinal) {
        this.tiempofinal = tiempofinal;
    }
}
