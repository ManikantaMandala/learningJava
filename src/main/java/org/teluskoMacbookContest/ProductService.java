package org.teluskoMacbookContest;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Stream<Product> getAllProductsUsingStream(){
        return products.stream();
    }

    public Product getProduct(String name){
        for(Product p : products){
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }
    public Stream<Product> getProductUsingStreams(String name) {
        return products.stream().filter(x->x.getName().equalsIgnoreCase(name));
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str))
                prods.add(p);
        }
        return prods;
    }

    public Stream<Product> getProductWithTextUsingStreams(String text){
        return products.stream().filter(x->{return x.getName().toLowerCase().contains(text)||
                x.getType().toLowerCase().contains(text)||
                x.getPlace().toLowerCase().contains(text);});
    }
    
    public List<Product> searchByPlace(String place){
        List<Product> pro = new ArrayList<>();
        for(Product p: products){
            if(p.getPlace().equalsIgnoreCase(place)){
                pro.add(p);
            }
        }
        return pro;
    }

    public Stream<Product> searchByPlaceUsingStreams(String place){
        return products.stream().filter(x->x.getPlace().equalsIgnoreCase(place));
    }

    public List<Product> searchOutOfWarranty() {
        List<Product> outOfWarrantyProducts = new ArrayList<>();
        for(Product p: products){
            if(p.getWarranty()<Year.now().getValue()){
                outOfWarrantyProducts.add(p);
            }
        }
        return outOfWarrantyProducts;
    }

    public Stream<Product> searchOutOfWarrantyExpiryUsingStreams(){
        return products.stream().filter(x->x.getWarranty()< Year.now().getValue());
    }

}
