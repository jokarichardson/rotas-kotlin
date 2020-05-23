package com.richardson.rotaskotlin.service

import com.richardson.rotaskotlin.logic.SeletorRotas
import com.richardson.rotaskotlin.model.Rota
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class RotasKotlinService {
    @Autowired
    private val seletorRotas: SeletorRotas = SeletorRotas()

    fun recuperarRotas(): List<Rota>? {
        return seletorRotas.recuperarRotas()
    }

    fun recuperarMelhorRota(origem: String, destino: String): String {
        return seletorRotas.recuperarRotaMaisBarata(origem, destino)
    }
}