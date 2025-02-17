package github.samuelastech.gateway;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.config.HttpClientCustomizer;
import org.springframework.context.annotation.Bean;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public HttpClientCustomizer httpClientResolverCustomizer() {
		return new HttpClientCustomizer() {
			@Override
			public HttpClient customize(HttpClient httpClient) {
				return httpClient.resolver(DefaultAddressResolverGroup.INSTANCE);
			}
		};
	}
}
