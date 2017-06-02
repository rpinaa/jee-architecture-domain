package org.com.rappid.event.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.rappid.domain.Client;
import org.com.rappid.event.UpdateEvent;

/**
 * Created by PINA on 22/05/2017.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientEvent extends UpdateEvent {
    private Client client;
}
