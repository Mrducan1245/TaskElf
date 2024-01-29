package com.mrducan.app.autotaskelf.feature.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrducan.app.autotaskelf.data.repository.UserDataRepository
import com.mrducan.app.autotaskelf.domain.GetAllTasksUseCase
import com.mrducan.app.autotaskelf.domain.TaskSortField
import com.mrducan.app.autotaskelf.model.EnableTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@Suppress("UNCHECKED_CAST")
@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
    getAllTasksUseCase : GetAllTasksUseCase
): ViewModel(){

    val uiState: StateFlow<TaskListUiState> =
        getAllTasksUseCase(sortBy = TaskSortField.NAME).map {
            TaskListUiState::TaskList
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TaskListUiState.Loading,
        ) as StateFlow<TaskListUiState>

    fun setTaskEnabled(taskId: String, enabled: Boolean){
        viewModelScope.launch {
            userDataRepository.setTaskIdEnabled(taskId,enabled)
        }
    }
}

sealed interface TaskListUiState{
    data object Loading: TaskListUiState
    data class TaskList(
        val tasks: List<EnableTask>
    ): TaskListUiState
    data object Empty: TaskListUiState
}