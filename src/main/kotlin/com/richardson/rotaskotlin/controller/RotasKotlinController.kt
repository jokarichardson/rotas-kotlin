package com.richardson.rotaskotlin.controller

import com.richardson.rotaskotlin.service.RotasKotlinService
import com.richardson.rotaskotlin.util.ResponseUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Size


@RestController
@RequestMapping
class RotasKotlinController {

    @Autowired
    private lateinit var rotasKotlinService: RotasKotlinService

    @GetMapping("/rotas")
    fun listarRotas(): ResponseEntity<Any> {
        return try {
            ResponseEntity<Any>(this.rotasKotlinService.recuperarRotas(), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity<Any>(
                    ResponseUtils.criaResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name,
                            ex.message, ex.javaClass.simpleName, "/"),
                    HttpStatus.BAD_REQUEST)

        }
    }

    @GetMapping("/melhor-rota")
    fun recuperarRotaMaisBarata(@RequestParam @Size(max = 3, min = 3, message = "Origem deve ser informado e ter 3 caracteres. Ex: GRU") origem: String,
                                @RequestParam @Size(max = 3, min = 3, message = "Origem deve ser informado e ter 3 caracteres. Ex: GRU") destino: String): ResponseEntity<Any> {
        return try {
            ResponseEntity<Any>(this.rotasKotlinService.recuperarMelhorRota(origem, destino), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity<Any>(
                    ResponseUtils.criaResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name,
                            ex.message, ex.javaClass.simpleName, "/"),
                    HttpStatus.BAD_REQUEST)

        }
    }
}