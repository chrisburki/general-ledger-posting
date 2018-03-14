package com.avaloq.ledger.posting.service;

import com.avaloq.ledger.posting.config.PostingConfig;
import com.avaloq.ledger.posting.model.PostingMap;
import com.avaloq.ledger.posting.model.Voucher;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostingService {

    @Autowired
    private PostingConfig postingConfig;

    public Long calculatePosting(Voucher voucher, PostingMap postingMap) {
        KieSession kieSession = postingConfig.kieSession();
//        kieSession.setGlobal("postingMap", postingMap);
        kieSession.insert(voucher);
        kieSession.fireAllRules();
        kieSession.dispose();
//        System.out.println("!! drl !! " + postingConfig.getDrlFromExcel());
        postingMap.setPostingCurrencyIso(voucher.getPostingCurrencyIso());
        postingMap.setDebitLedgerAccount(voucher.getDebitLedgerAccount());
        postingMap.setCreditLedgerAccount(voucher.getCreditLedgerAccount());
        postingMap.setStatus(200L);
        return postingMap.getStatus();
    }
}
