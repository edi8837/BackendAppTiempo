package ec.ups.edu.Heladeria.controladores;

import ec.ups.edu.Heladeria.entidades.Producto;
import ec.ups.edu.Heladeria.entidades.peticiones.producto.CalcularProducto;
import ec.ups.edu.Heladeria.entidades.peticiones.producto.CrearProducto;
import ec.ups.edu.Heladeria.servicios.ProductoNoEncontradoException;
import ec.ups.edu.Heladeria.servicios.ProductoServicios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import java.util.Optional;

import org.json.simple.*;



@RestController
@RequestMapping("/Producto/")
public class ProductoControlador {
    JSONArray list = new JSONArray();
    private ProductoServicios productoServicios;

    private static final Logger log = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    public ProductoControlador(ProductoServicios productoServicios) {
        this.productoServicios = productoServicios;
    }


    @GetMapping("Productos")
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> listaProductos = productoServicios.findAll();
        return new ResponseEntity<List<Producto>>(listaProductos, HttpStatus.OK);
    }
    @GetMapping("/hola") //obtener el listado de Pedidos
    public ResponseEntity<String> hola() {

        return new ResponseEntity<String>("hola mundo", HttpStatus.OK);
    }






    @GetMapping("/producto/id/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long id){
        Optional<Producto> productoOptional = Optional.ofNullable(productoServicios.retrieveAllProducto(id));
        Producto producto = productoOptional.orElseThrow(ProductoNoEncontradoException::new);
        producto.getNombre().toString();
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }


    @PostMapping("/Calculo")
    public ResponseEntity<?> Calular(@RequestBody CalcularProducto calcularProducto) {


        File borrar = new File("calculo.json");
        borrar.delete();

        JSONObject calculao = new JSONObject();

        calculao.put("nombrePocuto", calcularProducto.getNombreProducto());
        calculao.put("cantidad", calcularProducto.getCantidad());
        calculao.put("construcción ", calcularProducto.getTimepo1());
        calculao.put("galvanizado ", calcularProducto.getTiempo2());
        calculao.put("armado", calcularProducto.getTiempo3());
        calculao.put("final", calcularProducto.getTiempofinal());


        list.add(calculao);
        System.out.println(list);
        try {
            FileWriter fw = new FileWriter("calculo.json", true);


            fw.write(list.toJSONString());
            fw.close();

            return new ResponseEntity<JSONArray>(list, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }


    @PostMapping("/create")
    public ResponseEntity<Producto> createTarjeta(@RequestBody CrearProducto crearProducto){

        Producto producto = new Producto();

        producto.setNombre(crearProducto.getNombre());
        producto.setTiempo1(crearProducto.getTiempo1());
        producto.setTiempo2(crearProducto.getTiempo2());
        producto.setTiempo3(crearProducto.getTiempo3());
        productoServicios.save(producto);

            return   ResponseEntity.ok(producto);
    }

    @DeleteMapping("/delete/{prodcutoId}")
    public ResponseEntity<?> eliminarServicioUsuario(@PathVariable("prodcutoId") Long servicioId){
        try{
            Optional<Producto> servicioOptional = productoServicios.findById(servicioId);
            if(servicioOptional.isEmpty()){
                String mensaje = "El servicio con id " + servicioId +" no existe";
                log.info(mensaje);
                return ResponseEntity.badRequest().body(mensaje);
            }

            productoServicios.removeid(servicioId);
            return ResponseEntity.ok().build();

        }catch (Exception ex){
            log.error("No se puede eliminar el servicio con id: '{}'. Error: {}", servicioId, ex.getMessage());
            return ResponseEntity.badRequest().body("Ha ocurrido un error inesperado. Por favor, inténtelo nuevamente.");
        }
    }

}
