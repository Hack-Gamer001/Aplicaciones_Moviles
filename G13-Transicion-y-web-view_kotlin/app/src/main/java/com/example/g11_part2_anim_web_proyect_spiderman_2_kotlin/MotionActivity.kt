package com.example.g11_part2_anim_web_proyect_spiderman_2_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout

class MotionActivity : AppCompatActivity() {

    private lateinit var motionLayout: MotionLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion)

        motionLayout = findViewById(R.id.motionLayout1)

        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout, startId: Int, endId: Int) {
                // Código a ejecutar cuando comienza la transición
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                // Código a ejecutar durante la transición
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                if (currentId == R.id.end) {
                    val intent = Intent(this@MotionActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
                // Código a ejecutar cuando se alcanza un punto de disparo en la transición
            }
        })
    }
}
