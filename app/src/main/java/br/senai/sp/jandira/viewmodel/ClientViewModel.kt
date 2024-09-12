package br.senai.sp.jandira.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.senai.sp.jandira.model.Client

class ClientViewModel : ViewModel() {
    // Dados do cliente que serão compartilhados entre as telas
    var clientData = mutableStateOf(Client())

    fun setClientData(name: String, email: String, password: String, confirmPassword: String) {
        if (password == confirmPassword) {
            clientData.value = clientData.value.copy(
                nome_cliente = name,
                email_cliente = email,
                senha_cliente = password
            )
        } else {
            // lógica para lidar com a confirmação de senha incorreta (ideia: inserir mensagem de erro)
        }
    }

    fun addCnpj(cnpj: String) {
        clientData.value = clientData.value.copy(cnpj_cliente = cnpj.toLongOrNull() ?: 0)
    }
}
