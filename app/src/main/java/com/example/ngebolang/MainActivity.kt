package com.example.ngebolang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var app_splash : Animation
    private lateinit var btt : Animation
    private lateinit var handler: Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.splash_bg)
        btt = AnimationUtils.loadAnimation(this, R.anim.btt)
        //load element
        val app_logo = findViewById<ImageView>(R.id.imgsplash)
        val app_subtitle = findViewById<ImageView>(R.id.imgsubtitle)

        app_logo.startAnimation(app_splash)
        app_subtitle.startAnimation(btt)

        // Membuat handler
        handler = Handler()
        //setting timer untuk 1 detik auto Intent ke GetStartedActivity
        handler.postDelayed({
            intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 2000 Millis -> 2 Detik
    }
}
