package br.senai.sp.jandira.model

data class Projetos(
    val id: Int = 0,
    val id_cliente: Int = 0,
    val nome_cliente: String = "",
    val nome_projeto: String = "",
    val descricao_projeto: String = "",
    val orcamento: Double = 0.0,
    val nivel_experiencia: String = "",
    val is_premium: Int = 0,
    val categorias: List<Categoria> = emptyList(),
    val habilidades: List<Habilidade> = emptyList()
)

data class CategoriaProjeto(
    val nome_categoria: String = ""
)

data class HabilidadeProjeto(
    val nome_habilidade: String = ""
)
