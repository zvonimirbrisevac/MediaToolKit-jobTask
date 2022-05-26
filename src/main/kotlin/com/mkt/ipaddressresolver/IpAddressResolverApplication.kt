package com.mkt.ipaddressresolver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IpAddressResolverApplication

fun main(args: Array<String>) {
	runApplication<IpAddressResolverApplication>(*args)
}
