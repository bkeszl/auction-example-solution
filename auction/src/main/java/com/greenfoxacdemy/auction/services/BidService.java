package com.greenfoxacdemy.auction.services;

import com.greenfoxacdemy.auction.models.AuctionItem;
import com.greenfoxacdemy.auction.models.Bid;
import com.greenfoxacdemy.auction.repositories.BidRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BidService {

    private final BidRepository bidRepository;

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Bid findHighestBidByAuction(AuctionItem auctionItem) {
        Optional<Bid> oBid = bidRepository.findHighestBidById(auctionItem.getId());
        return oBid.orElse(null);
    }
}
