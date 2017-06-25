package org.com.rappid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.com.rappid.catalog.ChefStatusType;

import java.util.UUID;

/**
 * Created by PINA on 31/05/2017.
 */
@Data
@Builder
@AllArgsConstructor
public class Chef {

    public Chef () {
        this.id = UUID.randomUUID().toString();
    }

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String rfc;
    private String curp;
    private String createDate;
    private String changeDate;
    private Float rating;
    private Account account;
    private ChefStatusType status;
}
