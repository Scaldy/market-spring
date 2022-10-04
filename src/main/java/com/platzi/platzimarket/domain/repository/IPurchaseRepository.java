package com.platzi.platzimarket.domain.repository;

import com.platzi.platzimarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {
    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String clientId);

    Purchase save(Purchase purchase);

    Optional<Purchase> getPurchase(int purchaseId);

    void delete(int purchaseId);
}