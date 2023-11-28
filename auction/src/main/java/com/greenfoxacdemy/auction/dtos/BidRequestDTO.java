package com.greenfoxacdemy.auction.dtos;

public class BidRequestDTO {
    private String bidderName;
    private Long auctionItemId;
    private Integer amount;

    public BidRequestDTO() {
    }

    public BidRequestDTO(String bidderName, Long auctionItemId, Integer amount) {
        this.bidderName = bidderName;
        this.auctionItemId = auctionItemId;
        this.amount = amount;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public Long getAuctionItemId() {
        return auctionItemId;
    }

    public void setAuctionItemId(Long auctionItemId) {
        this.auctionItemId = auctionItemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
