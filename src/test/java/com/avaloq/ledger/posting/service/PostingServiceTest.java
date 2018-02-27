package com.avaloq.ledger.posting.service;

import com.avaloq.ledger.posting.model.PostingMap;
import com.avaloq.ledger.posting.model.Voucher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PostingConfiguration.class)
public class PostingServiceTest {

  @Autowired
  private PostingService postingService;

  @Test
  public void accountPayable() {
    Voucher voucher = new Voucher();
    voucher.setSubLedgerCategory("ACCOUTPAYABLE");
    voucher.setAccountCategory("CREDITOR");
    voucher.setAmountCategory("BOOKING");
    voucher.setCurrencyIso("EUR");
    voucher.setAmount(156.45);
    PostingMap postingMap = new PostingMap();
    Long status = postingService.calculatePosting(voucher,postingMap);

    assertNotNull(status);
    assertEquals(voucher.getAmount(), postingMap.getPostingAmount());
  }

}
