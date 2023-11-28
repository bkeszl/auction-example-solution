package com.greenfoxacdemy.auction.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class AuctionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date expireDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auctionItem")
    private List<Bid> bids;

    public AuctionItem() {
        this.bids = new ArrayList<>();
    }

    public AuctionItem(String name, Date expireDate) {
        this();
        this.name = name;
        this.expireDate = expireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void addBid(Bid bid) {
        this.bids.add(bid);
        bid.setAuctionItem(this);
    }
    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
