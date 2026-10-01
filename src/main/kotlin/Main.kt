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
    println ("Pay Slip Printer")
    printPaySlip()
}

fun printPaySlip(){

    val normalPay = hoursWorked * hourlyRate
    val overtimePay = overtimeHoursWorked * hourlyRate * 1.5
    val grossPay = normalPay + overtimePay

    val bonus = grossPay * bonusPercentage / 100
    val taxDeduction = grossPay * taxRatePercentage / 100
    val pensionDeduction = grossPay * pensionContributionPercentage / 100

    val netPay = grossPay + bonus - taxDeduction - pensionDeduction
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
    println("Normal Pay        : €" + normalPay)
    println("Overtime Pay      : €" + overtimePay)
    println("Gross Pay         : €" + grossPay)
    println("Bonus             : €" + bonus)
    println("Tax Deduction     : €" + taxDeduction)
    println("Pension Deduction : €" + pensionDeduction)
    println("------------------------------------------------------")
    println("Net Pay           : €" + netPay)
    println("======================================================")
}

fun getFullName() = "$firstName $surname".uppercase()