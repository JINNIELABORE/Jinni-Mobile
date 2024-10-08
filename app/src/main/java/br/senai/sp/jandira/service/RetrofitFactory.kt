package br.senai.sp.jandira.service

import br.senai.sp.jandira.model.Client
import br.senai.sp.jandira.model.Freelancer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "https://jinni.onrender.com/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createClientService(): ClientService {
        return retrofitFactory.create(ClientService::class.java)
    }


    fun createFreelancerService(): FreelancerService {
        return retrofitFactory.create(FreelancerService::class.java)
    }

}
