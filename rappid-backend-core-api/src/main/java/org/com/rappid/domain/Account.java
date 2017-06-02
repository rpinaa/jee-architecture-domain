package org.com.rappid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by PINA on 19/05/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
}
