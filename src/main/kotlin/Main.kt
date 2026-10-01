import model.Employee

var employee = Employee(
    1,
    "Joe",
    "Soap",
    "Computer Services",
    "Technician",
    32.45,
    38,
    5,
    5.0,
    23.0,
    7.5
)


fun main(){
    var input : Int
    add()
    do {
        input = menu()
        when(input) {
            1 -> println("Hourly Rate: ${money(employee.hourlyRate)}")
            2 -> println("Hours Worked: ${employee.hoursWorked}")
            3 -> println("Overtime Hours: ${employee.overtimeHoursWorked}")
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
         model.Employee Menu for ${getFullName()}
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

model.Employee ID       :  ${employee.employeeId}
model.Employee          :  ${getFullName()} (${employee.employeeId})
Job / Dept        : ${employee.jobTitle} (${employee.department})
------------------------------------------------------
Hourly Rate       : ${money(employee.hourlyRate)}
Hours Worked      : ${employee.hoursWorked}
Overtime Hours    : ${employee.overtimeHoursWorked}
------------------------------------------------------
Normal Pay        : ${money(calculateNormalPay())}
Overtime Pay      : ${money (calculateOvertimePay())}
Gross Pay        : ${money(calculateGrossPay())}
Bonus             : ${money  (calculateBonus())}
Tax Deduction     : ${money  (calculateTax())}
Pension Deduction : ${money (calculatePension())}
------------------------------------------------------
Net Pay           : ${money  (calculateNetPay())}
======================================================
""".trimIndent()
}

fun getFullName() = "${employee.firstName} ${employee.surname}".uppercase()
fun calculateNormalPay() = employee.hourlyRate * employee.hoursWorked

fun calculateOvertimePay() = employee.overtimeHoursWorked * employee.hourlyRate * 1.5

fun calculateGrossPay() = calculateNormalPay() + calculateOvertimePay()

fun calculateBonus() = calculateGrossPay() * employee.bonusPercentage / 100

fun calculateTax() = calculateGrossPay() * employee.pensionContributionPercentage / 100
fun calculatePension() = calculateGrossPay() * employee.pensionContributionPercentage / 100
fun calculateNetPay() = calculateGrossPay() + calculateBonus() - calculateTax() - calculatePension()
fun money(value: Double) = "€%.2f".format(value)
fun add() {

    print("Enter employee ID: ")
    val employeeId = readln().toInt()

    print("Enter first name: ")
    val firstName = readlnOrNull().toString()

    print("Enter surname: ")
    val surname = readlnOrNull().toString()

    print("Enter department: ")
    val department = readlnOrNull().toString()

    print("Enter job title: ")
    val jobTitle = readlnOrNull().toString()

    print("Enter hourly rate: ")
    val hourlyRate = readln().toDouble()

    print("Enter hours worked: ")
    val hoursWorked = readln().toInt()

    print("Enter overtime hours worked: ")
    val overtimeHoursWorked = readln().toInt()

    print("Enter bonus percentage: ")
    val bonusPercentage = readln().toDouble()

    print("Enter tax rate percentage: ")
    val taxRatePercentage = readln().toDouble()

    print("Enter pension contribution percentage: ")
    val pensionContributionPercentage = readln().toDouble()

    employee = Employee(
        employeeId,
        firstName,
        surname,
        department,
        jobTitle,
        hourlyRate,
        hoursWorked,
        overtimeHoursWorked,
        bonusPercentage,
        taxRatePercentage,
        pensionContributionPercentage
    )
}
