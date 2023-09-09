package ru.spb.viktorii.hotel.utils

import android.text.TextUtils
import android.util.Patterns
import java.text.NumberFormat
import java.util.*

fun Int.toStringWithRubles(): String {
    return String.format("${
        NumberFormat.getNumberInstance(Locale("ru"))
        .format(this)} ₽")
}

fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isPhoneValid(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.PHONE.matcher(this).matches()
}

fun Int.getStringNumber() : String {
    return when (this) {
        1 -> "Первый"
        2 -> "Второй"
        3 -> "Третий"
        4 -> "Четвертый"
        5 -> "Пятый"
        else -> "Следующий"
    }
}