package com.example.ar_designer.data.repository

import com.example.ar_designer.data.models.MeshyResp
import com.example.ar_designer.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow

class NetworkRepositoryImpl : NetworkRepository {
    override suspend fun meshyModelReq(): Flow<List<MeshyResp>> {
        TODO("Not yet implemented")
    }
}