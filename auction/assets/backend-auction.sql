SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auction_item
-- ----------------------------
DROP TABLE IF EXISTS `auction_item`;
CREATE TABLE `auction_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `expire_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of auction_item
-- ----------------------------
BEGIN;
INSERT INTO `auction_item` VALUES (1, 'Mickey Mouse', '2022-11-01 14:46:38');
INSERT INTO `auction_item` VALUES (2, 'First ever made laptop', '2050-11-28 14:46:53');
INSERT INTO `auction_item` VALUES (3, 'Book - The Standard Book of Spells Grade 1 – by Miranda Goshawk', '2022-11-28 14:52:14');
INSERT INTO `auction_item` VALUES (4, 'Book - Madcap Magic for Wacky Warlocks', '2022-11-28 14:52:56');
INSERT INTO `auction_item` VALUES (5, 'Book - The Invisible Book of Invisibility', '2030-11-28 14:53:56');
INSERT INTO `auction_item` VALUES (6, 'Leviathan Axe', '2050-11-09 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for bid
-- ----------------------------
DROP TABLE IF EXISTS `bid`;
CREATE TABLE `bid` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bidder_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `amount` int NOT NULL,
  `item_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `bid_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `auction_item` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of bid
-- ----------------------------
BEGIN;
INSERT INTO `bid` VALUES (1, 'Tom', 15000, 1);
INSERT INTO `bid` VALUES (2, 'Jerry', 15001, 1);
INSERT INTO `bid` VALUES (3, 'Steve Jobs', 99990, 2);
INSERT INTO `bid` VALUES (4, 'Bill Gates', 100900, 2);
INSERT INTO `bid` VALUES (5, 'Thor Odinson', 44444, 6);
INSERT INTO `bid` VALUES (6, 'Kratos', 66666, 6);
INSERT INTO `bid` VALUES (7, 'Santa Monica Studio', 123456789, 6);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
