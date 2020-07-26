package com.example.guessme

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import com.example.guessme.QuizContract.MovieEntry.Companion.TABLE_QUEST
import com.example.guessme.QuizContract.MovieEntry.Companion.KEY_ID
import com.example.guessme.QuizContract.MovieEntry.Companion.KEY_OPTA
import com.example.guessme.QuizContract.MovieEntry.Companion.KEY_OPTB
import com.example.guessme.QuizContract.MovieEntry.Companion.KEY_OPTC
import com.example.guessme.QuizContract.MovieEntry.Companion.KEY_QUES
import java.util.*


class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // tasks table name

    private var dbase: SQLiteDatabase? = null
    // Select All Query
    // looping through all rows and adding to list
    // return quest list
    val allQuestions: List<Question>
        get() {
            val quesList = ArrayList<Question>()
            val selectQuery = "SELECT  * FROM $TABLE_QUEST"
            dbase = this.readableDatabase
            val cursor = dbase!!.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val quest = Question()
                    quest.id = cursor.getInt(0)
                    quest.question = cursor.getString(1)
                    quest.opta = cursor.getString(2)
                    quest.optb = cursor.getString(3)
                    quest.optc = cursor.getString(4)
                    quesList.add(quest)
                } while (cursor.moveToNext())
                quesList.shuffle()
            }
            return quesList

        }

    override fun onCreate(db: SQLiteDatabase) {
        dbase = db
        val sql = ("CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)")
        db.execSQL(sql)
        addQuestions()
        //db.close();
    }

    private fun addQuestions() {
        val q1 = Question("How would you describe yourself?",
            " Observant",
            " Recreational",
            " Adventurous")
        this.addQuestion(q1)

        val q2 = Question("If you could change the world, what would you change?",
            " Technology, as its ruining our life more than doing good",
            " People's mindset! as there is too much negativity all around ",
            " Nothing, I don't have time to waste on changing things around. I am rather busy in my life")
        this.addQuestion(q2)
        val q3 = Question( "Do you prefer working alone, or do you like working with others?",
            " Alone",
            " Working with others",
            " I don't like to work")
        this.addQuestion(q3)
        val q4 = Question("What is the first thing you notice about a person?",
            " Face obviously, beauty does matter as well a person's facial expressions tells you a lot about person",
            " Standing Posture, that depicts how confident one is",
            " Their dress, one must look presentable as first impression is the last impression")
        this.addQuestion(q4)
        val q5 = Question("If You Could Pick Any Animal To Talk, Which Would It Be?",
            "Dog",
            "Cat",
            "Panda")
        this.addQuestion(q5)
        val q6 = Question("What would you prefer?",
            "Fruits, Cycling, Hangout with friends",
            "Junk food, Watching Movie, Sleeping",
            "Tea, Money, Reading")
        this.addQuestion(q6)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldV: Int, newV: Int) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS $TABLE_QUEST")
        // Create tables again
        onCreate(db)
    }

    // Adding new question
    fun addQuestion(quest: Question) {
        //SQLiteDatabase db = this.getWritableDatabase();
        val values = ContentValues()
        values.put(KEY_QUES, quest.question)
        values.put(KEY_OPTA, quest.opta)
        values.put(KEY_OPTB, quest.optb)
        values.put(KEY_OPTC, quest.optc)
        // Inserting Row
        dbase!!.insert(TABLE_QUEST, null, values)
    }

    fun rowcount(): Int {
        var row = 0
        val selectQuery = "SELECT  * FROM $TABLE_QUEST"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        row = cursor.count
        return row
    }

    companion object {
        private val DATABASE_VERSION = 1
        // Database Name
        private val DATABASE_NAME = "personalityQuiz"
    }
}