package com.platzi.platzimarket.domain.service;

import com.platzi.platzimarket.domain.Purchase;
import com.platzi.platzimarket.domain.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private IPurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<Purchase> getPurchase(int purchaseId){
        return purchaseRepository.getPurchase(purchaseId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public boolean delete(int purchaseId){
        if (getPurchase(purchaseId).isPresent()) {
            purchaseRepository.delete(purchaseId);
            return true;
        } else {
            return false;
        }
    }
}
