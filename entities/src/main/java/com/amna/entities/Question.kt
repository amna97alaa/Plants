package com.amna.entities

data class Question (
    val answer: String,
    val questionImage: List<QuestionImage>,
    val id: Int,
    val question: String,
    val tags: List<String?>
) {
    data class QuestionImage(
        val licenseName: String,
        val licenseUrl: String,
        val mediumUrl: String,
        val originalUrl: String,
        val regularUrl: String
    )
}