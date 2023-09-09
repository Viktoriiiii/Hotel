package ru.spb.viktorii.hotel.utils

import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import ru.spb.viktorii.hotel.R

fun setBackground(isValid: Boolean, cvForChangeBackground: CardView) {
    if (isValid)
        cvForChangeBackground.setCardBackgroundColor(ContextCompat.getColor(MAIN, R.color.main_background))
    else
        cvForChangeBackground.setCardBackgroundColor(ContextCompat.getColor(MAIN, R.color.error))
}