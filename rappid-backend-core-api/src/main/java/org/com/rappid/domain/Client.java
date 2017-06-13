package org.com.rappid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * Created by PINA on 28/05/2017.
 */
@Data
@Builder
@AllArgsConstructor
public class Client {

    public Client () {
        this.id = UUID.randomUUID().toString();
    }

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String firstName;
    private String lastName;
    private String email;
    private Telephone telephone;
}
