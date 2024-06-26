package com.example.compilado.domain.usecase

import com.example.compilado.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke() = repository.getUsers()
}