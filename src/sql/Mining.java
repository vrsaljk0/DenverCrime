package sql;

//ZANEMARIMO WARNINGE 'illegal reflective access' AKO VAM SE JAVLJAJU JAVA NES SERE BZVZ (VERZIJA 8 i 9)

import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.converters.ConverterUtils.DataSource;

public class Mining {
	
	public static String getRules() throws Exception {
		//uèitamo dataset koji smo dobili u Create_CSV !!!
		//String dataset = "C:\\Users\\Aspire\\Desktop\\FAKS\\Programsko inž-2019\\baza\\crime_sreden.csv"; //prilagoditi path, zakomentirajte svoj da ne mijenjamo stalno
		String dataset = "C:\\Romano\\2.god\\Objektno\\eclipse_vj\\MySql-vjezba\\crime_sreden.csv";
		System.out.println(dataset);
		DataSource source = new DataSource(dataset);
		Instances data = source.getDataSet();
				
		Apriori model = new Apriori();
		
		model.setLowerBoundMinSupport(0.001);
		SelectedTag t = new SelectedTag(3, Apriori.TAGS_SELECTION);
		model.setMetricType(t);
		model.setNumRules(500);
		model.setUpperBoundMinSupport(2.0);
		//build the associator on the filtered data -->za one koji žele znati više: http://weka.sourceforge.net/doc.stable/
		model.buildAssociations(data);
		//ispišemo rulove
		System.out.println(model);
		
		return model.toString();
	}
}
