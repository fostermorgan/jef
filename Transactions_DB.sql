CREATE TABLE IF NOT EXISTS transactions(
  transactionID INT AUTO_INCREMENT,
  transactions_to_catgories_ID INT,
  payeeID INT,
  userID INT,
  typeID INT,
  transactionDate DATE,
  checkNumber INT,
  memo VARCHAR(256),
  transactionTotal DECIMAL(13, 2)
);

CREATE TABLE IF NOT EXISTS transactionTypes(
  typeID INT AUTO_INCREMENT,
  typeName VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS users(
  userID INT AUTO_INCREMENT,
  email VARCHAR(256),
  password VARCHAR(256),
  role VARCHAR(100)
);
