package org.com.rappid.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by PINA on 22/05/2017.
 */
@Data
@AllArgsConstructor
public abstract class DeleteEvent {
    private String id;
}
