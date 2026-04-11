package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.entities.Pack
import com.example.purchapp.domain.repositories.PackRepository

class GetAllPacksUseCase(
    private val packRepository: PackRepository
) {
    suspend operator fun invoke(): Result<List<Pack>> {
        return packRepository.getAllPacks()
    }
}