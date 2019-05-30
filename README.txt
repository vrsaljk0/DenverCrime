First things first instalirat Weku

WEKA API
Napravit New -> Java Project npr. Programsko, desni klik na njega Built Path -> Configure Built Path, otvori se prozorčić 
provjerite da ste u Java Build Path te u tabu LIBRARIES. Meni se jave Modulepath i Classpath, klik na Classpath, ako vam nema
toga onda samo hrabro naprijed. Klik na Add External JARs - najdete weka.jar (meni: C:\Program Files\Weka-3-8\weka.jar) i to je to.
U src folderu je Mining.java koji učitava crime_rules.csv(baza koju je Maja lijepo sredila da radi!!!). Znači učitajte weka.jar, 
skinite novu bazu i kod iz src foldera i provjerite radi li vam sve.
pozz :) :) :)

UPDATE 14.05.2019.
Main.java
Create_CSV.getCSV
-povežemo se s bazom na phpmyadminu i spremimo ju u CSV koji učitamo u mining 
-svaki put kad se program pokrene povlači najnoviju bazu
-ja sam probala da weka odmah povlači s phpmyadmina al jebe neki drive ne želi se povezat :( 
-tako da ovo je malo okolo naokolo, ali - radi
Mining.getRules
-isti mine - FilteredAssociator samo učitavamo novu bazu koju smo povukli s phpmyadmina tako da je up to date

23.5.2019
crime_sreden.csv je file koji ćemo koristiti za mining. 
S obzirom da ne možemo uploadti 400k linija u phpmyadmin (tj. ja nez kako) morat ćemo raditi direkt mining iz file-a, a bazu koristit za admina/patrolu i dodavanje zlocina pa ko fol izlevatiti da se to mijenja (ne možemo mi toliko zločina dodati na prezentaciji da bi odma vidjeli promjenu u rulovim)

30.5.2019
dodala okvire i oznake patrola. 
Ako zelimo da se i okvir ofarba u crveno je tlaka jer se districts dodiruju u nekim granicama. Pripremila sam kod i za to tako da u tom slucaju, najprije sve okvire u CRNO, zatim sve okvire od opakih districta u CRVENO.
Jednostavniji i pouzdaniji nacin je da farbamo background oznake districta, primjer je u kodu.
Za sad napravljena samo patrola, za admina samo treba prekopirat kod, to cu ovih dana, valjda ce pasat sve




