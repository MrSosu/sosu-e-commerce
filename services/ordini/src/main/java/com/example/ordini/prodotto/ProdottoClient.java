package com.example.ordini.prodotto;

import com.example.ordini.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProdottoClient {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${application.config.prodotti-url}")
    private String prodottiUrl;

    public List<ProdottoPurchaseResponse> purchaseProdotti(@RequestBody List<ProdottoPurchaseRequest> requests) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<List<ProdottoPurchaseRequest>> requestEntity = new HttpEntity<>(requests, headers);
        ParameterizedTypeReference<List<ProdottoPurchaseResponse>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<ProdottoPurchaseResponse>> responseEntity = restTemplate.exchange(
                prodottiUrl + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
        );
        if(responseEntity.getStatusCode().isError())
            throw new BusinessException("qualcosa è andato storto durante il purchase dei prodotti");
        return responseEntity.getBody();
    }

}
