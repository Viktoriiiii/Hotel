package ru.spb.viktorii.hotel.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.spb.viktorii.hotel.MAIN
import ru.spb.viktorii.hotel.R
import ru.spb.viktorii.hotel.databinding.FragmentOrderPaidBinding

class OrderPaidFragment : Fragment() {

    private var _binding: FragmentOrderPaidBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderPaidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MAIN.setItemsInToolbar(getString(R.string.order_paid), true)
        binding.mbSuper.setOnClickListener {
            MAIN.navController.navigate(R.id.action_orderPaidFragment_to_hotelFragment)
        }

        val randomNumber = (0..1000000).random().toString()
        binding.tvConfirmationOrder.text = getString(R.string.order_paid_description, randomNumber)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}