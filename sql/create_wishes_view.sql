USE KEA_Wishlist;

CREATE VIEW wishes
AS
SELECT 
	Name, 
	Price,
	Reserved,
	Url
FROM 
	Wish
INNER JOIN
	Product ON Wish.Id = Product.WishId;