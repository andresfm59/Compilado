package com.example.compilado.domain.usecase

import com.example.compilado.domain.model.UserModel
import com.example.compilado.domain.repository.UserRepository
import retrofit2.Call
import javax.inject.Inject

class ExecuteUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(userModel: UserModel) = userRepository.createUser(userModel)
}