package com.amna.repository.mappers

import com.amna.entities.Question
import com.amna.repository.dto.faq.QuestionData
import com.amna.repository.dto.faq.QuestionImage

fun QuestionData<QuestionImage>.toQuestion(): Question {
    return Question(
        answer = answer ?: "",
        id = id ?: 0,
        question = question ?: "",
        tags = tags ?: emptyList(),
        questionImage = questionImage.map {
            Question.QuestionImage(
                it?.licenseName ?: "",
                it?.licenseUrl ?: "",
                it?.mediumUrl ?: "",
                it?.originalUrl ?: "",
                it?.regularUrl ?: ""
            )
        }
    )
}