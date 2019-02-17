package pl.piomin.services.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class ConfigApplication

fun main(args: Array<String>) {
    runApplication<ConfigApplication>(*args)
}