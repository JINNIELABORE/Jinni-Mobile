package br.senai.sp.jandira.model

data class Freelancer(

    val id: Int = 0,
    val nome_freelancer: String = "",
    val cpf_freelancer: String = "", // String, pois pode iniciar com 0
    val email_freelancer: String = "",
    val senha_freelancer: String = "",
    val data_nascimento: String = ""

)
