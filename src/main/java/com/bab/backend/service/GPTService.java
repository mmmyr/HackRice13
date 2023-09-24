package com.bab.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class GPTService {


    private static final String OPENAI_URL = "https://api.openai.com/v1/engines/davinci/completions";
    private static final String AUTH_KEY = "YOUR_OPENAI_API_KEY";

    public String getGPTResponse(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(AUTH_KEY);

        String requestBody = "{\"prompt\":\"" + prompt + "\", \"max_tokens\":150}";
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(OPENAI_URL, HttpMethod.POST, entity, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            return root.path("choices").get(0).path("text").asText().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching response from GPT-3";
        }
    }
}
