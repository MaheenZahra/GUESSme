package com.example.guessme


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        //get text view
        val t = findViewById<View>(R.id.textResult) as TextView
        //val title1=findViewById<TextView>(R.id.title1)
        val score6Result: String =
            getString(R.string.score6result) // if user selects all "a" opt and total score is then 6 as each opt a increment +1 SCORE and then display this string defined in string.xml
        val score18Result: String = getString(R.string.score18result)
        val score22Result: String = getString(R.string.score22result)
        val score30Result: String = getString(R.string.score30result)
        val score38Result: String = getString(R.string.score38result)
        val score42Result: String = getString(R.string.score42result)
        val score46Result: String = getString(R.string.score46result)

        val score54Result: String = getString(R.string.score54result)
        val default6Result: String = getString(R.string.defaultResult)

        //get score
        val b = intent.extras
        val score = b!!.getInt("score")
        val yourName = b.getString("nsme")


        button_Replay.setOnClickListener()
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        button_Share.setOnClickListener() {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Hey Check out this Great app:")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))

        }

        if (score <= 6) {
            title1.text = "Old Soul"
            t.text = score6Result
        } else if (score <= 18) {
            title1.text = "Introvert"
            t.text = score18Result
        } else if (score <= 22) {
            title1.text = "Chill Pill"
            t.text = score22Result
        } else if (score <= 30) {
            title1.text = "Artistic Mind"
            t.text = score30Result
        } else if (score <= 38) {
            title1.text = "Meditator"
            t.text = score38Result
        } else if (score <= 42) {
            title1.text = "Dark Horse"
            t.text = score42Result
        } else if (score <= 46) {
            title1.text = "Caring Bird"
            t.text = score46Result
        } else if (score <= 54) {
            title1.text = "Lazy "
            t.text = score54Result
        } else {
            title1.text = "Broken Angel"
            t.text = default6Result
        }


    }
}