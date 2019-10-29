CREATE TABLE Folder (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  parent_id int  NOT NULL,
  child_id int NOT NULL,
  depth int DEFAULT NULL
);

insert into folder
values(1,0,2,0);

insert into folder
values(2,1,0,0);
