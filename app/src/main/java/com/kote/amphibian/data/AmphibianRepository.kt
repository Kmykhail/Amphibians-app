package com.kote.amphibian.data

import com.kote.amphibian.model.Amphibian
import com.kote.amphibian.network.AmphibianApiService

interface AmphibianRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibianRepository(private val amphibianApiService: AmphibianApiService) : AmphibianRepository {
    override suspend fun getAmphibians(): List<Amphibian> = amphibianApiService.getAmphibians()
}