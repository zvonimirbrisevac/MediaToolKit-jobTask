package com.mkt.ipaddressresolver.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.util.MimeTypeUtils
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig(
    @Value("\${ip-resolver-api.base-url}") val baseUrl: String
) {

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl(baseUrl)
            .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
            .build()
    }

    private fun acceptedCodecs(clientCodecConfigurer: ClientCodecConfigurer) {
        clientCodecConfigurer.customCodecs().encoder(Jackson2JsonEncoder(ObjectMapper(), MimeTypeUtils.TEXT_HTML))
        clientCodecConfigurer.customCodecs().decoder(Jackson2JsonDecoder(ObjectMapper(), MimeTypeUtils.TEXT_HTML))
    }
}
