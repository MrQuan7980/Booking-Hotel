package com.example.appbookinghotel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.appbookinghotel.databinding.ActivityNavigationBinding
import com.example.appbookinghotel.databinding.EditButtonBarItemBinding
import com.example.appbookinghotel.fragment.BookingFragment
import com.example.appbookinghotel.fragment.PersonFragment
import com.example.appbookinghotel.fragment.ReservationFragment
import com.example.appbookinghotel.fragment.SavedFragment
import com.example.appbookinghotel.model.ButtonBarItemModel

class Navigation : AppCompatActivity() {
    private lateinit var binding : ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonMenuBar()
    }
    private fun initButtonMenuBar() {
        val buttonBarItems = listOf(
            ButtonBarItemModel(binding.buttonHome, R.drawable.ic_hotel, "Đặt phòng", 0),
            ButtonBarItemModel(binding.buttonFavorite, R.drawable.ic_favorite, "Đã lưu", 1),
            ButtonBarItemModel(binding.buttonReservation, R.drawable.ic_luggage, "Đặt chỗ", 2),
            ButtonBarItemModel(binding.buttonPerson, R.drawable.ic_person, "Người dùng", 3)
        )
        var selectedPosition = 0

        buttonBarItems.forEachIndexed { index, item ->
            setupButtonBarItem(item.binding, item.iconRes, item.text, selectedPosition)
            replaceFragment(BookingFragment())
            item.binding.root.setOnClickListener {
                selectedPosition = index
                buttonBarItems.forEach { otherItem ->
                    setupButtonBarItem(otherItem.binding, otherItem.iconRes, otherItem.text, selectedPosition)
                }
                when (index) {
                    0 -> replaceFragment(BookingFragment())
                    1 -> replaceFragment(SavedFragment())
                    2 -> replaceFragment(ReservationFragment())
                    3 -> replaceFragment(PersonFragment())
                }
            }
        }
    }
    private fun setupButtonBarItem(itemBinding: EditButtonBarItemBinding, iconRes: Int, text: String, selectedPosition: Int) {
        val position = when (itemBinding) {
            binding.buttonHome -> 0
            binding.buttonFavorite -> 1
            binding.buttonReservation -> 2
            binding.buttonPerson -> 3
            else -> -1
        }
        val isSelected = position == selectedPosition
        val colors = intArrayOf(
            ContextCompat.getColor(this, R.color.grey),
            ContextCompat.getColor(this, R.color.blue)
        )

        itemBinding.apply {
            icon.setImageResource(iconRes)
            icon.setColorFilter(colors[if (isSelected) 1 else 0])
            title.text = text
            title.setTextColor(colors[if (isSelected) 1 else 0])
            indicator.visibility = if (isSelected) View.VISIBLE else View.INVISIBLE
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayoutMain, fragment)
        fragmentTransaction.commit()
    }
}