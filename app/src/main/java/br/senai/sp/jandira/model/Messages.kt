package br.senai.sp.jandira.model

data class Messages(
    var text: String?=null,
    var isOut: Boolean = false
)

val message_dummy = listOf(

    Messages(text = "olá", isOut = true),
    Messages(text = "tudo bem?", isOut = true),
    Messages(text = "oi", isOut = false),
    Messages(text = "tudo e vc?", isOut = false),
    Messages(text = "to bem tbm", isOut = true),
    Messages(text = "faz oq no curso de ds?", isOut = true),
    Messages(text = "nada, to mttt estressado hj", isOut = false),
    Messages(text = "que peninha", isOut = true),
    Messages(text = "vdd, mas faltam só alguns dias pro curso acabar, graças a deus!!", isOut = false),
    Messages(text = "simsim, o meu curso também falta pouquinho para acabar, to quase me mantado", isOut = true),
    Messages(text = "não termina logo, não aguento maissssss", isOut = true),
    Messages(text = "não fale assim, e pensa que daqui alguns dias estaremos de férias", isOut = false),
    Messages(text = "Que férias??? É DESEMPREGO JÁ!!!", isOut = true)
)
