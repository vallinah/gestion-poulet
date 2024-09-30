INSERT INTO elevage (date_debut, dureeCycle) VALUES
('2024-01-10', 45),
('2024-02-20', 40),
('2024-03-15', 50);


INSERT INTO charge (nom, prix_unitaire, unité_oeuvre, id_type_charge, id_charge_analytique, id_analytique_coût, pourcentage_démarrage, pourcentage_transition, pourcentage_finition) VALUES
('Achat de poussin', 120000, 'NB', 1, 1, 1, 0.00, 0.00, 100.00),
('Achat démarrage', 123246, 'KG', 1, 1, 1, 0.00, 0.00, 100.00),
('Achat croissance', 40169, 'KG', 1, 1, 1, 0.00, 95.00, 5.00),
('Achat finition', 341954, 'KG', 1, 1, 1, 0.00, 0.00, 100.00),
('Eau sucré', 0, 'LITRES', 1, 1, 1, 100.00, 0.00, 0.00),
('Tetralcolvit', 0, 'LITRES', 1, 1, 1, 30.00, 70.00, 0.00),
('Anticox', 0, 'LITRES', 1, 1, 1, 15.00, 60.00, 0.00),
('Eau', 11000, 'LITRES', 1, 1, 1, 10.00, 30.00, 60.00),
('Electrique', 4987300, 'KW', 1, 2, 2, 15.00, 70.00, 15.00),
('Assurances', 5927200, 'Cons périodique', 2, 2, 2, 0.00, 0.00, 0.00),
('Photocopies', 450900, 'Cons périodique', 2, 2, 2, 100.00, 0.00, 0.00),
('Téléphone', 8236300, 'Cons périodique', 2, 2, 2, 60.00, 0.00, 0.00),
('Envoi colis', 789500, 'Cons périodique', 2, 2, 2, 100.00, 0.00, 0.00),
('Honoraires', 8538100, 'Cons périodique', 2, 2, 2, 100.00, 0.00, 0.00),
('Transport', 3200000, 'KG', 1, 1, 1, 100.00, 0.00, 0.00),
('Voyages', 16222500, 'Cons périodique', 2, 2, 2, 40.00, 60.00, 0.00),
('Mission', 31622000, 'Cons périodique', 2, 2, 2, 40.00, 40.00, 0.00),
('Banques', 31784800, 'Cons périodique', 2, 2, 2, 40.00, 30.00, 30.00),
('Autres charges', 505029800, 'Cons périodique', 2, 2, 2, 35.00, 30.00, 35.00),
('Impot et taxes', 17604300, 'Cons périodique', 2, 2, 2, 35.00, 30.00, 35.00),
('Salaires temporaires', 89267100, 'Heures de travail (HT)', 1, 1, 1, 0.00, 45.00, 55.00),
('CNAPS cotisation patronale', 36720460, 'Sal mens ou HT', 1, 1, 1, 0.00, 45.00, 55.00),
('Organisme sanitaire cotisation', 564600, 'Sal mens ou HT', 1, 1, 1, 0.00, 0.00, 100.00),
('Autres charges de personnel', 15694600, 'Sal mens ou HT', 1, 1, 1, 40.00, 30.00, 30.00),
('Amortissements', 28639600, 'Cons périodique', 2, 2, 2, 25.00, 0.00, 5.00),
('Charges financières', 23007600, 'Cons périodique', 2, 2, 2, 100.00, 0.00, 0.00);


INSERT INTO depense (id_charge, quantite) VALUES
(1, 120000),  -- Achat de poussin
(2, 123246),  -- Achat démarrage
(3, 40169),   -- Achat croissance
(4, 341954),  -- Achat finition
(5, 0),       -- Eau sucré
(6, 0),       -- Tetralcolvit
(7, 0),       -- Anticox
(8, 11000),   -- Eau
(9, 4987300), -- Electrique
(10, 5927200),-- Assurances
(11, 450900), -- Photocopies
(12, 8236300),-- Téléphone
(13, 789500), -- Envoi colis
(14, 8538100),-- Honoraires
(15, 3200000),-- Transport
(16, 16222500),-- Voyages
(17, 31622000),-- Mission
(18, 31784800),-- Banques
(19, 505029800),-- Autres charges
(20, 17604300); -- Impot et taxes

