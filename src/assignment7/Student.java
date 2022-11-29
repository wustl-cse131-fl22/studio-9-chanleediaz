package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int idNumber;
	private double bearBucksBalance;
	

	
	/**
	 * 
	 * @param firstName of the Student
	 * @param lastName of the Student
	 * @param idNumber of the Student
	 */
	public Student(String firstName, String lastName, int idNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
	}

	/**
	 * 
	 * @return returns the Full Name of the Student
	 */
	public String getFullName() {
		return firstName + " "+ lastName;
	}
	
	/**
	 * 
	 * @return returns the Id of the Student
	 */
	public int getId() {
		return idNumber;
	}

	/**
	 * 
	 * @param amount amount to be deposited
	 */
	public void depositBearBucks(double amount) {
		this.bearBucksBalance = bearBucksBalance + amount;
	}


	/**
	 * 
	 * @return returns BearBucksBalance
	 */
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}

}
