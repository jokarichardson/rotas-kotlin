package com.richardson.rotaskotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView
import springfox.documentation.annotations.ApiIgnore

@RestController
@RequestMapping("/")
@ApiIgnore
class HomeController {
    @GetMapping("/swagger")
    fun swaggerRoute(): RedirectView? {
        return RedirectView("/swagger-ui.html#")
    }

    @GetMapping()
    fun redirectToSwagger(): RedirectView? {
        return RedirectView("/swagger-ui.html#")
    }
}