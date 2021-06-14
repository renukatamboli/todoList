CREATE TABLE mapping (
  id int(11) NOT NULL,
  labelid int(11) NOT NULL,
  PRIMARY KEY (id,labelid),
  FOREIGN KEY(labelid) REFERENCES label(id),
  FOREIGN KEY(id) REFERENCES tasks(id)
);