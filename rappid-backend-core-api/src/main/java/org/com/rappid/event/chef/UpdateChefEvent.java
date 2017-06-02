package org.com.rappid.event.chef;

import lombok.*;
import org.com.rappid.domain.Chef;
import org.com.rappid.event.UpdateEvent;

/**
 * Created by PINA on 22/05/2017.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateChefEvent extends UpdateEvent {
    private Chef chef;
}
