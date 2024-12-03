package br.senai.sp.jandira.model

data class Client(
    val id: Int = 0,
    val nome_cliente: String = "",
    val cnpj_cliente: Long = 0,
    val email_cliente: String = "",
    val senha_cliente: String = "",
    val foto_perfil: String = "",
    val descricao_cliente: String = "",
    val is_premium: Int = 0,
    val avaliacao: List<Any> = emptyList(),
    val projetos: List<Projeto> = emptyList(),
    val freelancers: Map<String, Any> = emptyMap(),
    val quantidade_freelancers: Int = 0
)

data class Projeto(
    val id_projeto: Int = 0,
    val nome_projeto: String = "",
    val descricao_projeto: String = "",
    val orcamento: Double = 0.0,
    val nome_experiencia: String = ""
)

