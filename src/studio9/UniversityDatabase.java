package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions

	private final Map<String,Student> universityDatabase;
	
	public UniversityDatabase() {
		this.universityDatabase = new HashMap<String,Student>();
	}
	
	
	public void addStudent(String accountName, Student student) {
		universityDatabase.put(accountName, student);
	}

	public int getStudentCount() {
		return universityDatabase.size();
	}

	public String lookupFullName(String accountName) {
		String name = null;
		
		if(universityDatabase.getOrDefault(accountName, null) != null) {
			name = universityDatabase.get(accountName).getFullName();
		}
		return name;
	}

	public double getTotalBearBucks() {
		double total = 0; 
		
		for(String key: universityDatabase.keySet()) {
			total += universityDatabase.get(key).getBearBucksBalance();
		}
		
		return total;
}
}