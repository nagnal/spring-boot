package com.perf.demo.inputjson;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perf.demo.model.Product;

public class InputJsonProduct {

	@JsonProperty("lookup")
	public String lookup = "ksession-rule";
	@JsonProperty("commands")
	public List<Object> commands = new ArrayList<Object>();
    
	public class RulesCommand {
		@JsonProperty("fire-all-rules")
	    public String fireAllRules = "";
	}
	
	public class InsertCommand {
		@JsonProperty("insert")
	    public Insert insert ;
		
		public class Insert {
			@JsonProperty("out-identifier")
			public String outIdentifier = "com.perf.demo.model.Product";
		    @JsonProperty("return-object")
		    public String returnObject="true";
		    @JsonProperty("object")
		    public ProductWrapper productWrapper;
		    
		    public class ProductWrapper {
				@JsonProperty("com.perf.demo.model.Product")
			    public Product product;
			}
		}
	}
}