package com.richardson.rotaskotlin.model

class Rota {
    var origem = ""
    var destino = ""
    var custo = 0.0

    constructor(origem: String, destino: String, custo: Double) {
        this.origem = origem
        this.destino = destino
        this.custo = custo
    }

    override fun toString(): String {
        return "Rota(origem='$origem', destino='$destino', custo=$custo)"
    }
}