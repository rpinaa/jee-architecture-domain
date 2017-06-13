package org.com.rappid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * Created by PINA on 19/05/2017.
 */
@Data
@Builder
@AllArgsConstructor
public class Account {

    public Account () {
        this.id = UUID.randomUUID().toString();
    }

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String email;
    private String firstName;
    private String lastName;
}
