package com.mkt.ipaddressresolver.exceptions

import org.springframework.web.reactive.function.client.WebClientException

class IpNotResolvedException (message: String) : WebClientException(message) {
}
