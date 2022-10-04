package com.platzi.platzimarket.persistence.crud;

import com.platzi.platzimarket.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ICompraCrudRepository extends CrudRepository<Compra, Integer> {
    // Estos son Query Methods, los que se extienen al CRUD

    Optional<List<Compra>> findByIdCliente(String idCliente);
}
