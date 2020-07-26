package com.example.guessme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AboutUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        var btnRestart = findViewById(R.id.button4) as Button


        btnRestart.setOnClickListener(View.OnClickListener {
            val in2 = Intent(this, MainActivity::class.java)
            startActivity(in2)
        })
    }
}
