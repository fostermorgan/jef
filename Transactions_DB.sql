CREATE TABLE IF NOT EXISTS transactions(
  transactionID INT AUTO_INCREMENT,
  transactions_to_categories_ID INT,
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

CREATE TABLE IF NOT EXISTS payees(
  payeeID INT AUTO_INCREMENT,
  name VARCHAR(256),
  address VARCHAR(256),
  city VARCHAR(256),
  zip VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS transactions_to_categories(
  transactions_to_categories_ID INT AUTO_INCREMENT,
  transactionsID INT,
  categoryID INT,
  classID INT,
  discription VARCHAR(256),
  amount DECIMAL(13, 2),
);

CREATE TABLE IF NOT EXISTS categories(
  categoryID INT AUTO_INCREMENT,
  categoryName VARCHAR(100)
);


CREATE TABLE IF NOT EXISTS classes(
  classID INT AUTO_INCREMENT,
  name varchar(256)
);
