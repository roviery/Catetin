package com.roviery.catetin.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.roviery.core.domain.model.Deadline
import com.roviery.core.domain.usecase.DeadlineUseCase

class HomeViewModel(private val deadlineUseCase: DeadlineUseCase): ViewModel() {
    val listDeadline = deadlineUseCase.getAllDeadline().asLiveData()
    fun insertDeadline(deadline: Deadline) = deadlineUseCase.insertDeadline(deadline)
    fun deleteDeadline(deadline: Deadline) = deadlineUseCase.deleteDeadline(deadline)

}