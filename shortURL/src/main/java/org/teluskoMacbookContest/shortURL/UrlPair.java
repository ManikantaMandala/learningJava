package org.teluskoMacbookContest.shortURL;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "url_pair")
public class UrlPair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "original_url", nullable = false)
    private String originalUrl;
    @Column(name = "short_url", nullable = false)
    private String shortUrl;

    public UrlPair(){}
    public UrlPair(String originalUrl, String shortUrl){
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        System.out.println(this.originalUrl+ " "+ this.shortUrl +" "+ originalUrl + " "+ shortUrl);
    }
}
