package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int idNumber;
	private int attemptedCredits;
	private double totalGPA;
	private double bearBucksBalance;
	private int passingCredits;

	
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
	 * @return returns the total attempted credits of the Student
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}

	/**
	 * 
	 * @return returns the total passing credits of the Student
	 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}

	/**
	 * 
	 * @return returns the GPA of the student
	 */
	public double calculateGradePointAverage() {
		return totalGPA / attemptedCredits;
	}

	/**
	 * 
	 * @param grade the grade of the Student in the course
	 * @param credit the grade of the course
	 */
	public void submitGrade(double grade, int credit) {
		this.attemptedCredits = attemptedCredits + credit;
		this.totalGPA = totalGPA + (grade * credit);
		if(grade >= 1.7) {
			this.passingCredits = credit + passingCredits;
		}
	}
	
	/**
	 * 
	 * @return returns the Class Standing of the Student
	 */
	public String getClassStanding() {
		if(passingCredits < 30) {
			return "First Year";
		}
		else if(passingCredits >= 30 && passingCredits < 60) {
			return "Sophomore";
		}
		else if(passingCredits >= 60 && passingCredits < 90) {
			return "Junior";
		}
		else{
			return "Senior";
		}
	}

	/**
	 * 
	 * @return returns a boolean indicating whether or not Student is eligible for PhiBetaKappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if(calculateGradePointAverage() >= 3.60 && passingCredits >= 98) {
			return true;
		}
		else if(calculateGradePointAverage() >= 3.80 && passingCredits >= 75) {
			return true;
		}
		else {
			return false;
		}
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
	 * @param amount amount to be added
	 */
	public void deductBearBucks(double amount) {
		this.bearBucksBalance = bearBucksBalance - amount;
	}

	/**
	 * 
	 * @return returns BearBucksBalance
	 */
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}

	/**
	 * 
	 * @return returns $0 in double type to indicate cash out balance
	 */
	public double cashOutBearBucks() {
		if( bearBucksBalance > 10) {
			double balance = bearBucksBalance - 10;
			this.bearBucksBalance = 0.0;
			return balance;
		}
		else {
			this.bearBucksBalance = 0.0;
			return 0.0;
		}
	}
	
	/**
	 * 
	 * @param firstName first name of the parent 
	 * @param otherParent other parent of the Student in type Student
	 * @param isHyphenated boolean indicating whether to Hyphen last name or not 
	 * @param id the id of the first parent
	 * @return a Student type of which is the legacy of both parents. 
	 */
	
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		String lastName = "";
		if(isHyphenated == true) {
			lastName = this.lastName + "-" + otherParent.lastName;
		}
		else {
			lastName = this.lastName;
		}
		
		Student studentLegacy = new Student(firstName, lastName, id);
		studentLegacy.bearBucksBalance = otherParent.cashOutBearBucks() + this.cashOutBearBucks();
		return studentLegacy;
	}
	
	@Override
	public String toString() {
		return "Student: " + this.getFullName() + "," +this.getId();
	}
}
