CREATE TABLE IF NOT EXISTS lease(
  leaseID INT NOT NULL AUTO_INCREMENT,
  propertyID INT NOT NULL,
  startDate DATE NOT NULL,
  endDate DATE,
  rentDueDate DATE NOT NULL,
  rentAmount DECIMAL(13,2) NOT NULL,
  PRIMARY KEY(leaseID)
);

CREATE TABLE IF NOT EXISTS renter(
  renterID INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(256) NOT NULL,
  lastName VARCHAR(256) NOT NULL,
  email VARCHAR(256),
  phoneNumber VARCHAR(13),
  PRIMARY KEY(renterID)
);

CREATE TABLE IF NOT EXISTS renterLease(
  renterID INT NOT NULL,
  leaseID INT NOT NULL
);

CREATE TABLE IF NOT EXISTS propertyLease(
  propertyID INT NOT NULL,
  leaseID INT NOT NULL
);

CREATE TABLE IF NOT EXISTS property(
  propertyID INT NOT NULL AUTO_INCREMENT,
  propertyName VARCHAR(256) NOT NULL,
  streetAddress VARCHAR(256) NOT NULL,
  city VARCHAR(256),
  zip VARCHAR(10),
  unitNumber INT NOT NULL,
  PRIMARY KEY(propertyID)
);
