package com.example.guessme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.widget.ProgressBar

class SplashActivity : AppCompatActivity() {
    private var progressBarStatus = 0
    var dummy:Int = 0
    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,MainActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
        // get the references from layout file
        val progressBar= findViewById<ProgressBar>(R.id.progressBar1)



            // task is run on a thread
            Thread(Runnable {
                // dummy thread mimicking some operation whose progress can be tracked
                while (progressBarStatus < 100) {
                    // performing some dummy operation
                    try {
                        dummy = dummy+25
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    // tracking progress
                    progressBarStatus = dummy

                    // Updating the progress bar
                    progressBar.progress = progressBarStatus
                }

            }).start()
        }
    }





