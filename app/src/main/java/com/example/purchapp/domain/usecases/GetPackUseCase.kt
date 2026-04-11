package com.example.purchapp.domain.usecases

import com.example.purchapp.domain.entities.Pack
import com.example.purchapp.domain.repositories.PackRepository
import javax.inject.Inject

class GetPackUseCase @Inject constructor(
    private val packRepository: PackRepository
) {
    suspend operator fun invoke(packId: String): Result<Pack> {
        return packRepository.getPack(packId)
    }
}