package com.example.guessme

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_info.*
import java.util.*

class UserInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        val mPickDateBirth = findViewById<ImageView>(R.id.pickDate)
        val dateText = findViewById<EditText>(R.id.DOB)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        var user_name: String
        var dob: String

        mPickDateBirth.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView

                dateText.setText("" + dayOfMonth + " " + (month+1) + ", " + year)
            }, year, month, day)
            dpd.show()

        }
        buttonNext.setOnClickListener(){
            user_name= username.text.toString().trim()
            dob= DOB.text.toString().trim()
            if(user_name.isEmpty()||dob.isEmpty())
            {
             Toast.makeText(this," These fields can't be left empty", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("name", user_name)
                startActivity(intent)
            }
        }



    }
}
