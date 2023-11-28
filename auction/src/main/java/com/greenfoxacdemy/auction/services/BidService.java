package com.greenfoxacdemy.auction.services;

import com.greenfoxacdemy.auction.models.AuctionItem;
import com.greenfoxacdemy.auction.models.Bid;
import com.greenfoxacdemy.auction.repositories.BidRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BidService {

    private final BidRepository bidRepository;
    private final AuctionItemService auctionItemService;


    public BidService(BidRepository bidRepository, AuctionItemService auctionItemService) {
        this.bidRepository = bidRepository;
        this.auctionItemService = auctionItemService;
    }

    public Bid findHighestBidByAuction(AuctionItem auctionItem) {
        Optional<Bid> oBid = bidRepository.findHighestBidById(auctionItem.getId());
        return oBid.orElse(null);
    }

    public String createBid(String bidderName, Long auctionItemId, Integer amount) {
        String validateResult = validateDetails(bidderName, auctionItemId,amount);

        if (validateResult != null) {
            return validateResult;
        }

        AuctionItem auctionItem = auctionItemService.findById(auctionItemId);
        if (auctionItem == null) {
            return "No such auction";
        }

        Bid highest = findHighestBidByAuction(auctionItem);
        if (amount < highest.getAmount()) {
            return "Your bid is below the highest bid!";
        }

        if (new Date().getTime() > auctionItem.getExpireDate().getTime()) {
            return "The auction is over!";
        }

        Bid bid = new Bid(bidderName, amount, auctionItem);
        auctionItem.addBid(bid);
        bidRepository.save(bid);
        return "Your bid is accepted!";
    }

    private String validateDetails(String bidderName, Long auctionItemId, Integer amount) {
        boolean bidderNameValid = bidderName != null && !bidderName.isEmpty();
        boolean auctionItemIdValid = auctionItemId != null && auctionItemId > 0;
        boolean amountValid = amount != null && amount > 0;

        if(!bidderNameValid) {
            return "Bidder should not be empty or null!";
        }

        if(!auctionItemIdValid) {
            return "Auction Item id should not be empty or null!";
        }

        if(!amountValid) {
            return "Amount should be positive and not null";
        }

        return null;
    }
}
