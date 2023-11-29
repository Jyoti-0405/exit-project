package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.Product;
import com.nagarro.entity.Details;
import com.nagarro.repository.DetailRepository;
import com.nagarro.serviceInterface.DetailServiceInterface;
@Service
public class DetailService {

    @Autowired
    private DetailRepository repo;

    //This method is used to get list of review
    public List<Details> getAllDetails(Product product){
        return repo.findByProduct(product);
    }

    //This method is used to get all count review
    public Long countAllComment()
    {
        return	repo.count();
    }

}
