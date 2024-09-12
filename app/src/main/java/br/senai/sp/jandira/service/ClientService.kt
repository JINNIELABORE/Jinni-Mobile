package br.senai.sp.jandira.service

import br.senai.sp.jandira.model.Client
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ClientService {

    @Headers("Content-Type: application/json")
    @POST("v1/jinni/cliente")

    fun postClient(@Body client: Client): Call<Client>

}
