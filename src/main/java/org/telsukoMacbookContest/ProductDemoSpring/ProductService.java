package org.telsukoMacbookContest.ProductDemoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductDB db;
    @Autowired
    public ProductService(ProductDB db){
        this.db=db;
    }

    public void addProduct(Product p){
        db.save(p);
    }

    public List<Product> getAllProducts(){
        return db.findAll();
    }

    public List<Product> getProduct(String name){
        return db.findByNameIgnoreCase(name);
    }
    public List<Product> getProductWithText(String text) {
        return db.findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase(text,text,text);
    }
    public List<Product> searchByPlace(String place){
        return db.findByPlaceIgnoreCase(place);
    }
    public List<Product> searchOutOfWarranty() {
        int currentYear = Year.now().getValue();
        return db.findByWarrantyLessThan(currentYear);
    }

}
