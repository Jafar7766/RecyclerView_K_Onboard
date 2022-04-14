package com.example.recyclerview_k_onboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    var recycler_view: RecyclerView? = null
    var recyclerAdapter: RecyclerAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view = findViewById(R.id.recycler_view)
        setRv()
    }

    private fun setRv() {
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view!!.layoutManager = layoutManager
        recyclerAdapter = RecyclerAdapter(this)
        recycler_view!!.adapter = recyclerAdapter
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recycler_view)
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                if (layoutManager!!.findLastCompletelyVisibleItemPosition() < recyclerAdapter!!.itemCount - 1) {
                    layoutManager!!.smoothScrollToPosition(
                        recycler_view,
                        RecyclerView.State(),
                        layoutManager!!.findFirstCompletelyVisibleItemPosition() + 1
                    )
                } else if (layoutManager!!.findLastCompletelyVisibleItemPosition() < recyclerAdapter!!.itemCount - 1) {
                    layoutManager!!.smoothScrollToPosition(recycler_view, RecyclerView.State(), 0)
                }
            }
        }, 0, 5500)
    }
}