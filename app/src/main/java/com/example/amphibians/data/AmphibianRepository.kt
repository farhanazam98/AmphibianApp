package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApi

interface AmphibianRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibianRepository: AmphibianRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return AmphibianApi.retrofitService.getAmphibians()
    }
}
