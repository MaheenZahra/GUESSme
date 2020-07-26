package com.example.guessme

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custompopup.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         button_start.setOnClickListener {
             val intent = Intent(this, UserInfoActivity::class.java)
             startActivity(intent)
         }

        aboutbutton.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)}

            button_howToPlay.setOnClickListener {
               val howPlayDialogue= LayoutInflater.from(this).inflate(R.layout.custompopup,null)
                val mbuilder=AlertDialog.Builder(this).setView(howPlayDialogue)
                val howPlayAlert=mbuilder.show()

                howPlayDialogue.textclose.setOnClickListener {
                    howPlayAlert.dismiss()
                }

            }


        }


        }






