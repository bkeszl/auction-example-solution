package com.greenfoxacdemy.auction.repositories;

import com.greenfoxacdemy.auction.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

    @Query(value = "SELECT * FROM bid WHERE auction_item_id = :id ORDER BY amount DESC LIMIT 1;", nativeQuery = true)
    Optional<Bid> findHighestBidById(Long id);
}
