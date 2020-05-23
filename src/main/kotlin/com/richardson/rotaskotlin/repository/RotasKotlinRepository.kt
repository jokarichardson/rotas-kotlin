package com.richardson.rotaskotlin.repository

import com.richardson.rotaskotlin.model.Rota
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import javax.annotation.PostConstruct

@Component
class RotasKotlinRepository {
    private val rotas = mutableListOf<Rota>()

    @PostConstruct
    private fun init() {
        rotas.add(Rota("GRU", "BRC", 10.0))
        rotas.add(Rota("BRC", "SCL", 5.0))
        rotas.add(Rota("GRU", "CDG", 75.0))
        rotas.add(Rota("GRU", "SCL", 20.0))
        rotas.add(Rota("GRU", "ORL", 56.0))
        rotas.add(Rota("ORL", "CDG", 8.0))
        rotas.add(Rota("SCL", "ORL", 20.0))
        rotas.add(Rota("BRC", "CDG", 35.0))
    }

    fun getRotas() = this.rotas
}