package com.example.guessme



class Question {

    var id: Int = 0
    var question: String? = null
    var opta: String? = null
    var optb: String? = null
    var optc: String? = null

    constructor() {
        id = 0
        question = ""
        opta = ""
        optb = ""
        optc = ""

    }

    constructor(qUESTION: String, oPTA: String, oPTB: String, oPTC: String) {

        question = qUESTION
        opta = oPTA
        optb = oPTB
        optc = oPTC


    }
}