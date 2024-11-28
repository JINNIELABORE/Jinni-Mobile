package br.senai.sp.jandira.service

import br.senai.sp.jandira.model.Client
import br.senai.sp.jandira.model.ResultLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ClientService {

    @Headers("Content-Type: application/json")

    @POST("v1/jinni/cliente")
    fun postClient(@Body client: Client): Call<Client>

    @GET("v1/jinni/clientes")
    fun getClient(): Call<List<Client>>

    @GET("v1/jinni/nome/cliente")
    fun getClientByEmail(@Query("emailDigitado") emailDigitado: String): Call<ResultLogin>

}
