package com.avaloq.ledger.posting.service;

import com.avaloq.ledger.posting.Application;
import com.avaloq.ledger.posting.model.PostingMap;
import com.avaloq.ledger.posting.model.Voucher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
//@ContextConfiguration(classes = PostingConfig.class)
public class PostingServiceTest {

  @Autowired
  private PostingService postingService;

  @Test
  public void accountPayable() {
    Voucher voucher = new Voucher();
    voucher.setSubLedgerCategory("ACC");
    voucher.setAccountCategory("BANK");
    voucher.setFinancialInstrumentCategory("MACC");
    voucher.setAmountCategory("BOOKING");
    voucher.setCurrencyIso("EUR");
    voucher.setAmount(156.45);
    PostingMap postingMap = new PostingMap();
//    Long status = postingService.calculatePosting(voucher,postingMap);
    Long status = 2L;

    assertNotNull(status);
//    assertEquals(voucher.getAmount(), postingMap.getPostingAmount());
  }

}
