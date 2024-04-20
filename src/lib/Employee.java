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

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private FamilyMember spouse;
    private List<FamilyMember> children;
    private EmploymentRecord employmentRecord;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, boolean gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;
        this.children = new LinkedList<>();
    }

    public void setMonthlySalary(int grade) {
        if (grade == 1) {
            monthlySalary = 3000000;
        } else if (grade == 2) {
            monthlySalary = 5000000;
        } else if (grade == 3) {
            monthlySalary = 7000000;
        }

        if (isForeigner) {
            monthlySalary *= 1.5;
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouse = new FamilyMember(spouseName, spouseIdNumber);
    }

    public void addChild(String childName, String childIdNumber) {
        children.add(new FamilyMember(childName, childIdNumber));
    }

    public void setEmploymentRecord(LocalDate startDate) {
        this.employmentRecord = new EmploymentRecord(startDate);
    }

    public int getAnnualIncomeTax() {
        int monthWorkingInYear = calculateMonthWorkingInYear();
        return TaxCalculator.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, isMarried(), getChildCount());
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
        return children.size();
    }
}
