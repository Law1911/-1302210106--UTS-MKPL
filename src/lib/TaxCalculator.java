package lib;

public class TaxCalculator {

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int monthWorkingInYear, boolean isMarried, int childCount) {
        // Menghitung total pendapatan tahunan (gaji bulanan x jumlah bulan bekerja)
        int annualIncome = (monthlySalary + otherMonthlyIncome) * monthWorkingInYear;

        // Menentukan penghasilan tidak kena pajak
        int taxExemption = 54000000; // Penghasilan tidak kena pajak awal
        if (isMarried) {
            taxExemption += 4500000; // Tambahan untuk pasangan
        }
        taxExemption += Math.min(childCount, 3) * 4500000; // Tambahan untuk anak (maksimal 3 anak)

        // Menghitung pajak berdasarkan penghasilan bersih setelah pengurangan penghasilan tidak kena pajak
        double tax = (annualIncome - taxExemption) * 0.05; // Tarif pajak 5%

        // Mengembalikan nilai pajak bulanan
        return (int) (tax / 12);
    }
}
