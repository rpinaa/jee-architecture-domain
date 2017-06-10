package org.com.rappid.entity;

import lombok.*;
import org.com.rappid.entity.catalog.TelephoneEnum;
import org.com.rappid.group.chef.UpdateChefGroup;
import org.com.rappid.group.client.CreateClientGroup;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by PINA on 28/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_RAPPID_TELEPHONE")
@EqualsAndHashCode(callSuper = true)
public class TelephoneEntity extends AbstractEntity {

    @Id
    @Column(name = "ID_TELEPHONE", length = 32, nullable = false, updatable = false)
    private String id;

    @NotNull(groups = UpdateChefGroup.class)
    @Getter(AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_ACCOUNT")
    private AccountEntity account;

    @Size(min = 2, max = 15)
    @NotNull(groups = {CreateClientGroup.class, UpdateChefGroup.class})
    @Column(name = "NAME", length = 15)
    private String name;

    @Size(min = 2, max = 10)
    @NotNull(groups = {CreateClientGroup.class, UpdateChefGroup.class})
    @Column(name = "LADA", length = 10)
    private String lada;

    @Size(min = 5, max = 12)
    @NotNull(groups = {CreateClientGroup.class, UpdateChefGroup.class})
    @Column(name = "NUMBER", length = 12)
    private String number;

    @NotNull(groups = {CreateClientGroup.class, UpdateChefGroup.class})
    @Column(name = "TYPE", length = 10)
    @Enumerated(EnumType.STRING)
    private TelephoneEnum telephoneEnum;
}
