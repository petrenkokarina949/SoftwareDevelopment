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

fun main(){
    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Hourly Rate: ${money(hourlyRate)}")
            2 -> println("Hours Worked: $hoursWorked")
            3 -> println("Overtime Hours: $overtimeHoursWorked")
            4 -> println("Bonus : ${money  (calculateBonus())}")
            5 -> println("Tax Rate: ${money  (calculateTax())}")
            6 -> println("Pension : ${money (calculatePension())}")
            7 -> println("Gross Payment : ${money(calculateGrossPay())}")
            8 -> println("Net pay: ${money(calculateNetPay())}")
            9 -> println(getPaySlip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}
fun menu() : Int {
    print("""
         Employee Menu for ${getFullName()}
           1. Hourly Rate
           2. Hours Worked
           3. Overtime Hours
           4. Bonus
           5. Tax Rate
           6. Pension
           7. Gross Pay
           8. Net Pay
           9. Full Payslip
          -1. Exit
         Enter Option : """)
    return readln().toInt()
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