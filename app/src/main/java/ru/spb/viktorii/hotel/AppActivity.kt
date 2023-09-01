package ru.spb.viktorii.hotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.spb.viktorii.hotel.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MAIN = this
        navController = Navigation.findNavController(this, R.id.fragment_container)
    }

    override fun onSupportNavigateUp(): Boolean {
        // Обрабатываем возврат на предыдущий фрагмент при нажатии на кнопку "Назад" в панели инструментов
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun setItemsInToolbar(title: String, backButtonVisibility: Boolean) {
        binding.ivBack.visibility = if (backButtonVisibility) View.VISIBLE else View.GONE
        binding.tvTitle.text = title
    }
}