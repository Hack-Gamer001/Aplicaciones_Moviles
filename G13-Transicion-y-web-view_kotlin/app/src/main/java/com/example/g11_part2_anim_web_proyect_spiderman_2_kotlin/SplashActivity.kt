package com.example.g11_part2_anim_web_proyect_spiderman_2_kotlin

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private var imageViewLogo: ImageView? = null
    private var imageViewLogo2: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)
        imageViewLogo = findViewById(R.id.imageViewlogo)
        imageViewLogo2 = findViewById(R.id.imageViewlogo2)

        // Agregar animaciones a los textos
        val animationUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        val animationDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        val textViewSistemas = findViewById<TextView>(R.id.textViewSistemas)
        val textView3de = findViewById<TextView>(R.id.textView3de)
        textViewSistemas.animation = animationUp
        textView3de.animation = animationDown

        // Animación de las imágenes en paralelo
        animateImagesInParallel(imageViewLogo, imageViewLogo2, 700, 2000)

        // Animación de las imágenes moviéndose de izquierda a derecha y de derecha a izquierda
        animateImagesLeftToRight(imageViewLogo, 2000)
        animateImagesRightToLeft(imageViewLogo2, 2000)
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MotionActivity::class.java)
            startActivity(intent)
            finish()
        }, 3200)
    }

    private fun animateImagesInParallel(
        imageView1: ImageView?,
        imageView2: ImageView?,
        targetHeight: Int,
        duration: Long
    ) {
        val animator1 = ValueAnimator.ofInt(0, targetHeight)
        val animator2 = ValueAnimator.ofInt(0, targetHeight)
        animator1.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            imageView1!!.layoutParams.height = value
            imageView1.requestLayout()
        }
        animator2.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            imageView2!!.layoutParams.height = value
            imageView2.requestLayout()
        }
        animator1.duration = duration
        animator2.duration = duration
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(animator1, animator2)
        animatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                imageView1!!.visibility = View.VISIBLE
                imageView2!!.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {
                // Aquí puedes realizar acciones al finalizar la animación si es necesario
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        animatorSet.start()
    }

    private fun animateImagesLeftToRight(imageView: ImageView?, duration: Long) {
        val animator = ObjectAnimator.ofFloat(imageView, "translationX", -1000f, 0f)
        animator.duration = duration
        animator.start()
    }

    private fun animateImagesRightToLeft(imageView: ImageView?, duration: Long) {
        val animator = ObjectAnimator.ofFloat(imageView, "translationX", 1000f, 0f)
        animator.duration = duration
        animator.start()
    }
}