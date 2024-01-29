package com.mrducan.app.autotaskelf.domain

import com.mrducan.app.autotaskelf.data.repository.TasksRepository
import com.mrducan.app.autotaskelf.data.repository.UserDataRepository
import com.mrducan.app.autotaskelf.model.EnableTask
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val tasksRepository: TasksRepository,
    private val userDataRepository: UserDataRepository
){
    operator fun invoke(sortBy: TaskSortField = TaskSortField.NONE): Flow<List<EnableTask>> = combine(
        userDataRepository.userData,
        tasksRepository.getTasks(),
    ){ myUserData, tasks ->
        val enableTasks =tasks
            .map {
                EnableTask(
                    task = it,
                    isEnabled = it.id in myUserData.enabledTasks,
                )
            }
        when (sortBy){
            TaskSortField.NAME -> enableTasks.sortedBy { it.task.name }
            else ->enableTasks
        }
    }

}

enum class TaskSortField{
    NONE,
    NAME
}