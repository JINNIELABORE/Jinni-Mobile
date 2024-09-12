package br.senai.sp.jandira.model

data class Client(
    val id: Int = 0,
    val nome_cliente: String = "",
    val cnpj_cliente: Long = 0,
    val email_cliente: String = "",
    val senha_cliente: String = ""
)
