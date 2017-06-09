package org.com.rappid.entity;

import lombok.*;
import org.com.rappid.constraint.Curp;
import org.com.rappid.constraint.Rfc;
import org.com.rappid.entity.catalog.ChefStatusEnum;
import org.com.rappid.group.chef.UpdateChefGroup;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
            name = "Chef.delete",
            query = "UPDATE T_RAPPID_CHEF SET DELETED = 1 WHERE ID_CHEF = ?"
    )
})
public class ChefEntity extends AbstractEntity {

    @Id
    @Column(name = "ID_CHEF", length = 32, nullable = false, updatable = false)
    private String id;

    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ID_ACCOUNT")
    private AccountEntity account;

    @Curp
    @NotNull(groups = {UpdateChefGroup.class})
    @Column(name = "CURP", length = 20)
    private String curp;

    @Rfc
    @NotNull(groups = {UpdateChefGroup.class})
    @Column(name = "RFC", length = 15)
    private String rfc;

    @NotNull(groups = {UpdateChefGroup.class})
    @Column(name = "RATING")
    private Float rating;

    @NotNull(groups = {UpdateChefGroup.class})
    @Column(name = "CHEF_STATUS", length = 20)
    @Enumerated(EnumType.STRING)
    private ChefStatusEnum chefStatusEnum;

    @Column(name = "DELETED")
    private boolean deleted;
}
