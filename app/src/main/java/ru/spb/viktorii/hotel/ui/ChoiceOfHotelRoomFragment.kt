package ru.spb.viktorii.hotel.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.spb.viktorii.hotel.MAIN
import ru.spb.viktorii.hotel.databinding.FragmentChoiceOfHotelRoomBinding

class ChoiceOfHotelRoomFragment : Fragment() {

    private var _binding: FragmentChoiceOfHotelRoomBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChoiceOfHotelRoomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        MAIN.setItemsInToolbar("Название отеля", true)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}