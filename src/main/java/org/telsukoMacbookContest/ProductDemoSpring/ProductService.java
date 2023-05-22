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
//        products.add(p);
        db.save(p);
    }

    public List<Product> getAllProducts(){
//        return products;
        return db.findAll();
    }


    public List<Product> getProduct(String name){
//        for(Product p : products){
//            if(p.getName().equals(name))
//                return p;
//        }
//        return null;
        return db.findByNameIgnoreCase(name);
    }
    public List<Product> getProductWithText(String text) {
//        String str = text.toLowerCase();
//        List<Product> prods = new ArrayList<>();
//
//        for(Product p : products){
//            String name = p.getName().toLowerCase();
//            String type = p.getType().toLowerCase();
//            String place = p.getPlace().toLowerCase();
//            if(name.contains(str) || type.contains(str) || place.contains(str))
//                prods.add(p);
//        }
//        return prods;
        return db.findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase(text,text,text);
    }
    public List<Product> searchByPlace(String place){
//        List<Product> pro = new ArrayList<>();
//        for(Product p: products){
//            if(p.getPlace().equalsIgnoreCase(place)){
//                pro.add(p);
//            }
//        }
//        return pro;
        return db.findByPlaceIgnoreCase(place);
    }
    public List<Product> searchOutOfWarranty() {
//        List<Product> outOfWarrantyProducts = new ArrayList<>();
//        for(Product p: products){
//            if(p.getWarranty()< Year.now().getValue()){
//                outOfWarrantyProducts.add(p);
//            }
//        }
//        return outOfWarrantyProducts;

        int currentYear = Year.now().getValue();
        return db.findByWarrantyLessThan(currentYear);
    }

}
