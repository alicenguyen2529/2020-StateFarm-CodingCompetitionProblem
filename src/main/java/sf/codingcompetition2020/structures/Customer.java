package sf.codingcompetition2020.structures;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class Customer {
	@CsvBindByName(column = "customerId")
	private int customerId;
	
	@CsvBindByName(column = "firstName")
	private String firstName;
	
	@CsvBindByName(column = "lastName")
	private String lastName;
	
	@CsvBindByName(column = "age")
	private int age;
	
	@CsvBindByName(column = "area")
	private String area;
	
	@CsvBindByName(column = "agentId")
	private int agentId;
	
	@CsvBindByName(column = "agentRating")
	private short agentRating;
	
	@CsvBindByName(column = "primaryLanguage")
	private String primaryLanguage;
	
	@CsvBindByName(column = "dependents")
	private List<Dependent> dependents;
	
	@CsvBindByName(column = "homePolicy")
	private boolean homePolicy;
	
	@CsvBindByName(column = "autoPolicy")
	private boolean autoPolicy;
	
	@CsvBindByName(column = "rentersPolicy")
	private boolean rentersPolicy;
	
	@CsvBindByName(column = "totalMonthlyPremium")
	private String totalMonthlyPremium;
	
	@CsvBindByName(column = "yearsOfService")
	private short yearsOfService;
	
	@CsvBindByName(column = "vehiclesInsured")
	private Integer vehiclesInsured;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public short getAgentRating() {
		return agentRating;
	}

	public void setAgentRating(short agentRating) {
		this.agentRating = agentRating;
	}

	public String getPrimaryLanguage() {
		return primaryLanguage;
	}

	public void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	public boolean isHomePolicy() {
		return homePolicy;
	}

	public void setHomePolicy(boolean homePolicy) {
		this.homePolicy = homePolicy;
	}

	public boolean isAutoPolicy() {
		return autoPolicy;
	}

	public void setAutoPolicy(boolean autoPolicy) {
		this.autoPolicy = autoPolicy;
	}

	public boolean isRentersPolicy() {
		return rentersPolicy;
	}

	public void setRentersPolicy(boolean rentersPolicy) {
		this.rentersPolicy = rentersPolicy;
	}

	public String getTotalMonthlyPremium() {
		return totalMonthlyPremium;
	}

	public void setTotalMonthlyPremium(String totalMonthlyPremium) {
		this.totalMonthlyPremium = totalMonthlyPremium;
	}

	public short getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(short yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	public Integer getVehiclesInsured() {
		return vehiclesInsured;
	}

	public void setVehiclesInsured(Integer vehiclesInsured) {
		this.vehiclesInsured = vehiclesInsured;
	}

}
