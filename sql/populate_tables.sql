USE KEA_Wishlist;

INSERT INTO Wishlist (Id,Name,Creator,Expiration)
VALUES("0daedfab-06e5-442f-a1f2-22b7624679ef","Elliots ønsker", "Thomas hansen","2023-08-14");

INSERT INTO Wish(Id,Url,WishlistId)
VALUES("11244d91-fd6c-4a57-a8ae-5475184fef9c",
		"www.br.dk","0daedfab-06e5-442f-a1f2-22b7624679ef");

INSERT INTO Product(Id, Name,Price,WishId)
VALUES("925c2c70-641c-4b24-90d2-b2576059cec3","Brandbil",300,"11244d91-fd6c-4a57-a8ae-5475184fef9c");