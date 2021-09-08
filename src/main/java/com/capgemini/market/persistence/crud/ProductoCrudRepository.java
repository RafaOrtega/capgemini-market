package com.capgemini.market.persistence.crud;

import com.capgemini.market.domain.Product;
import com.capgemini.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> { //la Entity (Tabla) , Tipo de llave primaria
/* AQUI VAN LOS QUERYS 32:55
    @Query(value = "SELECT * from productos where id_categoria = ? order by nombres desc", nativeQuery = true)
    List<Producto> findByCategory(Integer idCategoria); //Query nativo
*/
    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria); //QueryMethods

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock, Boolean estado);

    @Modifying(clearAutomatically = true)
    @Query(
            value = "update Producto p set p.nombre = ? where p.idProducto = ?",
            nativeQuery = true)
    Optional<Producto> update(String nombre, Integer idProducto);

}
