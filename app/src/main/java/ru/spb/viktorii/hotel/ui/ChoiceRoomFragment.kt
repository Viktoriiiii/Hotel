package ru.spb.viktorii.hotel.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import ru.spb.viktorii.hotel.MAIN
import ru.spb.viktorii.hotel.adapters.RoomAdapter
import ru.spb.viktorii.hotel.databinding.FragmentChoiceRoomBinding
import ru.spb.viktorii.hotel.viewmodels.RoomViewModel

class ChoiceRoomFragment : Fragment() {

    private var _binding: FragmentChoiceRoomBinding? = null
    private val binding get() = _binding!!

    private val vmRoom: RoomViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChoiceRoomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showInfoAboutRooms()
    }

    private fun showInfoAboutRooms() {
        lifecycleScope.launch {
            binding.apply {
                vmRoom.getRooms()
                vmRoom.rooms.observe(this@ChoiceRoomFragment){
                    binding.rvHotelRooms.adapter = RoomAdapter(it.rooms)
                }
            }
        }

        MAIN.setItemsInToolbar(MAIN.nameHotel, true)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}