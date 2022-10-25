CREATE TABLE Wishlist(
	Id char(36) NULL DEFAULT "",
	Name text,
	Creator text,
	Expiration date,
	PRIMARY KEY(Id)
);

CREATE INDEX idx_wlid 
ON Wishlist(Id);

CREATE TABLE Wish(
	Id char(36) NULL DEFAULT "",
	Url text,
	WishlistId char(36),
	Reserved int(2) DEFAULT 0,
	ReservedTo text DEFAULT "",
	PRIMARY KEY(Id),
	CONSTRAINT FK_WL FOREIGN KEY (WishlistID) REFERENCES Wishlist(Id)
);

CREATE INDEX idx_wid
ON Wish(Id);

CREATE TABLE Product(
	Id char(36) NULL DEFAULT "",
	Name text,
	Price int,
	WishId char(36),
	PRIMARY KEY(Id),
	CONSTRAINT FK_PW FOREIGN KEY (WishId) REFERENCES Wish(Id)
);

CREATE INDEX idx_pid
ON Product(Id);
