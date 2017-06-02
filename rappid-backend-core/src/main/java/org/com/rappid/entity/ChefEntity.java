package org.com.rappid.entity;

import lombok.*;
import org.com.rappid.entity.catalog.ChefStatusEnum;

import javax.persistence.*;

/**
 * Created by PINA on 31/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_RAPPID_CHEF")
@EqualsAndHashCode(callSuper = true)
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "delete",
                query = "UPDATE T_RAPPID_CHEF SET DELETE = 1 WHERE ID_CHEF = ?"
        )
})
public class ChefEntity extends AbstractEntity {

    @Id
    @Column(name = "ID_CHEF", length = 32, nullable = false, updatable = false)
    private String id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ID_ACCOUNT")
    private AccountEntity account;

    @Column(name = "FIRST_NAME", length = 80)
    private String firstName;

    @Column(name = "LAST_NAME", length = 80)
    private String lastName;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "CURP", length = 20)
    private String curp;

    @Column(name = "RFC", length = 15)
    private String rfc;

    @Column(name = "RATING")
    private float rating;

    @Column(name = "CHEF_STATUS", length = 20)
    @Enumerated(EnumType.STRING)
    private ChefStatusEnum chefStatusEnum;

    @Column(name = "DELETE")
    private boolean deleted;
}
