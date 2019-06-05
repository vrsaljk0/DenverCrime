package sql;

import weka.associations.*;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToBinary;

public class Mining {
	
	public static String getRules() throws Exception {
		//String dataset = "C:\\Users\\Lukaku\\Documents\\programsko\\crime_sreden.csv";
		String dataset = "C:\\Romano\\2.god\\Objektno\\eclipse_vj\\MySql-vjezba\\crime.csv";
		DataSource source = new DataSource(dataset);
		Instances data = source.getDataSet();
				
		Apriori model = new Apriori();
		model.setLowerBoundMinSupport(0.001);
		SelectedTag t = new SelectedTag(3, Apriori.TAGS_SELECTION);
		model.setMetricType(t);
		model.setNumRules(500);
		model.setUpperBoundMinSupport(2.0);
		model.buildAssociations(data);
		System.out.println(model);
		
		return model.toString();
	}
	
	public static String getRulesFP() throws Exception {
		//String dataset = "C:\\Users\\Lukaku\\Documents\\programsko\\crime_sreden.csv";
		String dataset = "C:\\Romano\\2.god\\Objektno\\eclipse_vj\\MySql-vjezba\\crime.csv";
		DataSource source = new DataSource(dataset);
		Instances data = source.getDataSet();
		
		NominalToBinary nominalToBinary = new NominalToBinary();
		nominalToBinary.setInputFormat(data);
		data = Filter.useFilter(data, nominalToBinary);
		
		NumericToBinary numericToBinary = new NumericToBinary();
		numericToBinary.setInputFormat(data);
		data = Filter.useFilter(data, numericToBinary);
				
		FPGrowth model = new FPGrowth();
		model.setLowerBoundMinSupport(0.001);
		SelectedTag t = new SelectedTag(3, Apriori.TAGS_SELECTION);
		model.setMetricType(t);
		model.setUpperBoundMinSupport(2.0);
		model.setLowerBoundMinSupport(2.0);
		model.setNumRulesToFind(500);
		model.buildAssociations(data);
		System.out.println(model);
		
		return model.toString();
	}
}
