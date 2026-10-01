val firstName = "Joe"
val surname = "Soap"
val department = "Computer Servise"
val jobTitle = "Technician"
val hourlyRate = 26.87
val hoursWorked = 39
val overtimeHoursWorked = 4
val bonusPercentage = 4.5
val taxRatePercentage = 23.5
val pensionContributionPercentage = 6.7
val employeeId = 6143

fun main(args: Array<String>){
    printPaySlip()
}

fun printPaySlip(){
    println("Pay Slip Printer")
    println("======================================================")
    println("                         PAYSLIP")
    println("======================================================")

    println("Employee ID       : " + employeeId)
    println("Employee : " + getFullName() + " (" + employeeId + ")")
    println("Job / Dept        : " + jobTitle + " (" + department + ")")
    println("------------------------------------------------------")
    println("Hourly Rate       : €" + hourlyRate)
    println("Hours Worked      : " + hoursWorked)
    println("Overtime Hours    : " + overtimeHoursWorked)
    println("------------------------------------------------------")
    println("Normal Pay        : €" + calculateNormalPay())
    println("Overtime Pay      : €" + calculateOvertimePay())
    println("Gross Pay         : €" + calculateGrossPay())
    println("Bonus             : €" + calculateBonus())
    println("Tax Deduction     : €" + calculateTax())
    println("Pension Deduction : €" + calculatePension())
    println("------------------------------------------------------")
    println("Net Pay           : €" + calculateNetPay())
    println("======================================================")
}

fun getFullName() = "$firstName $surname".uppercase()
fun calculateNormalPay() = hourlyRate * hoursWorked

fun calculateOvertimePay() = overtimeHoursWorked * hourlyRate * 1.5

fun calculateGrossPay() = calculateNormalPay() + calculateOvertimePay()

fun calculateBonus() = calculateGrossPay() * bonusPercentage / 100

fun calculateTax() = calculateGrossPay() * taxRatePercentage / 100

fun calculatePension() = calculateGrossPay() * pensionContributionPercentage / 100

fun calculateNetPay() = calculateGrossPay() + calculateBonus() - calculateTax() - calculatePension()