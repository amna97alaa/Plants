package com.amna.entities

data class BaseEntity<T>(
    val currentPage: Int,
    val `data`: T,
    val from: Int,
    val lastPage: Int,
    val perPage: Int,
    val to: Int,
    val total: Int
)
