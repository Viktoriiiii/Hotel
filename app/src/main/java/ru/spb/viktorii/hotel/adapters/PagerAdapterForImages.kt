package ru.spb.viktorii.hotel.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.spb.viktorii.hotel.R

class PagerAdapterForImages(private val context: Context, private val resources: List<String>):
    RecyclerView.Adapter<PagerAdapterForImages.PagerViewHolder>() {

    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView: ImageView
        var container: LinearLayout

        init {
            imgView = itemView.findViewById(R.id.imageView) as ImageView
            container = itemView.findViewById(R.id.container) as LinearLayout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder((LayoutInflater.from(context).inflate(R.layout.item_pager, parent, false)))
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        Glide.with(context)
            .load(resources[position])
            .into(holder.imgView)
    }

    override fun getItemCount(): Int {
        return resources.size
    }
}