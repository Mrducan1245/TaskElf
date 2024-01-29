package com.mrducan.app.autotaskelf.data.repository

import com.mrducan.app.autotaskelf.model.Task
import kotlinx.coroutines.flow.Flow

interface TasksRepository{
    fun getTasks():Flow<List<Task>>

    fun getTask(id: String): Flow<Task>

}