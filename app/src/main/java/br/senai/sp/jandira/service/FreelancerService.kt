package br.senai.sp.jandira.service

import br.senai.sp.jandira.model.Freelancer
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface FreelancerService {

    @Headers("Content-Type: application/json")
    @POST("v1/jinni/freelancer")
    @GET("v1/jinni/freelancers")

    fun postFreelancer(@Body freelancer: Freelancer): Call<Freelancer>
    fun getFreelancer(): Call<Freelancer>

}