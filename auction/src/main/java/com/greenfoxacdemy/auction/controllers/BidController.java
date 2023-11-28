package com.greenfoxacdemy.auction.controllers;

import com.greenfoxacdemy.auction.dtos.BidErrorDTO;
import com.greenfoxacdemy.auction.dtos.BidRequestDTO;
import com.greenfoxacdemy.auction.dtos.BidResponseDTO;
import com.greenfoxacdemy.auction.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BidController {


    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/bid")
    public String addBid(
            RedirectAttributes redirectAttributes,
            String bidderName,
            Long auctionItemId,
            Integer amount) {

        String message =  bidService.createBid(bidderName, auctionItemId, amount);
        redirectAttributes.addFlashAttribute("message", message);
        if (!message.equals("Your bid is accepted!")) {
            redirectAttributes.addFlashAttribute("bidderName", bidderName);
            redirectAttributes.addFlashAttribute("previousAmount", amount);
        }
        return "redirect:/auctions/" +auctionItemId;
    }

    @PostMapping("/api/bid")
    @ResponseBody
    public ResponseEntity<?> addBidApi(@RequestBody BidRequestDTO dto) {
        String status = bidService.createBid(dto.getBidderName(), dto.getAuctionItemId(), dto.getAmount());
        if (status.equals("Your bid is accepted!")) {
            BidResponseDTO response = new BidResponseDTO(0l, dto.getBidderName(), dto.getAmount(), dto.getAuctionItemId());
            return ResponseEntity.status(201).body(response);
        }
        BidErrorDTO response = new BidErrorDTO(status);
        return ResponseEntity.status(400).body(response);
    }
}
