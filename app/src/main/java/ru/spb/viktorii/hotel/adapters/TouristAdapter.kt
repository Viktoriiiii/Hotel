package ru.spb.viktorii.hotel.adapters

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.spb.viktorii.hotel.R
import ru.spb.viktorii.hotel.model.Tourist
import ru.spb.viktorii.hotel.utils.FocusChangeListenerCheck
import ru.spb.viktorii.hotel.utils.getStringNumber
import ru.spb.viktorii.hotel.utils.setBackground

class TouristAdapter(var tourists: ArrayList<Tourist>) : RecyclerView.Adapter<TouristAdapter.TouristViewHolder>() {

    class TouristViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvNumberTourist: TextView = itemView.findViewById(R.id.tv_number_tourist)
        val cvShowHideTourist: CardView = itemView.findViewById(R.id.cv_show_hide_tourist)
        val ivShowHideTourist: ImageView = itemView.findViewById(R.id.iv_show_hide_tourist)
        val cvFirstName: CardView = itemView.findViewById(R.id.cv_first_name)
        val cvLastName: CardView = itemView.findViewById(R.id.cv_last_name)
        val cvBirthday: CardView = itemView.findViewById(R.id.cv_birthday)
        val cvCitizenship: CardView = itemView.findViewById(R.id.cv_citizenship)
        val cvInternationalPassportNumber: CardView = itemView.findViewById(R.id.cv_international_passport_number)
        val cvPassportValidityPeriod: CardView = itemView.findViewById(R.id.cv_passport_validity_period)
        val etFirstName: AppCompatEditText = itemView.findViewById(R.id.et_first_name)
        val etLastName: AppCompatEditText = itemView.findViewById(R.id.et_last_name)
        val etBirthday: AppCompatEditText = itemView.findViewById(R.id.et_birthday)
        val etCitizenship: AppCompatEditText = itemView.findViewById(R.id.et_citizenship)
        val etInternationalPassportNumber: AppCompatEditText = itemView.findViewById(R.id.et_international_passport_number)
        val etPassportValidityPeriod: AppCompatEditText = itemView.findViewById(R.id.et_passport_validity_period)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tourist, parent, false)
        return TouristViewHolder(view)
    }

    override fun onBindViewHolder(holder: TouristViewHolder, position: Int) {
        holder.tvNumberTourist.text = String.format("${(1 + position).getStringNumber()} турист")
        setVisibility(holder)
        setListeners(holder, position)
    }

    private fun setVisibility(holder: TouristViewHolder){
        holder.cvShowHideTourist.setOnClickListener {
            if (holder.cvFirstName.visibility == View.VISIBLE){
                holder.ivShowHideTourist.setImageResource(R.drawable.ic_arrow_down_24)
                holder.cvFirstName.visibility = View.GONE
                holder.cvLastName.visibility = View.GONE
                holder.cvBirthday.visibility = View.GONE
                holder.cvCitizenship.visibility = View.GONE
                holder.cvInternationalPassportNumber.visibility = View.GONE
                holder.cvPassportValidityPeriod.visibility = View.GONE
            } else {
                holder.ivShowHideTourist.setImageResource(R.drawable.ic_arrow_up_24)
                holder.cvFirstName.visibility = View.VISIBLE
                holder.cvLastName.visibility = View.VISIBLE
                holder.cvBirthday.visibility = View.VISIBLE
                holder.cvCitizenship.visibility = View.VISIBLE
                holder.cvInternationalPassportNumber.visibility = View.VISIBLE
                holder.cvPassportValidityPeriod.visibility = View.VISIBLE
            }
        }
    }

    private fun setListeners(holder: TouristViewHolder, position: Int){
        holder.etFirstName.onFocusChangeListener =
            FocusChangeListenerCheck(holder.cvFirstName, FocusChangeListenerCheck.ValidationType.NO_EMPTY_TEXT)
        holder.etLastName.onFocusChangeListener =
            FocusChangeListenerCheck(holder.cvLastName, FocusChangeListenerCheck.ValidationType.NO_EMPTY_TEXT)
        holder.etBirthday.onFocusChangeListener =
            FocusChangeListenerCheck(holder.cvBirthday, FocusChangeListenerCheck.ValidationType.NO_EMPTY_TEXT)
        holder.etCitizenship.onFocusChangeListener =
            FocusChangeListenerCheck(holder.cvCitizenship, FocusChangeListenerCheck.ValidationType.NO_EMPTY_TEXT)
        holder.etInternationalPassportNumber.onFocusChangeListener =
            FocusChangeListenerCheck(holder.cvInternationalPassportNumber, FocusChangeListenerCheck.ValidationType.NO_EMPTY_TEXT)
        holder.etPassportValidityPeriod.onFocusChangeListener =
            FocusChangeListenerCheck(holder.cvPassportValidityPeriod, FocusChangeListenerCheck.ValidationType.NO_EMPTY_TEXT)

        setupEditTextListener(holder.etFirstName, position)
        setupEditTextListener(holder.etLastName, position)
        setupEditTextListener(holder.etBirthday, position)
        setupEditTextListener(holder.etCitizenship, position)
        setupEditTextListener(holder.etInternationalPassportNumber, position)
        setupEditTextListener(holder.etPassportValidityPeriod, position)
    }

    private fun setupEditTextListener(editText: AppCompatEditText, position: Int) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val currentTourist = tourists[position]
                when (editText.id) {
                    R.id.et_first_name -> currentTourist.firstName = s.toString()
                    R.id.et_last_name -> currentTourist.lastName = s.toString()
                    R.id.et_birthday -> currentTourist.birthday = s.toString()
                    R.id.et_citizenship -> currentTourist.citizenship = s.toString()
                    R.id.et_international_passport_number -> currentTourist.internationalPassportNumber = s.toString()
                    R.id.et_passport_validity_period -> currentTourist.passportValidityPeriod = s.toString()
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    fun isDataComplete(recyclerView: RecyclerView): Boolean {
        var isValid = true
        for (i in 0 until tourists.size) {
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(i) as? TouristViewHolder
            if (viewHolder != null) {
                val tourist = tourists[i]
                if (!tourist.isDataComplete()) {
                    isValid = false
                }
                setBackground(tourist.firstName.isNotEmpty(), viewHolder.cvFirstName)
                setBackground(tourist.lastName.isNotEmpty(), viewHolder.cvLastName)
                setBackground(tourist.birthday.isNotEmpty(), viewHolder.cvBirthday)
                setBackground(tourist.citizenship.isNotEmpty(), viewHolder.cvCitizenship)
                setBackground(tourist.internationalPassportNumber.isNotEmpty(), viewHolder.cvInternationalPassportNumber)
                setBackground(tourist.passportValidityPeriod.isNotEmpty(), viewHolder.cvPassportValidityPeriod)
            }
        }
        return isValid
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addTourist(tourist: Tourist){
        tourists.add(tourist)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return tourists.size
    }
}