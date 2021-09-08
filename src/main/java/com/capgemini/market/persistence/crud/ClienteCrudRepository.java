package com.capgemini.market.persistence.crud;

import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.Product;
import com.capgemini.market.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente,String> {

    @Query(value = "UPDATE productos WHERE id_categoria = ?", nativeQuery = true)
    List<Product> update(Integer idCategoria);

}
