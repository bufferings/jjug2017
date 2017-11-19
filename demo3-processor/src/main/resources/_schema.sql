CREATE TABLE IF NOT EXISTS ProductPage
(
  productId VARCHAR(36) PRIMARY KEY
  ,productName VARCHAR(30)
  ,commentCount INT
  ,latestComment VARCHAR(100)
);

