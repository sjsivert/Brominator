/* Øvelsesgrupper */
INSERT INTO ØvelsesGruppe (ØvelsesgruppeID, Navn) VALUES (1, 'Bein');
INSERT INTO ØvelsesGruppe (ØvelsesgruppeID, Navn) VALUES (2, 'Armer');
INSERT INTO ØvelsesGruppe (ØvelsesgruppeID, Navn) VALUES (3, 'Rygg');
INSERT INTO ØvelsesGruppe (ØvelsesgruppeID, Navn) VALUES (4, 'Kjerne');
INSERT INTO ØvelsesGruppe (ØvelsesgruppeID, Navn) VALUES (5, 'Bryst');

INSERT INTO Apparat (ApparatID, Navn, HvordanBruke) VALUES (1, 'Stang', 'Stang som du løfter'),
(2, 'Løse vekter', 'Løse vekter som du løfter'),
(3, 'Leg press', 'Sitter på aparatet, løfter med beina'),
(4, 'Leg extension', 'Sitter på aparatet og løfter med beina');

INSERT INTO Øvelse (ØvelseID, Navn, Beskrivelse, HarApparat, ApparatID) VALUES(1, 'Roing med stang', 'Hold stangen med begge hender, bøy deg fremover og løft stangen opp mot brystet', TRUE, 1);

INSERT INTO ØvelseIØvelsesgruppe (ØvelseID, ØvelsesgruppeID) VALUES (1, 3);

INSERT INTO Øvelse (ØvelseID, Navn, Beskrivelse, HarApparat, ApparatID) VALUES(2, 'Armhevinger', 'Legg deg på magen og løft deg opp med armene', FALSE, NULL);

INSERT INTO ØvelseIØvelsesgruppe (ØvelseID, ØvelsesgruppeID) VALUES (2, 5);

INSERT INTO Øvelse (ØvelseID, Navn, Beskrivelse, HarApparat, ApparatID) VALUES(3, 'Sit-ups', 'Legg deg på ryggen med beina i 90 grader, hold hendene dine bak hodet og løft overkroppen din til knærne dine', FALSE, NULL);

INSERT INTO ØvelseIØvelsesgruppe (ØvelseID, ØvelsesgruppeID) VALUES (3, 4);

INSERT INTO Øvelse (ØvelseID, Navn, Beskrivelse, HarApparat, ApparatID) VALUES(4, 'Beinpress', 'Sett deg inn i aparatet og løft med beina. Sørg for at beina ikke er helt rette', TRUE, 3);

INSERT INTO ØvelseIØvelsesgruppe (ØvelseID, ØvelsesgruppeID) VALUES (4, 1);

INSERT INTO Treningsøkt (TreningsøktID, Dato, Varighet, PersonligForm, Prestasjon, Notat) VALUES (1, '2018-10-25 11:30:45', '01:30:00', 7, 5, 'Dette var en ganske fin treningsøkt, men jeg ble ganske sliten. Gjorde roing, armhevninger og situps');


INSERT INTO ØvelseITreningsøkt (TreningsID, ØvelseID, Kilo, AntallSett, AntallReps) VALUES (1, 1, 35, 4, 4);
INSERT INTO ØvelseITreningsøkt (TreningsID, ØvelseID, Kilo, AntallSett, AntallReps) VALUES (1, 2, 0, 4, 15);
INSERT INTO ØvelseITreningsøkt (TreningsID, ØvelseID, Kilo, AntallSett, AntallReps) VALUES (1, 3, 0, 4, 15);

INSERT INTO Treningsøkt (TreningsøktID, Dato, Varighet, PersonligForm, Prestasjon, Notat) VALUES (2, '2018-10-30 17:30:00', '01:30:00', 8, 6, 'Samme økt som forrige gang. Gjorde roing, armhevninger og situps. Økte litt antall reps på situps og antall kilo på roing');

INSERT INTO ØvelseITreningsøkt (TreningsID, ØvelseID, Kilo, AntallSett, AntallReps) VALUES (2, 1, 50, 4, 4);
INSERT INTO ØvelseITreningsøkt (TreningsID, ØvelseID, Kilo, AntallSett, AntallReps) VALUES (2, 2, 0, 4, 15);
INSERT INTO ØvelseITreningsøkt (TreningsID, ØvelseID, Kilo, AntallSett, AntallReps) VALUES (2, 3, 0, 4, 25);
