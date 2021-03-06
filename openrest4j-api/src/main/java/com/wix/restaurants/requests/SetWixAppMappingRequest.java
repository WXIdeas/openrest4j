package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetWixAppMappingRequest extends Request {
    public static final String TYPE = "set_wix_app_mapping";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SetWixAppMappingRequest() {}

    public SetWixAppMappingRequest(String accessToken, String instance, String instanceId, String organizationId) {
        this.accessToken = accessToken;
        this.instance = instance;
        this.instanceId = instanceId;
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetWixAppMappingRequest that = (SetWixAppMappingRequest) o;
        return Objects.equals(accessToken, that.accessToken) &&
                Objects.equals(instance, that.instance) &&
                Objects.equals(instanceId, that.instanceId) &&
                Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, instance, instanceId, organizationId);
    }

    /** Access token (alternative: specify instance). */
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /**
     * App instance of a Wix site owner (alternative: specify accessToken).
     * @see <a href="http://dev.wix.com/docs/infrastructure/app-instance">App Instance</a>
     */
    @JsonInclude(Include.NON_NULL)
    public String instance;

    /**
     * The Wix App Instance ID to map.
     * @see <a href="http://dev.wix.com/docs/infrastructure/app-instance-id#overview">App Instance ID</a>
     */
    @JsonInclude(Include.NON_NULL)
    public String instanceId;

    /** The organization ID to map to, or null to clear existing mapping. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
}
