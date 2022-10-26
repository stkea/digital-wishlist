DROP DATABASE IF EXISTS KEA_Wishlist;

CREATE DATABASE KEA_Wishlist;

USE KEA_Wishlist;

CREATE TABLE Wishlist(
                         Id char(36) NOT NULL,
                         Title text,
                         Creator text,
                         Expiration date,
                         PRIMARY KEY(Id)
);

CREATE INDEX idx_wlid
    ON Wishlist(Id);

CREATE TABLE Wish(
                     Id char(36) NOT NULL,
                     Url text,
                     WishlistId char(36),
                     Reserved int(2) DEFAULT 0,
                     ReservedTo text,
                     ProductTitle text,
                     ProductPrice int,
                     PRIMARY KEY(Id),
                     CONSTRAINT FK_WL FOREIGN KEY (WishlistID) REFERENCES Wishlist(Id)
);

CREATE INDEX idx_wid
    ON Wish(Id);