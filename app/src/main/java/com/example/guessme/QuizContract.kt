package com.example.guessme

import android.provider.BaseColumns

class QuizContract {
    class MovieEntry : BaseColumns {
        companion object {
            val TABLE_QUEST = "quest"
            // tasks Table Columns names
            val KEY_ID = "id"
            val KEY_QUES = "question"
            val KEY_OPTA = "opta" //option a
            val KEY_OPTB = "optb" //option b
            val KEY_OPTC = "optc" //option c
        }
    }
}