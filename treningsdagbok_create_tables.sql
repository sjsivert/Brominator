DROP TABLES IF EXISTS Treningsøkt, Øvelse, Apparat, ØvelsesGruppe, ØvelseITreningsøkt, ØvelseIØvelsesgruppe;
CREATE TABLE Treningsøkt (
    TreningsøktID INTEGER NOT NULL AUTO_INCREMENT,
    Dato DATETIME NOT NULL,
    Varighet TIME NOT NULL,
    PersonligForm INTEGER NOT NULL,
    Prestasjon INTEGER NOT NULL,
    Notat TEXT NOT NULL,
    CONSTRAINT Treningsøkt_PK PRIMARY KEY (TreningsøktID)
);
CREATE TABLE Apparat (
    ApparatID INTEGER NOT NULL AUTO_INCREMENT,
    Navn VARCHAR(30) NOT NULL,
    HvordanBruke TEXT NOT NULL,
    CONSTRAINT Apparat_PK PRIMARY KEY (ApparatID)
);
CREATE TABLE Øvelse (
    ØvelseID INTEGER NOT NULL AUTO_INCREMENT,
    Navn VARCHAR(30) NOT NULL,
    Beskrivelse TEXT NOT NULL,
    HarApparat BOOLEAN NOT NULL,
    ApparatID INTEGER NOT NULL,
    CONSTRAINT Øvelse_PK PRIMARY KEY (ØvelseID),
    CONSTRAINT Øvelse_FK FOREIGN KEY (ApparatID)
        REFERENCES Apparat (ApparatID)
        ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE ØvelsesGruppe (
    ØvelsesgruppeID INTEGER NOT NULL AUTO_INCREMENT,
    Navn VARCHAR(30) NOT NULL,
    CONSTRAINT ØvelsesGruppe_PK PRIMARY KEY (ØvelsesgruppeID)
);
CREATE TABLE ØvelseITReningsøkt (
    TreningsID INTEGER NOT NULL AUTO_INCREMENT,
    ØvelseID INTEGER NOT NULL,
	Kilo FLOAT(24) NOT NULL,
    AntallSett INTEGER NOT NULL,
    AntallReps INTEGER NOT NULL,
    CONSTRAINT ØvelseITReningsøkt_PK PRIMARY KEY (TreningsID , ØvelseID),
    CONSTRAINT ØvelseITReningsøkt_FK1 FOREIGN KEY (TreningsID)
        REFERENCES Treningsøkt (TreningsøktID)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT ØvelseITReningsøkt_FK2 FOREIGN KEY (ØvelseID)
        REFERENCES Øvelse (ØvelseID)
        ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE ØvelseIØvelsesgruppe (
    ØvelseID INTEGER NOT NULL AUTO_INCREMENT,
    ØvelsesgruppeID INTEGER NOT NULL,
    CONSTRAINT ØvelseIØvelsesgruppe_PK PRIMARY KEY (ØvelseID , ØvelsesgruppeID),
    CONSTRAINT ØvelseIØvelsesgruppe_FK1 FOREIGN KEY (ØvelseID)
        REFERENCES Øvelse (ØvelseID)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT ØvelseIØvelsesgruppe_FK2 FOREIGN KEY (ØvelsesgruppeID)
        REFERENCES ØvelsesGruppe (ØvelsesgruppeID)
        ON UPDATE CASCADE ON DELETE CASCADE
);