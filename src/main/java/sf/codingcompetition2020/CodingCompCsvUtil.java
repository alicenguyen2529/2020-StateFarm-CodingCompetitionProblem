package sf.codingcompetition2020;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import sf.codingcompetition2020.structures.Agent;
import sf.codingcompetition2020.structures.Customer;
import sf.codingcompetition2020.structures.Vendor;

public class CodingCompCsvUtil {

	/*
	 * #1 readCsvFile() -- Read in a CSV File and return a list of entries in that
	 * file.
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @param classType -- Class of entries being read in.
	 * 
	 * @return -- List of entries being returned.
	 */
	public <T> List<T> readCsvFile(String filePath, Class<T> classType) {

		HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<T>();
		strategy.setType(classType);

		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		CsvToBean<T> csvToBean = new CsvToBean<T>();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		List<T> list = csvToBean.parse(strategy, csvReader);

		return list;
	}

	/*
	 * #2 getAgentCountInArea() -- Return the number of agents in a given area.
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @param area -- The area from which the agents should be counted.
	 * 
	 * @return -- The number of agents in a given area
	 */
	public int getAgentCountInArea(String filePath, String area) {
		List<Agent> agents = new ArrayList<>();
		agents = readCsvFile(filePath, Agent.class);
		int count = 0;

		for (int i = 0; i < agents.size(); i++) {
			if (agents.get(i).getArea().equals(area)) {
				count++;
			}

		}

		return count;

	}

	/*
	 * #3 getAgentsInAreaThatSpeakLanguage() -- Return a list of agents from a given
	 * area, that speak a certain language.
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @param area -- The area from which the agents should be counted.
	 * 
	 * @param language -- The language spoken by the agent(s).
	 * 
	 * @return -- The number of agents in a given area
	 */
	public List<Agent> getAgentsInAreaThatSpeakLanguage(String filePath, String area, String language) {
		List<Agent> agents = new ArrayList<>();
		agents = readCsvFile(filePath, Agent.class);

		List<Agent> newAgents = new ArrayList<>();

		for (int i = 0; i < agents.size(); i++) {
			if (agents.get(i).getArea().equals(area) && agents.get(i).getLanguage().equals(language)) {
				newAgents.add(agents.get(i));
			}

		}

		return newAgents;

	}

	/*
	 * #4 countCustomersFromAreaThatUseAgent() -- Return the number of individuals
	 * from an area that use a certain agent.
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @param customerArea -- The area from which the customers should be counted.
	 * 
	 * @param agentFirstName -- First name of agent.
	 * 
	 * @param agentLastName -- Last name of agent.
	 * 
	 * @return -- The number of customers that use a certain agent in a given area.
	 */
	public short countCustomersFromAreaThatUseAgent(Map<String, String> csvFilePaths, String customerArea,
			String agentFirstName, String agentLastName) {
		List<Agent> agents = new ArrayList<>();
		agents = readCsvFile(csvFilePaths.get("agentList"), Agent.class);

		List<Customer> customers = new ArrayList<>();
		customers = readCsvFile(csvFilePaths.get("customerList"), Customer.class);

		short count = 0;
		int agentId = 0;

		for (int i = 0; i < customers.size(); i++) {
			for (int j = 0; j < agents.size(); j++) {
				if (agents.get(j).getFirstName().equals(agentFirstName)
						&& agents.get(j).getLastName().equals(agentLastName)) {
					agentId = agents.get(j).getAgentId();

				}

				if (customers.get(i).getArea().equals(customerArea) && customers.get(i).getAgentId() == agentId) {
					count++;
				}

			}

		}

		return count;

	}

	/*
	 * #5 getCustomersRetainedForYearsByPlcyCostAsc() -- Return a list of customers
	 * retained for a given number of years, in ascending order of their policy
	 * cost.
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @param yearsOfServeice -- Number of years the person has been a customer.
	 * 
	 * @return -- List of customers retained for a given number of years, in
	 * ascending order of policy cost.
	 */
	public List<Customer> getCustomersRetainedForYearsByPlcyCostAsc(String customerFilePath, short yearsOfService) {
		return null;

	}

	/*
	 * #6 getLeadsForInsurance() -- Return a list of individuals who’ve made an
	 * inquiry for a policy but have not signed up. *HINT* -- Look for customers
	 * that currently have no policies with the insurance company.
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @return -- List of customers who’ve made an inquiry for a policy but have not
	 * signed up.
	 */
	public List<Customer> getLeadsForInsurance(String filePath) {
		return null;

	}

	/*
	 * #7 getVendorsWithGivenRatingThatAreInScope() -- Return a list of vendors
	 * within an area and include options to narrow it down by: a. Vendor rating b.
	 * Whether that vendor is in scope of the insurance (if inScope == false, return
	 * all vendors in OR out of scope, if inScope == true, return ONLY vendors in
	 * scope)
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @param area -- Area of the vendor.
	 * 
	 * @param inScope -- Whether or not the vendor is in scope of the insurance.
	 * 
	 * @param vendorRating -- The rating of the vendor.
	 * 
	 * @return -- List of vendors within a given area, filtered by scope and vendor
	 * rating.
	 */
	public List<Vendor> getVendorsWithGivenRatingThatAreInScope(String filePath, String area, boolean inScope,
			int vendorRating) {
		List<Vendor> vendors = new ArrayList<>();
		vendors = readCsvFile(filePath, Vendor.class);

		List<Vendor> newVendors = new ArrayList<>();
		
		List<Vendor> result = new ArrayList<>();

		for (int i = 0; i < vendors.size(); i++) {
			if(vendors.get(i).getArea().equals(area)) {
				newVendors.add(vendors.get(i));
			}
		}
		
		for (int j = 0; j < newVendors.size(); j++) {
			if(inScope) {
				if(newVendors.get(j).getVendorRating() == vendorRating && newVendors.get(j).isInScope()) {
					result.add(newVendors.get(j));
				}
				
			} else {
				if(newVendors.get(j).getVendorRating() == vendorRating) {
					result.add(newVendors.get(j));
				}
			}
		}
		
		

		return result;

	}

	/*
	 * #8 getUndisclosedDrivers() -- Return a list of customers between the age of
	 * 40 and 50 years (inclusive), who have: a. More than X cars b. less than or
	 * equal to X number of dependents.
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @param vehiclesInsured -- The number of vehicles insured.
	 * 
	 * @param dependents -- The number of dependents on the insurance policy.
	 * 
	 * @return -- List of customers filtered by age, number of vehicles insured and
	 * the number of dependents.
	 */
	public List<Customer> getUndisclosedDrivers(String filePath, int vehiclesInsured, int dependents) {
		return null;

	}

	/*
	 * #9 getAgentIdGivenRank() -- Return the agent with the given rank based on
	 * average customer satisfaction rating. *HINT* -- Rating is calculated by
	 * taking all the agent rating by customers (1-5 scale) and dividing by the
	 * total number of reviews for the agent.
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @param agentRank -- The rank of the agent being requested.
	 * 
	 * @return -- Agent ID of agent with the given rank.
	 */
	public int getAgentIdGivenRank(String filePath, int agentRank) {
		return agentRank;

	}

	/*
	 * #10 getCustomersWithClaims() -- Return a list of customers who’ve filed a
	 * claim within the last <numberOfMonths> (inclusive).
	 * 
	 * @param filePath -- Path to file being read in.
	 * 
	 * @param monthsOpen -- Number of months a policy has been open.
	 * 
	 * @return -- List of customers who’ve filed a claim within the last
	 * <numberOfMonths>.
	 */
	public List<Customer> getCustomersWithClaims(Map<String, String> csvFilePaths, short monthsOpen) {
		return null;

	}

}
