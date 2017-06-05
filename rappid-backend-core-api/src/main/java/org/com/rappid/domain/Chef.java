package org.com.rappid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.com.rappid.catalog.ChefStatusType;

/**
 * Created by PINA on 31/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chef {

    private String id;
    private String rfc;
    private String curp;
    private String createDate;
    private String changeDate;
    private Float rating;
    private Account account;
    private ChefStatusType chefStatusType;
}
