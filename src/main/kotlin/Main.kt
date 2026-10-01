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
    println(getPaySlip())
}

fun getPaySlip(): String {
    return """
   Pay Slip Printer
======================================================
                        PAYSLIP
======================================================

Employee ID       :  $employeeId
Employee :  ${getFullName()} ($employeeId)
Job / Dept        : $jobTitle ($department)
------------------------------------------------------
Hourly Rate       : ${money(hourlyRate)}
Hours Worked      : $hoursWorked
Overtime Hours    : $overtimeHoursWorked
------------------------------------------------------
Normal Pay        : ${money(calculateNormalPay())}
Overtime Pay      : ${money (calculateOvertimePay())}
"Gross Pay        : ${money(calculateGrossPay())}
Bonus             : ${money  (calculateBonus())}
Tax Deduction     : ${money  (calculateTax())}
Pension Deduction : ${money (calculatePension())}
------------------------------------------------------
Net Pay           : ${money  (calculateNetPay())}
======================================================
""".trimIndent()
}

fun getFullName() = "$firstName $surname".uppercase()
fun calculateNormalPay() = hourlyRate * hoursWorked

fun calculateOvertimePay() = overtimeHoursWorked * hourlyRate * 1.5

fun calculateGrossPay() = calculateNormalPay() + calculateOvertimePay()

fun calculateBonus() = calculateGrossPay() * bonusPercentage / 100

fun calculateTax() = calculateGrossPay() * taxRatePercentage / 100

fun calculatePension() = calculateGrossPay() * pensionContributionPercentage / 100

fun calculateNetPay() = calculateGrossPay() + calculateBonus() - calculateTax() - calculatePension()
fun money(value: Double) = "€%.2f".format(value)