package com.beerhouse;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.beerhouse.models.Beer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackageClasses = Application.class)
public class ApplicationTests {

	final String baseUrl = "http://localhost:9000/beerhouse/beers";
	
	@Test
	public void contextLoads() {
	}
	@Test
	public void testGetList() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	   
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	  public void testPost() throws URISyntaxException {
	        Beer newBeer = new Beer();
	        newBeer.setName("junit teste");
	        newBeer.setAlcoholContent("3%");
	        newBeer.setCategory("pilsen");
	        newBeer.setIngredients("...");
	        newBeer.setPrice(new Float(3.04));
	        
	        RestTemplate restTemplate = new RestTemplate();
	       
	        URI uri = new URI(baseUrl);
	   	 
		    ResponseEntity<String> result = restTemplate.postForEntity(uri, newBeer,  String.class);
		     
		    //Verify request succeed
		    Assert.assertEquals(201, result.getStatusCodeValue());
	        
	    }
	
	
	
}