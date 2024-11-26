package com.example.ar_designer.domain.repository

import com.example.ar_designer.data.models.MeshyResp
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {

    suspend fun meshyModelReq():Flow<List<MeshyResp>>

}