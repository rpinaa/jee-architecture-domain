package org.com.rappid.event.client;

import lombok.*;
import org.com.rappid.domain.Client;
import org.com.rappid.event.CreateEvent;

/**
 * Created by PINA on 22/05/2017.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateClientEvent extends CreateEvent {
    private Client client;
}
