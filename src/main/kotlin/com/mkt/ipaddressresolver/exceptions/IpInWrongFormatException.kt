package com.mkt.ipaddressresolver.exceptions

import org.springframework.web.reactive.function.client.WebClientException

class IpInWrongFormatException (message: String) : WebClientException(message) {
}
