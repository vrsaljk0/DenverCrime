package denvercrime;

//ZANEMARIMO WARNINGE 'illegal reflective access' AKO VAM SE JAVLJAJU JAVA NES SERE BZVZ (VERZIJA 8 i 9)

import weka.associations.FilteredAssociator;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Mining {
	
	public static void getRules() throws Exception {
		//u�itamo dataset koji smo dobili u Create_CSV !!!
		String dataset = "C:\\Users\\Aspire\\Desktop\\FAKS\\Programsko in�-2019\\baza\\crime_rules.csv"; //prilagoditi path
		System.out.println(dataset);
		DataSource source = new DataSource(dataset);
		Instances data = source.getDataSet();
		
		FilteredAssociator model = new FilteredAssociator();
		//build the associator on the filtered data -->za one koji �ele znati vi�e: http://weka.sourceforge.net/doc.stable/
		model.buildAssociations(data);
		//ispi�emo rulove
		System.out.println(model);
	}
}
