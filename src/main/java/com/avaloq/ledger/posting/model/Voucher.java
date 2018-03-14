package com.avaloq.ledger.posting.model;

public class Voucher {

    //  Position
    private String subLedgerCategory;
    private String accountCategory;
    private String financialInstrumentCategory;
    private String currencyIso;
    //  Amount
    private String amountCategory;
    private Double amount;
    private Double amountBaseCurrency;
    // Output
    private Double postingAmount;
    private String postingCurrencyIso;
    private String debitLedgerAccount;
    private String creditLedgerAccount;


    public Voucher() {
        amount = 0D;
        amountBaseCurrency = 0D;
    }

    public String getSubLedgerCategory() {
        return subLedgerCategory;
    }

    public void setSubLedgerCategory(String subLedgerCategory) {
        this.subLedgerCategory = subLedgerCategory;
    }

    public String getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(String accountCategory) {
        this.accountCategory = accountCategory;
    }

    public String getFinancialInstrumentCategory() {
        return financialInstrumentCategory;
    }

    public void setFinancialInstrumentCategory(String financialInstrumentCategory) {
        this.financialInstrumentCategory = financialInstrumentCategory;
    }

    public String getCurrencyIso() {
        return currencyIso;
    }

    public void setCurrencyIso(String currencyIso) {
        this.currencyIso = currencyIso;
    }

    public String getAmountCategory() {
        return amountCategory;
    }

    public void setAmountCategory(String amountCategory) {
        this.amountCategory = amountCategory;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmountBaseCurrency() {
        return amountBaseCurrency;
    }

    public void setAmountBaseCurrency(Double amountBaseCurrency) {
        this.amountBaseCurrency = amountBaseCurrency;
    }

    // Output


    public Double getPostingAmount() {
        return postingAmount;
    }

    public void setPostingAmount(Double postingAmount) {
        this.postingAmount = postingAmount;
    }

    public String getPostingCurrencyIso() {
        return postingCurrencyIso;
    }

    public void setPostingCurrencyIso(String postingCurrencyIso) {
        this.postingCurrencyIso = postingCurrencyIso;
    }

    public String getDebitLedgerAccount() {
        return debitLedgerAccount;
    }

    public void setDebitLedgerAccount(String debitLedgerAccount) {
        this.debitLedgerAccount = debitLedgerAccount;
    }

    public String getCreditLedgerAccount() {
        return creditLedgerAccount;
    }

    public void setCreditLedgerAccount(String creditLedgerAccount) {
        this.creditLedgerAccount = creditLedgerAccount;
    }
}
