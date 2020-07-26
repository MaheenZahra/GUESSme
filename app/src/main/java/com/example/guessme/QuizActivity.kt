package com.example.guessme

import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_quiz2.*


class QuizActivity : AppCompatActivity() {
    lateinit var quesList: List<Question>
    var score = 0
    var qid = 0
    lateinit  var currentQ: Question
    lateinit  var txtQuestion: TextView
    lateinit  var rda: RadioButton
    lateinit  var rdb: RadioButton
    lateinit  var rdc: RadioButton
    lateinit  var butNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz2)
        val db = DbHelper(this)
        quesList = db.allQuestions
        currentQ = quesList[qid]
        txtQuestion = findViewById<View>(R.id.textView1) as TextView
        rda = findViewById<View>(R.id.radio0) as RadioButton
        rdb = findViewById<View>(R.id.radio1) as RadioButton
        rdc = findViewById<View>(R.id.radio2) as RadioButton
        butNext = findViewById<View>(R.id.button1) as Button
        setQuestionView()
        val intent= intent
        val yourName :String?= intent.getStringExtra("name")
        receivedName.text=" Hi " + yourName

        butNext.setOnClickListener {
            val grp = findViewById<View>(R.id.radioGroup1) as RadioGroup
            val answer = findViewById<View>(grp.checkedRadioButtonId) as RadioButton
            grp.clearCheck()
            Log.d("yourans", " "+ " " + answer.text)
            if (answer.text==currentQ.opta) {
                score+=1
                Log.d("score", "Your score$score")
            }
            else  if (answer.text==currentQ.optb) {
                score+=5
                Log.d("score", "Your score$score")
            }
            else  if (answer.text==currentQ.optc) {
                score+=9
                Log.d("score", "Your score$score")
            }
            if (qid < 6) {
                currentQ = quesList[qid]
                setQuestionView()
            } else {
                val intent = Intent(this@QuizActivity, ResultActivity::class.java)
                val b = Bundle()
                b.putInt("score", score) //Your score
                b.putString("name",yourName)
                intent.putExtras(b) //Put your score to your next Intent
                startActivity(intent)
                finish()
            }
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_quiz, menu)
        return true
    } */

    private fun setQuestionView() {
        txtQuestion.text = currentQ.question
        rda.text = currentQ.opta
        rdb.text = currentQ.optb
        rdc.text = currentQ.optc
        qid++
    }
}