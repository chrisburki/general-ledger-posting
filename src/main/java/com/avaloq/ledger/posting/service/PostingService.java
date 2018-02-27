package com.avaloq.ledger.posting.service;

import com.avaloq.ledger.posting.model.PostingMap;
import com.avaloq.ledger.posting.model.Voucher;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostingService {

    @Autowired
    private KieContainer kContainer;

    public Long calculatePosting(Voucher voucher, PostingMap postingMap) {
        KieSession kieSession = kContainer.newKieSession();
        kieSession.setGlobal("postingMap", postingMap);
        kieSession.insert(voucher);
        kieSession.fireAllRules();
        kieSession.dispose();
//        System.out.println("!! RIDE FARE !! " + rideFare.getTotalFare());
        return postingMap.getStatus();
    }
}
