package org.teluskoMacbookContest.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class ProductService {

    ProductDB db;
    @Autowired
    public ProductService(ProductDB db){
        this.db=db;
    }

    public Product addProduct(Product p){
        return db.save(p);
    }

    public void deleteProductById(int id){
        db.deleteById(id);
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
