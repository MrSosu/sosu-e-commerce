package com.example.ordini.prodotti;

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

    public List<PurchaseResponse> purchaseProdotti(@RequestBody List<PurchaseRequest> request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(request, headers);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(prodottiUrl + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType);
        if (responseEntity.getStatusCode().isError())
            throw new BusinessException("qualcosa è andato storto durante l'acquisto dei prodotti " + responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

}
