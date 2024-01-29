package com.mrducan.app.autotaskelf.data.repository

import com.mrducan.app.autotaskelf.model.MyUserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository{
    val userData: Flow<MyUserData>
    suspend fun setEnabledTaskIds(enabledTaskIds: Set<String>)
    suspend fun setTaskIdEnabled(enabledTaskId: String, enabled: Boolean)
}