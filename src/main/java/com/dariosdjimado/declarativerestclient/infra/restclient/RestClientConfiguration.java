package com.dariosdjimado.declarativerestclient.infra.restclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfiguration {

  @Bean
  public RestClient restClient(RestClient.Builder builder) {
    return builder
        .requestFactory(new JdkClientHttpRequestFactory())
        .baseUrl("https://jsonplaceholder.typicode.com/users")
        .build();
  }

  @Bean
  public UserRestClient userRestClient(RestClient restClient) {
    return HttpServiceProxyFactory.builder()
        .exchangeAdapter(RestClientAdapter.create(restClient))
        .build()
        .createClient(UserRestClient.class);
  }
}
