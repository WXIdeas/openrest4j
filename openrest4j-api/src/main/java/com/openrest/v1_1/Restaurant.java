package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.dispatches.DispatchInfo;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.i18n.LocalizedString;
import com.wix.restaurants.orders.OrdersInfo;
import com.wix.restaurants.reservations.ReservationsInfo;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant extends Organization {
	public static final String TYPE = "restaurant";
	private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Restaurant that = (Restaurant) o;

        if (distributorId != null ? !distributorId.equals(that.distributorId) : that.distributorId != null) return false;
        if (chainId != null ? !chainId.equals(that.chainId) : that.chainId != null) return false;
        if (openTimes != null ? !openTimes.equals(that.openTimes) : that.openTimes != null) return false;
        if (deliveryInfos != null ? !deliveryInfos.equals(that.deliveryInfos) : that.deliveryInfos != null) return false;
        if (paymentTypes != null ? !paymentTypes.equals(that.paymentTypes) : that.paymentTypes != null) return false;
        if (multiPaymentDisabled != null ? !multiPaymentDisabled.equals(that.multiPaymentDisabled) : that.multiPaymentDisabled != null) return false;
        if (creditcardsInfo != null ? !creditcardsInfo.equals(that.creditcardsInfo) : that.creditcardsInfo != null) return false;
        if (deliveriesInfo != null ? !deliveriesInfo.equals(that.deliveriesInfo) : that.deliveriesInfo != null) return false;
        if (orders != null ? !orders.equals(that.orders) : that.orders != null) return false;
        if (reservations != null ? !reservations.equals(that.reservations) : that.reservations != null) return false;
        if (antiFraudDisabled != null ? !antiFraudDisabled.equals(that.antiFraudDisabled) : that.antiFraudDisabled != null) return false;
        return features != null ? features.equals(that.features) : that.features == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (distributorId != null ? distributorId.hashCode() : 0);
        result = 31 * result + (chainId != null ? chainId.hashCode() : 0);
        result = 31 * result + (openTimes != null ? openTimes.hashCode() : 0);
        result = 31 * result + (deliveryInfos != null ? deliveryInfos.hashCode() : 0);
        result = 31 * result + (paymentTypes != null ? paymentTypes.hashCode() : 0);
        result = 31 * result + (multiPaymentDisabled != null ? multiPaymentDisabled.hashCode() : 0);
        result = 31 * result + (creditcardsInfo != null ? creditcardsInfo.hashCode() : 0);
        result = 31 * result + (deliveriesInfo != null ? deliveriesInfo.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        result = 31 * result + (reservations != null ? reservations.hashCode() : 0);
        result = 31 * result + (antiFraudDisabled != null ? antiFraudDisabled.hashCode() : 0);
        result = 31 * result + (features != null ? features.hashCode() : 0);
        return result;
    }

    public Restaurant(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
                      String distributorId, String chainId, LocalizedString title,
                      LocalizedString description, Contact contact, Address address,
                      Map<String, LocalizedString> messages, ColorScheme colorScheme,
                      Availability openTimes, List<DispatchInfo> deliveryInfos,
                      String timezone, String currency, Locale locale, Set<Locale> locales,
                      Set<String> paymentTypes, Boolean multiPaymentDisabled, CreditcardsInfo creditcardsInfo,
                      DeliveriesInfo deliveriesInfo, OrdersInfo orders, ReservationsInfo reservations,
                      Boolean antiFraudDisabled, Map<String, String> media,
                      List<AppInfo> apps, Seo seo, Map<String, String> properties, Map<String, String> compatibilities,
                      Map<String, Availability> availabilities,
                      Boolean closed, Set<Product> products, Map<String, Double> features) {
    	super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, address, timezone, currency, apps, seo, properties, compatibilities,
                availabilities, media, closed, products);
        
    	this.distributorId = distributorId;
    	this.chainId = chainId;
        this.openTimes = openTimes;
        this.deliveryInfos = deliveryInfos;
        this.paymentTypes = paymentTypes;
        this.multiPaymentDisabled = multiPaymentDisabled;
        this.creditcardsInfo = creditcardsInfo;
        this.deliveriesInfo = deliveriesInfo;
        this.orders = orders;
        this.reservations = reservations;
        this.antiFraudDisabled = antiFraudDisabled;
        this.features = features;
    }

    /** Default constructor for JSON deserialization. */
    public Restaurant() {}

    @Override
    public Restaurant clone() {
        return cloneImpl();
    }

    /** @return a shallow copy of this object. */
    @Override
	protected Restaurant cloneImpl() {
    	return new Restaurant(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                (created != null) ? (Date) created.clone() : null,
                (modified != null) ? (Date) modified.clone() : null,
                distributorId, chainId,
    			((title != null) ? title.clone() : null),
    			((description != null) ? description.clone() : null),
    			((contact != null) ? contact.clone() : null),
    			((address != null) ? address.clone() : null),
    			cloneMessages(messages),
    			((colorScheme != null) ? (ColorScheme) colorScheme.clone() : null),
    			((openTimes != null) ? openTimes.clone() : null),
                DispatchInfo.clone(deliveryInfos),
    			timezone, currency, locale,
    			((locales != null) ? new LinkedHashSet<>(locales) : null),
    			((paymentTypes != null) ? new LinkedHashSet<>(paymentTypes) : null),
    			multiPaymentDisabled,
                ((creditcardsInfo != null) ? creditcardsInfo.clone() : null),
                ((deliveriesInfo != null) ? deliveriesInfo.clone() : null),
                ((orders != null) ? orders.clone() : null),
                ((reservations != null) ? reservations.clone() : null),
    			antiFraudDisabled,
                ((media != null) ? new LinkedHashMap<>(media) : null),
                AppInfo.clone(apps),
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			((compatibilities != null) ? new LinkedHashMap<>(compatibilities) : null),
                Availability.clone(availabilities),
    			closed, Product.clone(products),
    			((features != null) ? new LinkedHashMap<>(features) : null));
	}

    @Override
    public String toString() {
        return "Restaurant{" +
                "distributorId='" + distributorId + '\'' +
                ", chainId='" + chainId + '\'' +
                ", openTimes=" + openTimes +
                ", deliveryInfos=" + deliveryInfos +
                ", paymentTypes=" + paymentTypes +
                ", multiPaymentDisabled=" + multiPaymentDisabled +
                ", creditcardsInfo=" + creditcardsInfo +
                ", deliveriesInfo=" + deliveriesInfo +
                ", orders=" + orders +
                ", reservations=" + reservations +
                ", antiFraudDisabled=" + antiFraudDisabled +
                ", features=" + features +
                ", id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                ", affiliateId='" + affiliateId + '\'' +
                ", externalIds=" + externalIds +
                ", created=" + created +
                ", modified=" + modified +
                ", title=" + title +
                ", description=" + description +
                ", colorScheme=" + colorScheme +
                ", contact=" + contact +
                ", address=" + address +
                ", timezone='" + timezone + '\'' +
                ", currency='" + currency + '\'' +
                ", locale=" + locale +
                ", locales=" + locales +
                ", messages=" + messages +
                ", apps=" + apps +
                ", seo=" + seo +
                ", properties=" + properties +
                ", compatibilities=" + compatibilities +
                ", availabilities=" + availabilities +
                ", media=" + media +
                ", closed=" + closed +
                ", products=" + products +
                '}';
    }

    /** The distributor in charge of this restaurant. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
    
    /** The chain this restaurant is part of. */
    @JsonInclude(Include.NON_NULL)
    public String chainId;
    
    /** Restaurant opening times. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability openTimes = new Availability();

    /** Information regarding the different delivery destinations. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<DispatchInfo> deliveryInfos = new LinkedList<>();
    
    /** Available payment methods. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> paymentTypes = new LinkedHashSet<>();
    
    /** Whether or not the restaurant supports multiple payments in a single order. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean multiPaymentDisabled = Boolean.FALSE;
    
    @JsonInclude(Include.NON_NULL)
    public CreditcardsInfo creditcardsInfo = new CreditcardsInfo();

    @JsonInclude(Include.NON_NULL)
    public DeliveriesInfo deliveriesInfo;

    @JsonInclude(Include.NON_NULL)
    public OrdersInfo orders;

    @JsonInclude(Include.NON_NULL)
    public ReservationsInfo reservations;

    /** Whether or not the fraud prevention feature is turned off. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean antiFraudDisabled = Boolean.FALSE;
    
    /**
     * Maps feature-IDs to their values. The values correspond to how strongly the feature
     * is relevant for the restaurant, which influences its position in search results.
     * 
     * For example, a restaurant with "hamburger" feature = 3.7 will appear before a
     * restaurant with the same feature = 2.3 when customers search for hamburgers.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Double> features = new LinkedHashMap<>();
}
