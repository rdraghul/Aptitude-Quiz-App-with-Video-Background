package com.example.videocam

import android.annotation.SuppressLint
import android.util.Log

class Mcq{
    var Question : String
    var Options : Array<String> = Array<String>(size = 4){""}
    var Answer : Int
    var HardnessLevel : Int

    constructor(Question : String, Answer : Int, op1 : String, op2 : String, op3 : String, op4 : String, HardnessLevel : Int){
        this.Question = Question
        this.Answer = Answer
        this.Options[0] = op1
        this.Options[1] = op2
        this.Options[2] = op3
        this.Options[3] = op4
        this.HardnessLevel = HardnessLevel
    }
}

@SuppressLint("SuspiciousIndentation")
fun codeForTask(mcqArrayLevel1: MutableList<Mcq>): List<String> {
    return listOf(mcqArrayLevel1[0].Options[0], mcqArrayLevel1[0].Options[1], mcqArrayLevel1[0].Options[2], mcqArrayLevel1[0].Options[3] , mcqArrayLevel1[0].Question)
}