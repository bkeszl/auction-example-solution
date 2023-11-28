package com.greenfoxacdemy.auction.controllers;

import com.greenfoxacdemy.auction.models.AuctionItem;
import com.greenfoxacdemy.auction.services.AuctionItemService;
import com.greenfoxacdemy.auction.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String getHome(Model model){
        List<AuctionItem> auctionItems = auctionItemService.findAll();
        model.addAttribute("auctions", auctionItems);
        return "home";
    }

}
