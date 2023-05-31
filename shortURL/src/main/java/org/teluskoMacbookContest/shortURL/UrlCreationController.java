package org.teluskoMacbookContest.shortURL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UrlCreationController {
    private final UrlService service;
    @Autowired
    public UrlCreationController(UrlService service){
        this.service = service;
    }
    @GetMapping("/")
    public String index(){
        return "Index Page";
    }
    @GetMapping("/urls")
    public List<UrlPair> getOriginalUrls(){
        return service.getAll();
    }
    @PostMapping("/shorter")
    public ResponseEntity<UrlPair> handleUrl(@RequestParam("url") String oUrl){
        System.out.println(oUrl);
        UrlPair url = service.handleOUrl(oUrl);
        return ResponseEntity.status(HttpStatus.CREATED).body(url);
    }
}
