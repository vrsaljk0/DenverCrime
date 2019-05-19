First things first instalirat Weku

WEKA API
Napravit New -> Java Project npr. Programsko, desni klik na njega Built Path -> Configure Built Path, otvori se prozorèiæ 
provjerite da ste u Java Build Path te u tabu LIBRARIES. Meni se jave Modulepath i Classpath, klik na Classpath, ako vam nema
toga onda samo hrabro naprijed. Klik na Add External JARs - najdete weka.jar (meni: C:\Program Files\Weka-3-8\weka.jar) i to je to.
U src folderu je Mining.java koji uèitava crime_rules.csv(baza koju je Maja lijepo sredila da radi!!!). Znaèi uèitajte weka.jar, 
skinite novu bazu i kod iz src foldera i provjerite radi li vam sve.
pozz :) :) :)

UPDATE 14.05.2019.
Main.java
Create_CSV.getCSV
-povežemo se s bazom na phpmyadminu i spremimo ju u CSV koji uèitamo u mining 
-svaki put kad se program pokrene povlaèi najnoviju bazu
-ja sam probala da weka odmah povlaèi s phpmyadmina al jebe neki drive ne želi se povezat :( 
-tako da ovo je malo okolo naokolo, ali - radi
Mining.getRules
-isti mine - FilteredAssociator samo uèitavamo novu bazu koju smo povukli s phpmyadmina tako da je up to date
