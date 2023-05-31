package org.teluskoMacbookContest.shortURL;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class UrlService {
    static int i=0;
    Random random = new Random();
    private final UrlDB db;
    @Autowired
    public UrlService(UrlDB db){
        this.db = db;
    }
    public UrlPair handleOUrl(String oUrl){
        UrlPair url;
        String sUrl;
        if(!ifContainsOUrl(oUrl)){
            sUrl = generateUrl(oUrl);
            url = addGeneratedUrl(oUrl, sUrl);
        }
        else{
             url = db.findByOriginalUrl(oUrl);
        }
        return url;
    }
    public List<UrlPair> getAll(){
        return db.findAll();
    }

    private @NotNull UrlPair addGeneratedUrl(String oUrl, String sUrl){
        UrlPair url = new UrlPair();
        if (Objects.requireNonNull(oUrl).isBlank()){
            throw new IllegalArgumentException("Original URL cannot be empty");
        }
        url.setOriginalUrl(oUrl);
        url.setShortUrl(sUrl);;
        return db.save(url);
    }
    private boolean ifContainsOUrl(String oUrl){
        // This should return true when oUrl is in database
        UrlPair urlPair = db.findByOriginalUrl(oUrl);
        return urlPair != null;
    }

    private boolean ifContainsSUrl(String sUrl){
        // This should return true when sUrl is in database
        UrlPair urlPair = db.findByShortUrl(sUrl);
        return urlPair != null;
    }

    private String generateUrl(@NotNull String oUrl){
        StringBuilder sb = new StringBuilder();
        int randomIndex;
        String sUrl;
        StringBuilder oUrlSb = new StringBuilder();
        for(int i=0;i<oUrl.length();i++){
            if(Character.isLetter(oUrl.charAt(i))){
                oUrlSb.append(oUrl.charAt(i));
            }
        }
        oUrl = oUrlSb.toString();
        do{
            for(int i=0;i<6;i++){
                randomIndex = random.nextInt(oUrl.length());
                sb.append(oUrl.charAt(randomIndex));
            }
            sUrl = "shortURL.co/"+sb.toString();
            System.out.println("Generated....:"+i+" "+ sUrl);
            i++;
        }while(ifContainsSUrl(sUrl));

        return sUrl;
    }
}
