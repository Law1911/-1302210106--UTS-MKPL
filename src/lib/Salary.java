package lib;

public class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private Employee employee;

    public Salary(int grade, boolean isForeigner) {
        setMonthlySalary(grade, isForeigner);
        this.otherMonthlyIncome = 0; // Sementara tidak ada tambahan penghasilan bulanan
        this.annualDeductible = 0; // Sementara tidak ada pengurangan pajak tahunan
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int grade, boolean isForeigner) {
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

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public void setOtherMonthlyIncome(int otherMonthlyIncome) {
        this.otherMonthlyIncome = otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public void setAnnualDeductible(int annualDeductible) {
        this.annualDeductible = annualDeductible;
    }
  
}
