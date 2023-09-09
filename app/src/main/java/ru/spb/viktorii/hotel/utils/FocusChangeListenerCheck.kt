package ru.spb.viktorii.hotel.utils

import android.view.View
import android.widget.EditText
import androidx.cardview.widget.CardView

class FocusChangeListenerCheck(private val cvForChangeBackground: CardView, private val validationType: ValidationType): View.OnFocusChangeListener {

    enum class ValidationType {
        EMAIL,
        PHONE,
        NO_EMPTY_TEXT
    }

    override fun onFocusChange(editText: View?, hasFocus: Boolean) {
        if (editText is EditText) {
            if (!hasFocus) {
                val text = editText.text.toString()
                when (validationType) {
                    ValidationType.EMAIL -> setBackground(text.isEmailValid(), cvForChangeBackground)
                    ValidationType.PHONE -> setBackground(text.isPhoneValid(), cvForChangeBackground)
                    ValidationType.NO_EMPTY_TEXT -> setBackground(text.isNotEmpty(), cvForChangeBackground)
                }
            }
        }
    }
}