package com.app.latihan_jetpack.service.api

import com.app.latihan_jetpack.model.request.LoginRequest
import com.app.latihan_jetpack.model.request.RegisterRequest
import com.app.latihan_jetpack.model.response.LoginResponse
import com.app.latihan_jetpack.model.response.NotesResponse
import com.app.latihan_jetpack.model.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("api/register")
    suspend fun register(@Body request: RegisterRequest):
            Response<RegisterResponse>
    @POST("/api/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("/api/notes")
    suspend fun getAllNotes(): NotesResponse

}