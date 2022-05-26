package com.mkt.ipaddressresolver

import com.fasterxml.jackson.databind.ObjectMapper
import com.mkt.ipaddressresolver.services.ResolverService
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockserver.client.MockServerClient
import org.mockserver.springtest.MockServerTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@MockServerTest
@AutoConfigureMockMvc
class IpAddressResolverApplicationTests @Autowired constructor(
) {



	@Test
	fun contextLoads() {
	}

}
