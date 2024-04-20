
package lib;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private LocalDate dateJoined;
    private boolean isForeigner;
    private boolean gender;

    private FamilyMember spouse;
    private List<FamilyMember> childrenList;
    private EmploymentRecord employmentRecord;
    private Salary salaryDetails;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, boolean gender, Salary salaryDetails) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;
        this.salaryDetails = salaryDetails;
        this.childrenList = new LinkedList<>();
    }

    public void setMonthlySalary(int grade) {
        salaryDetails.setMonthlySalary(grade, isForeigner);
    }

    public void setAnnualDeductible(int deductible) {
        salaryDetails.setAnnualDeductible(deductible);
    }

    public void setAdditionalIncome(int income) {
        salaryDetails.setOtherMonthlyIncome(income);
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouse = new FamilyMember(spouseName, spouseIdNumber);
    }

    public void addChild(String childName, String childIdNumber) {
        childrenList.add(new FamilyMember(childName, childIdNumber));
    }

    public void setEmploymentRecord(LocalDate startDate) {
        this.employmentRecord = new EmploymentRecord(startDate);
    }

    public int getAnnualIncomeTax() {
        int monthWorkingInYear = calculateMonthWorkingInYear();
        return TaxCalculator.calculateTax(salaryDetails.getMonthlySalary(), salaryDetails.getOtherMonthlyIncome(), monthWorkingInYear, isMarried(), getChildCount());
    }
    

    private int calculateMonthWorkingInYear() {
        LocalDate currentDate = LocalDate.now();
        if (dateJoined.getYear() == currentDate.getYear()) {
            return currentDate.getMonthValue() - dateJoined.getMonthValue();
        } else {
            return 12;
        }
    }

    private boolean isMarried() {
        return spouse != null;
    }

    private int getChildCount() {
        return childrenList.size();
    }

	private boolean getIsForeigner(){
		return isForeigner;
	}
}
