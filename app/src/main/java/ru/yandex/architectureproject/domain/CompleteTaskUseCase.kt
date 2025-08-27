package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository

private const val DELETE_TASK_DELAY_MILLIS = 2_000L
class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(DELETE_TASK_DELAY_MILLIS)
        repository.deleteTask(taskId)
    }
}
