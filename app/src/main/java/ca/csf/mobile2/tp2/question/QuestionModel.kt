package ca.csf.mobile2.tp2.question

import java.util.*

data class QuestionModel(val id: UUID, val text: String, val choice1: String, val choice2: String, val nbChoice1: Int, val nbChoice2: Int) {

}