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
                     ProductPrice double,
                     PRIMARY KEY(Id),
                     CONSTRAINT FK_WL FOREIGN KEY (WishlistID) REFERENCES Wishlist(Id)
);

CREATE INDEX idx_wid
    ON Wish(Id);

INSERT INTO Wishlist (Id,Title,Creator,Expiration)
VALUES("0daedfab-06e5-442f-a1f2-22b7624679ef","Elliots ønsker", "Thomas hansen","2023-08-14");

INSERT INTO Wish(Id,Url,ProductTitle,ProductPrice,ReservedTo,WishlistId)
VALUES("7639c79c-3e4d-40f8-ab0c-fd65b624cab7",
		"Letkoeb","Schleick Giraf",45,"",
		"0daedfab-06e5-442f-a1f2-22b7624679ef");

INSERT INTO Wish(Id,Url,ProductTitle,ProductPrice,ReservedTo ,WishlistId)
VALUES("11244d91-fd6c-4a57-a8ae-5475184fef9c",
		"www.br.dk","Brandbil",300,"",
		"0daedfab-06e5-442f-a1f2-22b7624679ef");
	
INSERT INTO Wishlist (Id,Title,Creator,Expiration)
VALUES("77f3614a-f144-4200-9d66-156ab2af38de","Martins ønsker", 
		"Martin hansen","2023-06-03");

INSERT INTO Wish(Id,Url,ProductTitle,ProductPrice,ReservedTo ,WishlistId)
VALUES("0c812a92-9814-422b-91b5-d8b1f8e58b63",
		"www.br.dk","Politibil",500,"",
		"77f3614a-f144-4200-9d66-156ab2af38de");

INSERT INTO Wishlist (Id,Title,Creator,Expiration)
VALUES("c1870612-2194-4bfc-a30a-609db4948c8b","Kaspers ønsker", "Kasper hansen","2023-10-22");

INSERT INTO Wish(Id,Url,ProductTitle,ProductPrice,ReservedTo ,WishlistId)
VALUES("04f3b766-2d3d-4188-b073-10756c013884",
		"www.fckshop.dk","FCK trøje",900,"",
		"c1870612-2194-4bfc-a30a-609db4948c8b");
