
package com.perf.demo.inputjson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "org.drools.core.common.DefaultFactHandle"
})
public class Value_ implements Serializable
{

    @JsonProperty("org.drools.core.common.DefaultFactHandle")
    private OrgDroolsCoreCommonDefaultFactHandle orgDroolsCoreCommonDefaultFactHandle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8356222429646581135L;

    @JsonProperty("org.drools.core.common.DefaultFactHandle")
    public OrgDroolsCoreCommonDefaultFactHandle getOrgDroolsCoreCommonDefaultFactHandle() {
        return orgDroolsCoreCommonDefaultFactHandle;
    }

    @JsonProperty("org.drools.core.common.DefaultFactHandle")
    public void setOrgDroolsCoreCommonDefaultFactHandle(OrgDroolsCoreCommonDefaultFactHandle orgDroolsCoreCommonDefaultFactHandle) {
        this.orgDroolsCoreCommonDefaultFactHandle = orgDroolsCoreCommonDefaultFactHandle;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Value_ [orgDroolsCoreCommonDefaultFactHandle=" + orgDroolsCoreCommonDefaultFactHandle
				+ ", additionalProperties=" + additionalProperties + "]";
	}
}
