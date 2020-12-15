package org.springframework.samples.petclinic.api.application;

import org.springframework.samples.petclinic.api.dto.OwnerDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CustomersServiceClient {
	private final WebClient.Builder webClientBuilder;

	public CustomersServiceClient(WebClient.Builder webClientBuilder) {
		this.webClientBuilder = webClientBuilder;
	}

	public Mono<OwnerDetails> getOwner(final int ownerId) {
		return webClientBuilder.build().get()
			.uri("http://customers-service/owners/{ownerId}", ownerId)
			.retrieve()
			.bodyToMono(OwnerDetails.class);
	}
}
