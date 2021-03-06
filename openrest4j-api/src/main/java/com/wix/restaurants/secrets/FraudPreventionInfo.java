package com.wix.restaurants.secrets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FraudPreventionInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public FraudPreventionInfo(Boolean enabled) {
        this.enabled = enabled;
    }

    /** Default constructor for JSON deserialization. */
    public FraudPreventionInfo() {}

    @Override
    public Object clone() {
        return new FraudPreventionInfo(enabled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FraudPreventionInfo that = (FraudPreventionInfo) o;

        return enabled != null ? enabled.equals(that.enabled) : that.enabled == null;
    }

    @Override
    public int hashCode() {
        return enabled != null ? enabled.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FraudPreventionInfo{" +
                "enabled=" + enabled +
                '}';
    }

    @JsonInclude(Include.NON_DEFAULT)
    public Boolean enabled = Boolean.FALSE;
}
