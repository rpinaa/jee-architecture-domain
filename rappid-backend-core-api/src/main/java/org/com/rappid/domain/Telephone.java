package org.com.rappid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.rappid.catalog.TelephoneType;

/**
 * Created by PINA on 22/05/2017.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Telephone {

    private String name;
    private String number;
    private String lada;
    private TelephoneType telephoneType;
}
