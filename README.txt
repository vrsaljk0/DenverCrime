1. Skinuti zip file sa GIT-a.
2. Importati bazu denvercrime.sql u phpmyadmin.
3. U Eclipse-u napraviti paket s nazivom denvercrime te učitati sve fileove iz src foldera.
4. Desni klik na Java Project u kojem se nalazi paket, zatim klik na Build Path -> Configure Built Path, 
provjerite da ste u Java Build Path te u tabu Libraries, klik na Classpath (ukoliko se ne jave opcije
Modulepath i Classpath preskočiti ovaj korak), klik na Add External JARs -> naći put do weka.jar i mysql-connector-java-8.0.15.jar te ih učitati.
5. U klasi:
	Gui_patrola.java na liniji 151.
	Gui_admin.java na liniji 182.
prilagoditi putanju do slike koja se nalazi u skinutome zip-u.
6. U klasi Mining.java na linijama 14. i 31. prilagoditi putanju do crime.csv koji se nalazi u skinutome zip-u.
7. Pokrenuti kod i ulogirati se sa odgovarajućim podacima koji se nalaze u bazi u tablici user.



