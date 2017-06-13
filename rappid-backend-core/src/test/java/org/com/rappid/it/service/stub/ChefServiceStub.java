package org.com.rappid.it.service.stub;

import org.com.rappid.domain.Account;
import org.com.rappid.domain.Chef;
import org.com.rappid.event.chef.CreateChefEvent;

/**
 * Created by PINA on 09/06/2017.
 */
public class ChefServiceStub {

    public static CreateChefEvent createChefEvent() {
        return CreateChefEvent.builder()
                .chef(Chef.builder()
                        .curp("WERT900114HDFXX05")
                        .rfc("WERT900114E45")
                        .account(Account.builder()
                                .email("pinaarellano0@gmail.com")
                                .firstName("Ricardo Pina")
                                .lastName("Arellano")
                                .build())
                        .build()).build();
    }
}
