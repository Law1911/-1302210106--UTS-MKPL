package lib;

import java.time.LocalDate;

import java.util.LinkedList;
import java.util.List;

public class Employee {
	public enum Gender {
		MALE,
		FEMALE
	}

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	

	private LocalDate dateJoined; // menganti menjadi localdate dengan begitu tidak perlu membuat varibel tambahan
	private int monthWorkingInYear;

	
	private boolean isForeigner;
	private Gender gender; // dengan begini pembaca dapat mengerti secara cepat
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, Gender gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.dateJoined = dateJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public void setMonthlySalary(int grade) {   
		switch (grade) {
			case 1:
				monthlySalary = isForeigner ? 4500000 : 3000000;
				break;
			case 2:
				monthlySalary = isForeigner ? 7500000 : 5000000;
				break;
			case 3:
				monthlySalary = isForeigner ? 10500000 : 7000000;
				break;
			default:
				throw new IllegalArgumentException("Invalid grade");
		}
	}// Sederhanakan logika dalam method setMonthlySalary dan eliminasi duplikasi.
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	public int getAnnualIncomeTax() {
		calculateMonthWorkingInYear();
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, isMarried(), getChildCount());
	}
	
	private void calculateMonthWorkingInYear() {
		LocalDate currentDate = LocalDate.now();
		if (dateJoined.getYear() == currentDate.getYear()) {
			monthWorkingInYear = currentDate.getMonthValue() - dateJoined.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}
	}
	private boolean isMarried() {
		return spouseIdNumber != null && !spouseIdNumber.isEmpty();
	}
	
	private int getChildCount() {
		return childIdNumbers.size();
	}
}
