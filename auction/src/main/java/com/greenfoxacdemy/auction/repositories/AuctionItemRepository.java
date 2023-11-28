package com.greenfoxacdemy.auction.repositories;

import com.greenfoxacdemy.auction.models.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
}
