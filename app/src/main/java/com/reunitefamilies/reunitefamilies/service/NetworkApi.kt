package com.reunitefamilies.reunitefamilies.service

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET

interface NetworkApi {

    companion object {
        fun create() : NetworkApi {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .build()
                    .create(NetworkApi::class.java)
        }

    }

    @GET("register")
    fun register(@Body requestBody: RegisterRequestBody) : Observable<String>

    @GET("login")
    fun login(@Body requestBody: LoginRequestBody) : Observable<String>

    @GET("current-user")
    fun currentUser() : Observable<String>
}