USE KEA_Wishlist;

INSERT INTO Wishlist (Id,Title,Creator,Expiration)
VALUES("0daedfab-06e5-442f-a1f2-22b7624679ef","Elliots ønsker", "Thomas hansen","2023-08-14");

INSERT INTO Wish(Id,Url,ProductTitle,ProductPrice,WishlistId)
VALUES("11244d91-fd6c-4a57-a8ae-5475184fef9c",
		"www.br.dk","Brandbil",300,
		"0daedfab-06e5-442f-a1f2-22b7624679ef");
