package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = CashPayment.class, name = CashPayment.TYPE),
        @Type(value = CreditcardPayment.class, name = CreditcardPayment.TYPE),
        @Type(value = DeliveryclubPayment.class, name = DeliveryclubPayment.TYPE),
        @Type(value = DeliverycomPayment.class, name = DeliverycomPayment.TYPE),
        @Type(value = BitpayPayment.class, name = BitpayPayment.TYPE),
        @Type(value = CellarixPayment.class, name = CellarixPayment.TYPE),
        @Type(value = BitsofgoldPayment.class, name = BitsofgoldPayment.TYPE),
        @Type(value = PelecardPayment.class, name = PelecardPayment.TYPE),
        @Type(value = CreditmutuelPayment.class, name = CreditmutuelPayment.TYPE),
        @Type(value = MultipassPayment.class, name = MultipassPayment.TYPE),
        @Type(value = TenbisPayment.class, name = TenbisPayment.TYPE),
        @Type(value = DebitPayment.class, name = DebitPayment.TYPE),
        @Type(value = PaypalPayment.class, name = PaypalPayment.TYPE)
})
public abstract class Payment implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Payment() {}

    public Payment(Integer amount, Map<String, String> externalIds) {
        this.amount = amount;
        this.externalIds = externalIds;
    }

    @Override
    public Payment clone() {
        return cloneImpl();
    }

    protected abstract Payment cloneImpl();

    public static List<Payment> clone(List<Payment> payments) {
        if (payments == null) {
            return null;
        }

        final List<Payment> cloned = new LinkedList<>();
        for (Payment payment : payments) {
            cloned.add((payment != null) ? payment.clone() : null);
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;
        return externalIds != null ? externalIds.equals(payment.externalIds) : payment.externalIds == null;
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        return result;
    }

    /** Amount to pay. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer amount = 0;

    /**
     * Map of externally-defined ids referring to this payment.
     * For example, the transaction-id in some external payment gateway.
     *
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new LinkedHashMap<>();
}
