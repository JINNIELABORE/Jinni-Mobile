package br.senai.sp.jandira.model

data class Freelancer(
    val id: Int = 0,
    val nome_freelancer: String = "",
    val cpf_freelancer: String = "",
    val email_freelancer: String = "",
    val senha_freelancer: String = "",
    val data_nascimento: String = "",
    val is_premium: Int = 0,
    val foto_perfil: String = "",
    val descricao: String = "",
    val categorias: List<Categoria> = emptyList(),
    val habilidades: List<Habilidade> = emptyList(),
    val avaliacao: List<Avaliacao> = emptyList(),
    val portfolio: List<PortfolioItem> = emptyList(),
    val projetos_em_andamento: List<ProjetoFreelancer> = emptyList(),
    val projetos_finalizados: List<ProjetoFreelancer> = emptyList(),
    val solicitacoesPagamentos: List<SolicitacaoPagamento> = emptyList(),
    val quantidade_projetos: Int = 0,
    val quantidade_andamento: Int = 0,
    val quantidade_finalizados: Int = 0,
    val total_a_receber: Double = 0.0
)

data class Categoria(
    val id_categoria: Int = 0,
    val nome_categoria: String = "",
    val icon_categoria: String = ""
)

data class Habilidade(
    val id_habilidade: Int = 0,
    val nome_habilidade: String = "",
    val icon_habilidade: String = ""
)

data class Avaliacao(
    val id: Int = 0,
    val estrelas: Int = 0,
    val comentario: String = "",
    val id_avaliador: Int = 0,
    val nome_avaliador: String = "",
    val tipo_avaliador: String = ""
)

data class PortfolioItem(
    val id_portfolio: Int = 0,
    val arquivo: String = ""
)

data class ProjetoFreelancer(
    val id_projeto: Int = 0,
    val nome_projeto: String = ""
)

data class SolicitacaoPagamento(
    val id: Int = 0,
    val valor_solicitado: Double = 0.0,
    val banco: String = "",
    val agencia: String = "",
    val numero_conta: String = "",
    val tipo_conta: String = "",
    val nome_completo_titular: String = "",
    val cpf: String = "",
    val status_pago: Int = 0
)