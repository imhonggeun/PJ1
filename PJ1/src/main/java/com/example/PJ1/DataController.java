package com.example.PJ1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DataController {
	
	@Value("${API_KEY}") // application.properties 또는 환경변수에서 불러옴
    private String apiKey;
	
	@Autowired
	private TestMapper testMapper;
	
	@GetMapping("/") //영화 전체 리스트
	public List<movie> movie() {
		return testMapper.movie();
	}
	
	@GetMapping("/movie")
	public ResponseEntity<String> getMovie(@RequestParam String q) {
        String url = "https://www.omdbapi.com/?apikey=" + apiKey + "&s=" + q;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return ResponseEntity.ok(response);
    }
	

}
