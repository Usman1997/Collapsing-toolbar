package com.example.collapsabletoolbar

import android.animation.ArgbEvaluator
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity:AppCompatActivity(),MotionLayout.TransitionListener {
    var motionLayout: MotionLayout? = null
    var recyclerView: RecyclerView? = null
    var layout = R.layout.collapsing_toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme()
        setContentView(R.layout.collapsing_toolbar)
        initViews()
        recyclerView!!.apply {
            setHasFixedSize(true)
            adapter = DummyListAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity) as RecyclerView.LayoutManager?
        }
        motionLayout!!.transitionToEnd()
        Handler().postDelayed({motionLayout!!.apply{
            transitionToStart()
            setTransitionListener(this@MainActivity)
        }}, 150)
    }

    private fun setTheme() {
        setTheme(R.style.LightTheme)
    }

    private fun initViews() {
        motionLayout = findViewById(R.id.motionLayout)
        recyclerView = findViewById(R.id.recyclerView)
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
    }

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
        if (p0 == null)
            return
    }
}