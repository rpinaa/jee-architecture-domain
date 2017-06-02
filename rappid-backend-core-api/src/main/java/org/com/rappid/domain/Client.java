package org.com.rappid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by PINA on 28/05/2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Telephone telephone;
}
