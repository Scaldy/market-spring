package com.platzi.platzimarket.persistence;

import com.platzi.platzimarket.domain.Purchase;
import com.platzi.platzimarket.domain.repository.IPurchaseRepository;
import com.platzi.platzimarket.persistence.crud.ICompraCrudRepository;
import com.platzi.platzimarket.persistence.entity.Compra;
import com.platzi.platzimarket.persistence.mapper.IPurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements IPurchaseRepository {
    @Autowired
    private ICompraCrudRepository compraCrudRepository;

    @Autowired
    private IPurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }

    @Override
    public Optional<Purchase> getPurchase(int purchaseId) {
        return compraCrudRepository.findById(purchaseId)
                .map(compra -> mapper.toPurchase(compra));
    }

    @Override
    public void delete(int purchaseId) {
        compraCrudRepository.deleteById(purchaseId);
    }
}
