First things first instalirat Weku

WEKA API
Napravit New -> Java Project npr. Programsko, desni klik na njega Built Path -> Configure Built Path, otvori se prozor�i� 
provjerite da ste u Java Build Path te u tabu LIBRARIES. Meni se jave Modulepath i Classpath, klik na Classpath, ako vam nema
toga onda samo hrabro naprijed. Klik na Add External JARs - najdete weka.jar (meni: C:\Program Files\Weka-3-8\weka.jar) i to je to.
U src folderu je Mining.java koji u�itava crime_rules.csv(baza koju je Maja lijepo sredila da radi!!!). Zna�i u�itajte weka.jar, 
skinite novu bazu i kod iz src foldera i provjerite radi li vam sve.
pozz :) :) :)

UPDATE 14.05.2019.
Main.java
Create_CSV.getCSV
-pove�emo se s bazom na phpmyadminu i spremimo ju u CSV koji u�itamo u mining 
-svaki put kad se program pokrene povla�i najnoviju bazu
-ja sam probala da weka odmah povla�i s phpmyadmina al jebe neki drive ne �eli se povezat :( 
-tako da ovo je malo okolo naokolo, ali - radi
Mining.getRules
-isti mine - FilteredAssociator samo u�itavamo novu bazu koju smo povukli s phpmyadmina tako da je up to date
