package lib;

public class TaxCalculator {

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int monthWorkingInYear, int annualDeductible, boolean isMarried, int childCount) {
        // Menghitung total pendapatan tahunan (gaji bulanan x 12)
        int annualIncome = (monthlySalary + otherMonthlyIncome) * monthWorkingInYear;

        // Mengurangkan jumlah potongan tahunan
        annualIncome -= annualDeductible;

        // Menentukan tarif pajak berdasarkan pendapatan tahunan
        double taxRate;
        if (annualIncome <= 50000000) {
            taxRate = 0.05;
        } else if (annualIncome <= 250000000) {
            taxRate = 0.15;
        } else {
            taxRate = 0.25;
        }

        // Mengurangkan jumlah potongan tambahan untuk pasangan dan anak
        if (isMarried) {
            annualIncome -= 50000000;
        }
        annualIncome -= childCount * 25000000;

        // Menghitung pajak berdasarkan tarif dan pendapatan tahunan setelah potongan
        double tax = annualIncome * taxRate;

        // Mengembalikan nilai pajak bulanan
        return (int) (tax / 12);
    }
}

