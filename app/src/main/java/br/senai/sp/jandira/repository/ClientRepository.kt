package br.senai.sp.jandira.repository

import br.senai.sp.jandira.model.Client
import br.senai.sp.jandira.service.ClientService
import br.senai.sp.jandira.service.RetrofitFactory

class ClientRepository {

    private val clientService = RetrofitFactory().create(ClientService::class.java)

    fun postClient(client: Client):retrofit2.Call<Client>{
        return clientService.postClient(client)
    }

}