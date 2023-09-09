package ru.spb.viktorii.hotel.model

class Tourist(var id: Int) {
    var firstName: String = ""
    var lastName: String = ""
    var birthday: String = ""
    var citizenship: String = ""
    var internationalPassportNumber: String = ""
    var passportValidityPeriod: String = ""

    fun isDataComplete(): Boolean {
        return firstName.isNotEmpty() &&
                lastName.isNotEmpty() &&
                birthday.isNotEmpty() &&
                citizenship.isNotEmpty() &&
                internationalPassportNumber.isNotEmpty() &&
                passportValidityPeriod.isNotEmpty()
    }
}

