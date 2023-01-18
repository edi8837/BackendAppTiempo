package ec.ups.edu.Heladeria.repositorios;

import ec.ups.edu.Heladeria.entidades.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepositorio extends CrudRepository<Producto, Long> {





    @Query("select p from Producto p where p.id = :id")
    Producto findAllProducto(Long id);

    @Query("select p.nombre from Producto p ")
    List<Producto> findAllNombre();




}