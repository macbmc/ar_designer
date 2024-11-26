package com.example.ar_designer.data.network

import com.example.ar_designer.data.models.MeshyTaskID
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST
    suspend fun meshyModelReq(): MeshyTaskID
}