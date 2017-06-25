package org.com.rappid.entity;

import lombok.*;
import org.com.rappid.constraint.Curp;
import org.com.rappid.constraint.Rfc;
import org.com.rappid.entity.catalog.ChefStatusEnum;
import org.com.rappid.group.chef.UpdateChefGroup;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by PINA on 31/05/2017.
 */
@Data
@Entity
@Table(name = "chef")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ChefEntity extends AbstractEntity {

    @Id
    @Column(name = "ID_CHEF", length = 36, nullable = false, updatable = false)
    private String id;

    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FK_ID_ACCOUNT")
    private AccountEntity account;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "chef")
    private Set<TelephoneEntity> telephones;

    @Curp(groups = {UpdateChefGroup.class})
    @NotNull(groups = {UpdateChefGroup.class})
    @Column(name = "CURP", length = 18)
    private String curp;

    @Rfc(groups = {UpdateChefGroup.class})
    @NotNull(groups = {UpdateChefGroup.class})
    @Column(name = "RFC", length = 13)
    private String rfc;

    @NotNull(groups = {UpdateChefGroup.class})
    @Column(name = "RATING")
    private Float rating;

    @NotNull(groups = {UpdateChefGroup.class})
    @Column(name = "CHEF_STATUS", length = 20)
    @Enumerated(EnumType.STRING)
    private ChefStatusEnum status;
}
