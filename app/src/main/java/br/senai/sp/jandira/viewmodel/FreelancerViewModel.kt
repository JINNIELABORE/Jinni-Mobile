package br.senai.sp.jandira.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.senai.sp.jandira.model.Freelancer

class FreelancerViewModel: ViewModel() {

    var freelancerData = mutableStateOf(Freelancer())

    fun addBirthday(birthday: String) {

        freelancerData.value = freelancerData.value.copy(data_nascimento = birthday.toString())
    }

    fun setFreelancerData(name: String, cpf: String, email: String, password: String){


            freelancerData.value = freelancerData.value.copy(
                nome_freelancer = name,
                email_freelancer = email,
                senha_freelancer = password,
                cpf_freelancer = cpf
            )

    }



}