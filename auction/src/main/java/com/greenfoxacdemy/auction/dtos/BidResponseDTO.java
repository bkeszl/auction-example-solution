package com.greenfoxacdemy.auction.dtos;

public class BidResponseDTO {
    private Long bidId;
    private String bidderName;
    private Integer amount;
    private Long auctionItemId;

    public BidResponseDTO() {
    }

    public BidResponseDTO(Long bidId, String bidderName, Integer amount, Long auctionItemId) {
        this.bidId = bidId;
        this.bidderName = bidderName;
        this.amount = amount;
        this.auctionItemId = auctionItemId;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getAuctionItemId() {
        return auctionItemId;
    }

    public void setAuctionItemId(Long auctionItemId) {
        this.auctionItemId = auctionItemId;
    }
}
