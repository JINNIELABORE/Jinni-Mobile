package br.senai.sp.jandira.model

data class Login(
    val email_cliente:String?,
    val senha_cliente:String?,
    val email_freelancer:String?,
    val senha_freelancer: String?
)
