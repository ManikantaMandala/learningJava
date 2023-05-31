package org.teluskoMacbookContest.shortURL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UrlDB extends JpaRepository<UrlPair, Integer> {
    UrlPair findByOriginalUrl(String oUrl);
    UrlPair findByShortUrl(String sUrl);

}
