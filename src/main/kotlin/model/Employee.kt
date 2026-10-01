package model

data class Employee(
var employeeId :Int,
var firstName :String,
var surname :String,
var department :String,
var jobTitle:String,
var hourlyRate: Double,
var hoursWorked: Int,
var overtimeHoursWorked: Int,
var bonusPercentage: Double,
var taxRatePercentage: Double,
var pensionContributionPercentage: Double){
    override fun toString(): String {
        return "Employee(employeeId=$employeeId," +
                " firstName='$firstName', " +
                "surname='$surname', " +
                "department='$department', " +
                "jobTitle='$jobTitle'," +
                " hourlyRate=$hourlyRate, " +
                "hoursWorked=$hoursWorked," +
                " overtimeHoursWorked=$overtimeHoursWorked, " +
                "bonusPercentage=$bonusPercentage, " +
                "taxRatePercentage=$taxRatePercentage, " +
                "pensionContributionPercentage=$pensionContributionPercentage)"
    }

}
