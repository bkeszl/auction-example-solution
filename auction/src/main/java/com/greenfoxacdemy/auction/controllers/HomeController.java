package com.greenfoxacdemy.auction.controllers;

import com.greenfoxacdemy.auction.models.AuctionItem;
import com.greenfoxacdemy.auction.models.Bid;
import com.greenfoxacdemy.auction.services.AuctionItemService;
import com.greenfoxacdemy.auction.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    private AuctionItemService auctionItemService;
    private BidService bidService;

    @Autowired
    public HomeController(AuctionItemService auctionItemService, BidService bidService) {
        this.auctionItemService = auctionItemService;
        this.bidService = bidService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        List<AuctionItem> auctionItems = auctionItemService.findAll();
        model.addAttribute("auctions", auctionItems);
        return "home";
    }

    @GetMapping("/auctions/{id}")
    public String getAuctionDetails(Model model, @PathVariable Long id) {
        AuctionItem auctionItem = auctionItemService.findById(id);

        if (auctionItem == null) {
            model.addAttribute("message", "No such auction!");
            return "auction-error";
        }

        Bid highestBid = bidService.findHighestBidByAuction(auctionItem);
        model.addAttribute("auction", auctionItem);
        model.addAttribute("highestBid", highestBid);
        return "auction-detail";
    }
}
