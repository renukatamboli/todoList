ALTER TABLE tasks
ADD labelid INTEGER,
ADD CONSTRAINT FOREIGN KEY(labelid) REFERENCES label(id);