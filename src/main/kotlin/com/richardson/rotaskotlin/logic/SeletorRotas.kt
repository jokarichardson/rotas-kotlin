package com.richardson.rotaskotlin.logic

import com.richardson.rotaskotlin.exception.RotasKotlinException
import com.richardson.rotaskotlin.model.Rota
import com.richardson.rotaskotlin.repository.RotasKotlinRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.util.CollectionUtils
import java.util.HashMap
import java.util.function.Consumer
import java.util.stream.Collectors


@Component
class SeletorRotas {
    private val separadorRotas = " - "
    private var mapaRotas: MutableMap<String, Map<String, Int>> = HashMap()
    private var rotasEncontradas: MutableMap<Int, String> = HashMap()

    private var custo = 0
    private val sbRota = StringBuilder()

    @Autowired
    private lateinit var rotasKotlinRepository: RotasKotlinRepository

    fun recuperarRotas(): List<Rota> {
        if (CollectionUtils.isEmpty(this.rotasKotlinRepository.getRotas()))
            throw RotasKotlinException("Lista de rotas está vazia")

        return this.rotasKotlinRepository.getRotas()
    }

    fun recuperarRotaMaisBarata(origem: String, destino: String): String {
        if (CollectionUtils.isEmpty(this.rotasKotlinRepository.getRotas()))
            throw RotasKotlinException("Lista de rotas está vazia")

        this.montarMapaRotas()
        this.avaliarOrigem(origem)
        this.caminharMapa(origem.toUpperCase(), destino.toUpperCase());
        this.ordenarRotasEncontradas();

        val retorno: String
        this.sbRota.delete(0, this.sbRota.length)

        if (this.rotasEncontradas.entries.iterator().hasNext()) {
            retorno = this.rotasEncontradas.entries.iterator().next().value
            this.rotasEncontradas.clear()
        } else throw RotasKotlinException("Nao ha rotas entre origem e destino informados.")

        return retorno
    }

    private fun montarMapaRotas() {
        val origens: MutableSet<String> = HashSet()

        this.rotasKotlinRepository.getRotas().forEach(Consumer { rota: Rota -> origens.add(rota.origem.toUpperCase()) })

        origens.forEach(Consumer { o: String? ->
            val destinos: MutableMap<String, Int> = HashMap()
            val destinosPorOrigem: MutableList<Rota>? = this.rotasKotlinRepository.getRotas().stream().filter { r: Rota -> r.origem.equals(o, ignoreCase = true) }
                    .collect(Collectors.toList())
            destinosPorOrigem?.forEach(Consumer { d: Rota -> destinos[d.destino.toUpperCase()] = d.custo.toInt() })
            this.mapaRotas[o.toString()] = destinos
        })
    }

    private fun avaliarOrigem(origem: String) {
        if (!this.mapaRotas.containsKey(origem)) throw RotasKotlinException("Nao ha rotas com a origem informada.")
    }

    private fun caminharMapa(origem: String, destino: String) {
        val destinos: Map<String, Int> = this.mapaRotas.getValue(origem)
        if (!CollectionUtils.isEmpty(destinos)) {
            this.sbRota.append(origem + this.separadorRotas)
        } else {
            this.custo = Integer.valueOf(0)
            return
        }
        for ((key, value) in destinos!!) {
            this.custo += value
            if (key.equals(destino, ignoreCase = true)) {
                this.rotasEncontradas[this.custo] = this.sbRota.toString() + destino
                this.custo -= value
            } else {
                caminharMapa(key, destino)
            }
        }
        this.sbRota.delete(6, this.sbRota.length)
        this.custo = 0
    }

    private fun ordenarRotasEncontradas() {
        this.rotasEncontradas = this.rotasEncontradas.toSortedMap()
    }
}