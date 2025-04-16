package com.example.bankfinder.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankService {
    private final String GOOGLE_API_KEY = "YOUR_API_KEY";

    public List<Map<String, Object>> findNearbyBanks(String zipcode) {
        RestTemplate restTemplate = new RestTemplate();

        // Step 1: Get coordinates from zip code
        String geoUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + zipcode + "&key=" + GOOGLE_API_KEY;
        Map geoResponse = restTemplate.getForObject(geoUrl, Map.class);

        if (geoResponse == null || geoResponse.get("results") == null) return List.of();

        Map location = (Map) ((Map) ((Map)((List)geoResponse.get("results")).get(0)).get("geometry")).get("location");
        double lat = (double) location.get("lat");
        double lng = (double) location.get("lng");

        // Step 2: Get nearby banks from Places API
        String placesUrl = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%f,%f&radius=16093&type=bank&key=%s", lat, lng, GOOGLE_API_KEY);
        Map placesResponse = restTemplate.getForObject(placesUrl, Map.class);

        return (List<Map<String, Object>>) placesResponse.get("results");
    }
}
