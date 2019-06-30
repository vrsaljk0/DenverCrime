# DenverCrime

Denver Crime aplikacija omogućuje kontrolu i pregled zločina na području grada Denvera koristeći se principima association-rule mining-a. 

### Motivation

* Realizirati projekt zasnovan na općenitom modelu razvoja kroz faze inženjerstva zahtjeva, 
dizajna, implementacije, testiranja i integracije.   

* Simulirati stvarno radno okruženje u projektnom timu.

## Prerequisites

*  Java 10 Runtime Enviroment
*  lokalni server PhpMyAdmin 
*  mySQL connector.jar 
*  Weka.jar 


## Getting Started

* Importati bazu denvercrime.sql u phpmyadmin.
* U Eclipse-u napraviti paket s nazivom denvercrime te učitati sve fileove iz src foldera.
* Desni klik na Java Project u kojem se nalazi paket, zatim klik na Build Path -> Configure Built Path, 
provjerite da ste u Java Build Path te u tabu Libraries, klik na Classpath (ukoliko se ne jave opcije
Modulepath i Classpath preskočiti ovaj korak), klik na Add External JARs -> naći put do weka.jar i mysql-connector-java-8.0.15.jar te ih učitati.
* U klasi:
	Gui_patrola.java na liniji 151.
	Gui_admin.java na liniji 182.
prilagoditi putanju do slike koja se nalazi u skinutome zip-u.
* U klasi Mining.java na linijama 14. i 31. prilagoditi putanju do crime.csv koji se nalazi u skinutome zip-u.
* Pokrenuti kod i ulogirati se sa odgovarajućim podacima koji se nalaze u bazi u tablici user.


## About

Dvije razine pristupa:

	Administrator:
		pregledava kartu Denvera na kojoj se prikazuju kritična područja te prema tim informacijama i 
		rezultatima association rule mininga preusmjerava patrole. 
	Patrole:
		također imaju mogućnost pregleda karte Denvera. 
		Njihov zadatak je obavještavati admina o situaciji na terenu i unositi nove zločine.  


## Built With

* Java10

## Authors

* **Maja Vrsaljko** - *projektni menadžer* - (https://github.com/vrsaljk0)

* **Ivana Baćac** - *stručnjak za testiranje* - (https://github.com/Bachvac)

* **Azra Subašić** - *stručnjak za specifikaciju* - (https://github.com/hax91)

* **Romano Polić** - *stručnjak za dizajn* - (https://github.com/Romano125)

* **Luka Vukonić** - *stručnjak za integraciju* - (https://github.com/lvukonic)
