package com.perf.demo.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;

import java.net.URI;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.perf.demo.inputjson.InputJsonProduct;
import com.perf.demo.inputjson.OutputJsonProduct;
import com.perf.demo.inputjson.InputJsonProduct.InsertCommand;
import com.perf.demo.inputjson.InputJsonProduct.InsertCommand.Insert;
import com.perf.demo.inputjson.InputJsonProduct.InsertCommand.Insert.ProductWrapper;
import com.perf.demo.model.Product;

@Service
public class RedHatRulesService {

	Logger logger = LoggerFactory.getLogger(RedHatRulesService.class);
	
	@Value("${kieserver.auth.username}") private String userName;
	@Value("${kieserver.auth.password}") private String password;
	@Value("${kieserver.rest.controllers}") private String serverUrl;
	
	public RestTemplate restTemplate;
	
	public List<Product> fireRules(List<? extends Object> products) {
		ArrayList<Product> returnList = new ArrayList<Product> ();
		for (Object product: products) {
			returnList.add(fireRules((Product)product));
		}
		return returnList;
	}
	
	public Product fireRules(Product product) {
		logger.info(" ** BEFORE FIRING THE RULES *** " + product.toString());
		Product retValue =  sendRequestToBusinessCentral(product);
		logger.info(" ** AFTER FIRING THE RULES *** " + retValue.toString());
		return retValue;
	}
	
	@Before
    public void setUp() {
        restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }
     
    private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                          = new HttpComponentsClientHttpRequestFactory();
         
        clientHttpRequestFactory.setHttpClient(getHttpClient());
              
        return clientHttpRequestFactory;
    }
     
    private HttpClient getHttpClient() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
 
        credentialsProvider.setCredentials(AuthScope.ANY, 
                        new UsernamePasswordCredentials(userName, password));
 
        HttpClient client = HttpClientBuilder
                                .create()
                                .setDefaultCredentialsProvider(credentialsProvider)
                                .build();
        return client;
    }
    
    public Product sendRequestToBusinessCentral(Product product) {
    	try {
        URI uri = new URI(serverUrl);
         
        HttpHeaders headers = new HttpHeaders();
        String authStr = userName+":"+password;//wbadmin:wbadmin";
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        headers.add("Authorization", "Basic " + base64Creds);

        InputJsonProduct inputJson = getInputJsonProduct (product);
 
        HttpEntity<InputJsonProduct> request = new HttpEntity(inputJson, headers);
        
        restTemplate = new RestTemplate();
        
        ResponseEntity<OutputJsonProduct> result = this.restTemplate.postForEntity(uri, request, OutputJsonProduct.class);
         
        /**
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>)result.getBody().result;
        LinkedHashMap<String, Object> map1 = (LinkedHashMap<String, Object>) map.get("execution-results");
        ArrayList<Object> map2 = (ArrayList<Object>) map1.get("results");
        LinkedHashMap<String, Object> map3 = (LinkedHashMap<String, Object>) map2.get(1);
        LinkedHashMap<String, Object> map4 = (LinkedHashMap<String, Object>) map3.get("value");
        Object obj = map4.get("com.perf.demo.model.Product");
        
        ObjectMapper mapper = new ObjectMapper();
        OutputJson produ = mapper.readValue(result.getBody().toString(), OutputJson.class);
        **/
        return result.getBody().getResult().getExecutionResults().getResults().get(0).getValue().getProduct();
        //Verify bad request and missing header
    	} catch (Exception ex) {
    		logger.error(ex.getMessage(), ex);
    	}
    	return null;
    }
    
    private InputJsonProduct getInputJsonProduct (Product product) {
    	InputJsonProduct inputJson = new InputJsonProduct();

    	InsertCommand insertCommand = inputJson.new InsertCommand(); 
    	Insert insert = insertCommand.new Insert();
    	ProductWrapper wrapper = insert.new ProductWrapper();
    	wrapper.product = product;
    	insert.productWrapper = wrapper;
    	
    	insertCommand.insert = insert;
    	
    	//RulesCommand command2 = inputJson.new RulesCommand();

    	List<Object> commands = new ArrayList<Object> ();
    	commands.add(insertCommand);
    	//commands.add(command2);
    	inputJson.commands = commands;
    	
    	
    	return inputJson;
    }
    
	/**
	public Object execute (Object parameter) {
		return sendRequestToBusinessCentral((Product) parameter);
////		Jewelry j1 = new Jewelry();
////		j1.setType("gold");
//		
////		String url = "http://localhost:8080/kie-server/services/rest/server";
////		String username = "kieserver";
////		String password = "kieserver1!";
////		String container = "rulesample";
////		String session = "kSession";
////
////		KieServicesConfiguration config = KieServicesFactory
////		  .newRestConfiguration(url, username, password);
////		//config.setMarshallingFormat(MarshallingFormat.JAXB);
////		config.setMarshallingFormat(MarshallingFormat.JSON);
////		//config.setMarshallingFormat(MarshallingFormat.XSTREAM);
////		KieServicesClient client  = KieServicesFactory.newKieServicesClient(config);
////		
////		Set<Class<?>> allClasses = new HashSet<Class<?>>();
////		allClasses.add(Jewelry.class);
////		//config.addExtraClasses(allClasses);
////		config.addJaxbClasses(allClasses);
////
////		RuleServicesClient ruleClient = client.getServicesClient(RuleServicesClient.class);
////		List<GenericCommand<?>> commands = new ArrayList<GenericCommand<?>>();
////
////		commands.add((GenericCommand<?>) KieServices.Factory
////				  .get().getCommands().newInsert((Jewelry)parameter,"Jewelry Insert ID"));
////		commands.add((GenericCommand<?>) KieServices.Factory
////		  .get().getCommands().newFireAllRules("fire-identifier"));
////
////		BatchExecutionCommand batchCommand = KieServices.Factory
////		  .get().getCommands().newBatchExecution(commands,session);
////		ServiceResponse<String> response = ruleClient.executeCommands(container, batchCommand);
////		System.out.println(response.getResult());
////		
////		//ServiceResponse<ExecutionResults> responses = ruleClient.executeCommandsWithResults(container, batchCommand);
////		//System.out.println((Jewelry) responses);
////		return response;
		
		//return null;
	}
	**/
}
