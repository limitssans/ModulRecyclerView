package com.example.myrecyclerview

import Hero
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter (val listHeroes: ArrayList<Hero>)
    : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class GridViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)




    }

    override fun onCreateViewHolder(viewGroup: ViewGroup,i:Int): GridViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_hero, viewGroup, false)

        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listHeroes[position].photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHeroes[holder.adapterPosition]) }

    }


    override fun getItemCount(): Int {

        return listHeroes.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }

}