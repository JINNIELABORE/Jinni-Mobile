package br.senai.sp.jandira.service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "http://localhost:8080/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createClientService(): ClientService {
        return retrofitFactory.create(ClientService::class.java)
    }
}
