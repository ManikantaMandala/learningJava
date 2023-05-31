package org.teluskoMacbookContest.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class ProductController {

    private final ProductService service;
    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProducts(@RequestBody Product p){
        Product product = service.addProduct(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/search/isName+{name}")
    public List<Product> getProductsByName(@PathVariable String name){
        return service.getProduct(name);
    }

    @GetMapping("/search/isText+{text}")
    public List<Product> getProductsByText(@PathVariable String text){
        return service.getProductWithText(text);
    }

    @GetMapping("/search/isPlace+{place}")
    public List<Product> getProductsByPlace(@PathVariable String place){
        return service.searchByPlace(place);
    }

    @GetMapping("/search/isOutWarranty")
    public List<Product> getProductsByWarrantyOut(){
        return service.searchOutOfWarranty();
    }

    @DeleteMapping("/delete/isId+{Id}")
    public void deleteProductById(@PathVariable int Id){
        service.deleteProductById(Id);
    }


}
