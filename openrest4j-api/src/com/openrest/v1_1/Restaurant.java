package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Availability;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant extends Organization {
	public static final String TYPE = "restaurant";
	private static final long serialVersionUID = 1L;
    
    public Restaurant(String id, String alias, Map<String, String> externalIds, Long created, Long modified,
    		String distributorId, String chainId, Map<String, String> title,
    		Map<String, String> description, Contact contact, Map<String, Contact> externalContacts, Address address,
    		Map<String, Map<String, String>> messages, ColorScheme colorScheme,
    		Availability openTimes, Availability deliveryTimes,
            List<DeliveryInfo> deliveryInfos, Integer maxFutureOrderDelayMins,
            String timezone, String currency, String locale, Set<String> locales,
            Set<String> paymentTypes, Boolean multiPaymentDisabled, Map<String, CardInfo> cardInfos,
            Map<String, Integer> minPayments, String link, String domain, Set<String> altDomains,
            String picture, String icon, String wideLogo, String noImagePicture, Map<String, Blob> blobs,
            List<AppInfo> apps, Seo seo, Map<String, String> properties,
            String state, Map<String, Double> features, Double rank) {
    	super(id, alias, externalIds, created, modified, title, description, locale, locales, messages, colorScheme,
    			contact, externalContacts, address, timezone, currency, link, domain, altDomains, apps, seo, properties,
    			picture, icon, wideLogo, noImagePicture, blobs, state, rank);
        
    	this.distributorId = distributorId;
    	this.chainId = chainId;
        this.openTimes = openTimes;
        this.deliveryTimes = deliveryTimes;
        this.deliveryInfos = deliveryInfos;
        this.maxFutureOrderDelayMins = maxFutureOrderDelayMins;
        this.paymentTypes = paymentTypes;
        this.multiPaymentDisabled = multiPaymentDisabled;
        this.cardInfos = cardInfos;
        this.minPayments = minPayments;
        this.features = features;
    }

    /** Default constructor for JSON deserialization. */
    public Restaurant() {}
    
    /** @return a shallow copy of this object. */
    @Override
	public Object clone() {
    	final Map<String, CardInfo> clonedCardInfos;
    	if (cardInfos != null) {
    		clonedCardInfos = new HashMap<String, CardInfo>(cardInfos.size());
    		for (Entry<String, CardInfo> entry : cardInfos.entrySet()) {
    			clonedCardInfos.put(entry.getKey(), (CardInfo) entry.getValue().clone());
    		}
    	} else {
    		clonedCardInfos = null;
    	}
    	
    	final List<AppInfo> clonedApps;
    	if (apps != null) {
    		clonedApps = new ArrayList<AppInfo>(apps.size());
    		for (AppInfo app : apps) {
    			clonedApps.add((AppInfo) app.clone());
    		}
    	} else {
    		clonedApps = null;
    	}
    	
    	final Map<String, Map<String, String>> clonedMessages;
    	if (messages != null) {
    		clonedMessages = new HashMap<String, Map<String, String>>(messages.size());
    		for (Entry<String, Map<String, String>> entry : messages.entrySet()) {
    			clonedMessages.put(entry.getKey(), new HashMap<String, String>(entry.getValue()));
    		}
    	} else {
    		clonedMessages = null;
    	}
    	
    	final List<DeliveryInfo> clonedDeliveryInfos;
    	if (deliveryInfos != null) {
    		clonedDeliveryInfos = new ArrayList<DeliveryInfo>(deliveryInfos.size());
    		for (DeliveryInfo deliveryInfo : deliveryInfos) {
    			clonedDeliveryInfos.add((DeliveryInfo) deliveryInfo.clone());
    		}
    	} else {
    		clonedDeliveryInfos = null;
    	}
    	
    	final Map<String, Contact> clonedExternalContacts;
    	if (externalContacts != null) {
    		clonedExternalContacts = new LinkedHashMap<String, Contact>(externalContacts.size());
    		for (Entry<String, Contact> entry : externalContacts.entrySet()) {
    			clonedExternalContacts.put(entry.getKey(), (Contact) entry.getValue().clone());
    		}
    	} else {
    		clonedExternalContacts = null;
    	}    	
    	
    	final Map<String, Blob> clonedBlobs;
    	if (blobs != null) {
    		clonedBlobs = new LinkedHashMap<String, Blob>(blobs.size());
    		for (Entry<String, Blob> entry : blobs.entrySet()) {
    			clonedBlobs.put(entry.getKey(), (Blob) entry.getValue().clone());
    		}
    	} else {
    		clonedBlobs = null;
    	}

    	return new Restaurant(id, alias,
    			((externalIds != null) ? new HashMap<String, String>(externalIds) : null),    			
    			created, modified, distributorId, chainId,
    			((title != null) ? new HashMap<String, String>(title) : null),
    			((description != null) ? new HashMap<String, String>(description) : null),
    			((contact != null) ? (Contact)contact.clone() : null), clonedExternalContacts,
    			((address != null) ? (Address)address.clone() : null),
    			clonedMessages,
    			((colorScheme != null) ? (ColorScheme) colorScheme.clone() : null),
    			((openTimes != null) ? (Availability) openTimes.clone() : null),
    			((deliveryTimes != null) ? (Availability) deliveryTimes.clone() : null),
    			clonedDeliveryInfos, maxFutureOrderDelayMins,
    			timezone, currency, locale,
    			((locales != null) ? new HashSet<String>(locales) : null),
    			((paymentTypes != null) ? new HashSet<String>(paymentTypes) : null),
    			multiPaymentDisabled, clonedCardInfos,
    			((minPayments != null) ? new HashMap<String, Integer>(minPayments) : null),
    			link, domain,
    			((altDomains != null) ? new HashSet<String>(altDomains) : null),
    			picture, icon, wideLogo, noImagePicture, clonedBlobs,
    			clonedApps,
    			((seo != null) ? (Seo) seo.clone() : null),
    			((properties != null) ? new HashMap<String, String>(properties) : null), state,
    			((features != null) ? new HashMap<String, Double>(features) : null),
    			rank);
	}
    

    /** The distributor in charge of this restaurant. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
    
    /** The chain this restaurant is part of. */
    @JsonInclude(Include.NON_NULL)
    public String chainId;
    
    /** Restaurant availability. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability openTimes = new Availability();

    /** Deliveries availability. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability deliveryTimes = new Availability();

    /** Information regarding the different delivery destinations. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<DeliveryInfo> deliveryInfos = new ArrayList<DeliveryInfo>();
    
    /**
     * Latest time up to which future orders will be accepted. For example, a value of 4320 means
     * that the restaurant is willing to accept future orders up to 3 days in advance. The default
     * value of 0 means that the restaurant does not allow future orders.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer maxFutureOrderDelayMins = 0;

    /** Available payment methods. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> paymentTypes = new HashSet<String>();
    
    /** Whether or not the restaurant supports multiple payments in a single order. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean multiPaymentDisabled = Boolean.FALSE;
    
    /**
     * Maps credit card networks (e.g. "visa", "amex" etc) to the information
     * required to clear cards of that network.
     * 
     * Networks that do not appear here are not supported by the restaurant.
     * 
     * For the complete list of credit card networks, see
     * http://code.google.com/p/creditcard/
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, CardInfo> cardInfos = new HashMap<String, CardInfo>();

    /**
     * Maps available payment types to minimal charge allowed per payment, e.g.
     * "credit cards can only be used for paying $5 or more". Non-referenced
     * payment types have zero minimum by default.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Integer> minPayments = new HashMap<String, Integer>();
    
    /**
     * Maps feature-IDs to their values. The values correspond to how strongly the feature
     * is relevant for the restaurant, which influences its position in search results.
     * 
     * For example, a restaurant with "hamburger" feature = 3.7 will appear before a
     * restaurant with the same feature = 2.3 when customers search for hamburgers.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Double> features = new HashMap<String, Double>();
}
