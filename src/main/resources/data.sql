DROP TABLE IF EXISTS superHeroe;

CREATE TABLE superHeroe (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO superHeroe (name) VALUES
  ('Superman'),
  ('Spiderman'),
  ('Manolito el fuerte'),
  ('Antman'),
  ('Capitán Trueno'),
  ('Superlópez');
  