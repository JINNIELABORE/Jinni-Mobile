package br.senai.sp.jandira.service

import br.senai.sp.jandira.model.Freelancer
import br.senai.sp.jandira.model.Results
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface FreelancerService {

    @Headers("Content-Type: application/json")
    @POST("v1/jinni/freelancer")
    fun postFreelancer(@Body freelancer: Freelancer): Call<Freelancer>

    @GET("v1/jinni/freelancers")
    fun getFreelancer(): Call<Results>

    @GET("v1/jinni/nome/freelancer")
    fun getFreelancerByEmail(@Query("email") email: String): Call<Freelancer>

}