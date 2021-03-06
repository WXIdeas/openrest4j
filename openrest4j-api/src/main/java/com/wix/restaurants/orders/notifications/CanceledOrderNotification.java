package com.wix.restaurants.orders.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.notifications.Notification;

/** Triggered when an order is canceled. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CanceledOrderNotification extends Notification {
    public static final String TYPE = "canceled_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CanceledOrderNotification() {}
    
    public CanceledOrderNotification(String channelId, String channelParam, String comment, String state) {
    	super(channelId, channelParam, comment, state);
    }
    
	@Override
	public CanceledOrderNotification clone() {
		return new CanceledOrderNotification(channelId, channelParam, comment, state);
	}
}
