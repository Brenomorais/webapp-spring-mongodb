package com.brenomorais.escola.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brenomorais.escola.models.Contato;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng;

@Service
public class GeolocalizacaoService {
	
	public List<Double> obterLatELongPor(Contato contato) throws ApiException, InterruptedException, IOException {
		
		final String API_KEY = "AIzaSyAIPw0BOFbsavl2S0XJm366GqIL8WaL4xw";
		
		GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
		GeocodingApiRequest request = GeocodingApi.newRequest(context).address(contato.getEndereco());

		GeocodingResult[] results = request.await();
		GeocodingResult resultado = results[0];

		Geometry geometry = resultado.geometry;
		LatLng location = geometry.location;

		return Arrays.asList(location.lat, location.lng);
	}

}
