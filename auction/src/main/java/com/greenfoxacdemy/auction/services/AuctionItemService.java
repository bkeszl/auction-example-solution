package com.greenfoxacdemy.auction.services;

import com.greenfoxacdemy.auction.models.AuctionItem;
import com.greenfoxacdemy.auction.repositories.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionItemService {
    private final AuctionItemRepository auctionItemRepository;
    @Autowired
    public AuctionItemService(AuctionItemRepository auctionItemRepository) {
        this.auctionItemRepository = auctionItemRepository;
    }

    public List<AuctionItem> findAll() {
        return auctionItemRepository.findAll();
    }
}

