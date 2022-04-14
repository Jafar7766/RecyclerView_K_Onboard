package com.example.recyclerview_k_onboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

class RecyclerAdapter(var context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var view: View? = null
    var lottieAnimationView: LottieAnimationView? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(context).inflate(R.layout.rv_layout, parent, false)
        val lottieAnimationView: LottieAnimationView = view!!.findViewById(R.id.lottie)
        return ViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.position_tv.text = "Choose Your Product " + position
    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var position_tv: TextView

        init {
            position_tv = itemView.findViewById(R.id.position_tv)
        }
    }
}