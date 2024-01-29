package com.mrducan.app.autotaskelf.model

data class MyUserData(
    val savedTasks: Set<String>,
    val enabledTasks: Set<String>
)