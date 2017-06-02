package org.com.rappid.event.chef;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.rappid.domain.Chef;

import java.util.List;

/**
 * Created by PINA on 31/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatalogChefEvent {

    private int total;
    private List<Chef> chefs;
}
