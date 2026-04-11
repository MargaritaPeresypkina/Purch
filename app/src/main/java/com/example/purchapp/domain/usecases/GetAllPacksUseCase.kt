package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.entities.Pack
import com.example.purchapp.domain.repositories.PackRepository
import javax.inject.Inject

class GetAllPacksUseCase @Inject constructor(
    private val packRepository: PackRepository
) {
    suspend operator fun invoke(): Result<List<Pack>> {
        return packRepository.getAllPacks()
    }
}