package org.com.rappid.event.chef;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by PINA on 22/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestAllChefEvent {

    private int page;
    private int limit;
}
