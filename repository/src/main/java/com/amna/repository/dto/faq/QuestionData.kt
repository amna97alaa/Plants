package com.amna.repository.dto.faq


import com.google.gson.annotations.SerializedName

data class QuestionData<T>(
    @SerializedName("answer")
    val answer: String?,
    @SerializedName("default_image")
    val questionImage: List<QuestionImage?>,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("question")
    val question: String?,
    @SerializedName("tags")
    val tags: List<String?>?
)