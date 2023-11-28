INSERT INTO auction_item (name, expire_date)
VALUES
    ("Vase", "2023-11-30"),
    ("Troli", "2023-12-02"),
    ("Metro", "2023-10-12");

INSERT INTO bid (amount, bidder_name, auction_item_id)
VALUES
    (50, "Zoli", 1),
    (600000, "Levi", 2),
    (2400000, "Máté", 3),
    (55, "Patrik", 1);