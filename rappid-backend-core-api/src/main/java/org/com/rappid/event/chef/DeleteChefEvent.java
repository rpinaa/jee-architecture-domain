package org.com.rappid.event.chef;

import lombok.Builder;
import org.com.rappid.event.DeleteEvent;

/**
 * Created by PINA on 22/05/2017.
 */
public class DeleteChefEvent extends DeleteEvent {

    @Builder
    public DeleteChefEvent(final String id) {
        super(id);
    }
}
