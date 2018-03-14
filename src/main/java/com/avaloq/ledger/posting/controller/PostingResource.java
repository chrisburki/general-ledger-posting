package com.avaloq.ledger.posting.controller;

import com.avaloq.ledger.posting.model.PostingMap;
import com.avaloq.ledger.posting.model.Voucher;
import com.avaloq.ledger.posting.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ledger-posting")
public class PostingResource {

  @Autowired
  private PostingService postingService;

  @RequestMapping(method= RequestMethod.GET)
  public PostingMap posting(
      @RequestParam(value = "subledgercategory", defaultValue = "ACC") String subLedgerCategory,
      @RequestParam(value = "accontcategory", defaultValue =  "BANK") String accountCategory,
      @RequestParam(value = "instrumentcategory", defaultValue =  "MACC") String financialInstrumentCategory,
      @RequestParam(value = "currencyiso", defaultValue =  "EUR") String currencyIso,
      @RequestParam(value = "amountcategory", defaultValue =  "BOOKING") String amountCategory,
      @RequestParam(value = "amount", defaultValue = "10") Double amount,
      @RequestParam(value = "amountbase", defaultValue = "0") Double amountBaseCurrency
  ) {
    Voucher voucher = new Voucher();
    voucher.setSubLedgerCategory(subLedgerCategory);
    voucher.setAccountCategory(accountCategory);
    voucher.setFinancialInstrumentCategory(financialInstrumentCategory);
    voucher.setCurrencyIso(currencyIso);
    voucher.setAmountCategory(amountCategory);
    voucher.setAmount(amount);
    voucher.setAmountBaseCurrency(amountBaseCurrency);

    PostingMap postingMap = new PostingMap();
    Long status = postingService.calculatePosting(voucher,postingMap);
    return postingMap;
  }
}
