# Brominator
Gruppeprosjekt i TDT4145

Før du kjører programmet må du sette 2 environment-variabler med brukernavn og passord til databasen. På mac settes disse ved:
export DB_TRENINGSDAGBOK_USER=<din_bruker>
export DB_TRENINGSDAGBOK_PASS=<ditt_passord>

## Lyst å kompilere/kjøre prosjektet fra kommandolinja?
* Sørg for å ha JDK installert
* Prosjektet krever også en ekstern .jar fil for oppkobling mot databasen; platform independent funker -> [Nedlasting](https://dev.mysql.com/downloads/connector/j/5.1.html)
* Naviger til mappa Brominator og kompiler ved å benytte `javac innlevering2/*.java` (Fungerer ved nåværende mappestruktur)
* .jar fila må inkluderes i classpath-en under runtime. Her spørs det hvor mye du vil skrive...
* `export CLASSPATH=/path_to_jar/mysql-connector-java-5.1.47-bin.jar:.` (Gyldig for denne økta, kan settes i `~/.bash_profile` eller lignende dersom du vil lagre variabelen)
* Deretter kan du kjøre prosjektet fra mappa med kommandoen `java innlevering2.Main`
* Er du storfan av å skrive mye og vil ha minst mulig lagring av økt så fungerer også `java -cp /path_to_jar/mysql-connector-java-5.1.47-bin.jar:. innlevering2.Main`
* Vær obs på at alt som har med databasen å gjøre må være tatt hånd om lokalt for at ting skal fungere. Blant annet autentisering. Ta en titt i `DBConnect.java`