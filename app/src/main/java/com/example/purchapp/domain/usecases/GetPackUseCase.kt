package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.entities.Pack
import com.example.purchapp.domain.repositories.PackRepository

class GetPackUseCase (
    private val packRepository: PackRepository
) {
    suspend operator fun invoke(packId: String): Result<Pack> {
        return packRepository.getPack(packId)
    }
}