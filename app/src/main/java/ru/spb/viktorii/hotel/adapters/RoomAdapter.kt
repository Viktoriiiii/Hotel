package ru.spb.viktorii.hotel.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.spb.viktorii.domain.model.Rooms
import ru.spb.viktorii.hotel.utils.MAIN
import ru.spb.viktorii.hotel.R
import ru.spb.viktorii.hotel.utils.toStringWithRubles
import java.util.*

class RoomAdapter(private val rooms: List<Rooms.Room>) :
    RecyclerView.Adapter<RoomAdapter.RoomViewHolder>(){

    class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRoomName: TextView = itemView.findViewById(R.id.tv_room_name)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_room_price)
        val tvPricePer: TextView = itemView.findViewById(R.id.tv_room_price_for_it)
        val fblPeculiarities: FlexboxLayout = itemView.findViewById(R.id.fbl_peculiarities)
        val cvPhoto: CardView = itemView.findViewById(R.id.cv_photo)
        val vp: ViewPager2 = cvPhoto.findViewById(R.id.view_pager)
        val tabDots: TabLayout = cvPhoto.findViewById(R.id.tab_dots)
        val mbChooseRoom: MaterialButton = itemView.findViewById(R.id.mb_choose_room)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false)
        return RoomViewHolder(view)
    }

    @SuppressLint("InflateParams")
    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.tvRoomName.text = rooms[position].name
        holder.tvPrice.text = rooms[position].price.toStringWithRubles()
        holder.tvPricePer.text = rooms[position].pricePer

        holder.fblPeculiarities
        val peculiarities = rooms[position].peculiarities
        for (i in peculiarities){
            val container: View = LayoutInflater.from(MAIN).inflate(R.layout.item_peculiarities, null)
            val tv: TextView = container.findViewById(R.id.tv_peculiarities)
            tv.text = i
            holder.fblPeculiarities.addView(container)
        }

        holder.mbChooseRoom.setOnClickListener {
            MAIN.navController.navigate(R.id.action_choiceOfHotelRoomFragment_to_bookingFragment)
        }

        holder.vp.adapter = PagerAdapterForImages(MAIN, rooms[position].imageUrls)
        TabLayoutMediator(holder.tabDots, holder.vp){_,_->}.attach()
    }

    override fun getItemCount(): Int {
        return rooms.size
    }
}