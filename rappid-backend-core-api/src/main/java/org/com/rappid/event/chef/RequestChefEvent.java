package org.com.rappid.event.chef;

import lombok.Builder;
import org.com.rappid.event.RequestEvent;

/**
 * Created by PINA on 22/05/2017.
 */
public class RequestChefEvent extends RequestEvent {

    @Builder
    public RequestChefEvent(final String id) {
        super(id);
    }
}
