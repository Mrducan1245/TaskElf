package com.mrducan.app.autotaskelf.model

data class Task(
    val id: String,
    val name: String,
    val description: String,
    val startTime: String,
    val repeatMode: RepeatMode,
    val repeatTimes: Int
)


enum class RepeatMode{
    ONCE,
    REPEAT
}