package com.api.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GatewayApplicationTests {

	@Value("${eureka.client.serviceUrl.defaultZone}")
	private String eurekaDefaultZone;

	@Value("${spring.cloud.gateway.discovery.locator.enabled}")
	private boolean discoveryLocatorEnabled;

	@Value("${spring.cloud.gateway.discovery.locator.lower-case-service-id}")
	private boolean lowerCaseServiceId;

	@Test
	void contextLoads() {
	}

	@Test
	void gatewayUsesDiscoveryServicePortAndDiscoveryLocator() {
		assertThat(eurekaDefaultZone).isEqualTo("http://discovery:8082/eureka");
		assertThat(discoveryLocatorEnabled).isTrue();
		assertThat(lowerCaseServiceId).isTrue();
	}

}
