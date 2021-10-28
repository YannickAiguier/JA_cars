DROP TABLE IF EXISTS car;

CREATE TABLE car (
  id INT AUTO_INCREMENT PRIMARY KEY,
  marque VARCHAR(250) NOT NULL,
  modele VARCHAR(250) NOT NULL,
  couleur VARCHAR(250) NOT NULL
);

INSERT INTO car (marque, modele, couleur) VALUES
  ('Peugeot', '206', 'rouge'),
  ('Renault', 'Clio', 'bleue'),
  ('Ferrari', 'Testarossa', 'jaune');