package com.nagarro.serviceInterface;

import java.util.List;

import com.nagarro.entity.Product;
import com.nagarro.entity.Details;

public interface DetailServiceInterface {

    public List<Details> getAllDetails(Product product);

    public Long countAllComment();

    public Double getAverage(Product product);
}
