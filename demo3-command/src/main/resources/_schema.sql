CREATE TABLE IF NOT EXISTS Product
(
  productId VARCHAR(36) PRIMARY KEY
  ,productName VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS CustomerComment
(
  customerCommentId VARCHAR(36) PRIMARY KEY
  ,productId VARCHAR(36)
  ,customerComment VARCHAR(100)
);

