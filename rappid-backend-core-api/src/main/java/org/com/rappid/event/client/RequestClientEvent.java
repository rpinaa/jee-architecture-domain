package org.com.rappid.event.client;

import lombok.Builder;
import org.com.rappid.event.RequestEvent;

/**
 * Created by PINA on 22/05/2017.
 */
public class RequestClientEvent extends RequestEvent {

    @Builder
    public RequestClientEvent(final String id) {
        super(id);
    }
}
