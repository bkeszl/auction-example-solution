package com.greenfoxacdemy.auction.dtos;

public class BidErrorDTO {

    private String error;

    public BidErrorDTO() {
    }

    public BidErrorDTO(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
