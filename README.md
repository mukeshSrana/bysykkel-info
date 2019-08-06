##### Hva gjør komponenten?
Komponenten er en proxy mot sanntid API (viser plasseringer og tilstand for sine sykkelstativer).

##### Hvilke APIer tilbyr komponenten?
Komponenten tilbyr tjeneste for å hente informasjon om alle stasjoner, med adresser og sy sammen informasjon 
om tilgjengelighet på ledig sykler og tilgjengelige låser.  

##### Hvordan kjører jeg komponenten?
For å kjøre lokalt enkelt skal prosjekt bysykkelinfo(kode) åpnes i IntelliJ IDEA. Klasse Apllication.java skal kjøres i editoren.  For å teste applikasjon kan det benyttes postman.
Det skal kjøres en postman GET-kall  slik localhost:8080/sanntid/stasjonsinformasjon med header Accept= application/json. Respons viser en json over stasjonsstatus Informasjon.

##### Implementasjonsdetaljer
Java 8 og SpringBoot rammeverk er benyttet for å implementere funksjonaliteten. Maven er brukt for å bygge selve prosjekt.

