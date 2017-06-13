package org.com.rappid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.com.rappid.catalog.TelephoneType;

import java.util.UUID;

/**
 * Created by PINA on 22/05/2017.
 */

@Data
@Builder
@AllArgsConstructor
public class Telephone {

    public Telephone () {
        this.id = UUID.randomUUID().toString();
    }

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;
    private String number;
    private String lada;
    private TelephoneType telephoneType;
}
