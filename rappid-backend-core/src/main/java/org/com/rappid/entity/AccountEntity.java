package org.com.rappid.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.com.rappid.constraint.Email;
import org.com.rappid.group.chef.ConfirmChefGroup;
import org.com.rappid.group.chef.CreateChefGroup;
import org.com.rappid.group.chef.UpdateChefGroup;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by PINA on 25/05/2017.
 */
@Data
@Entity
@Table(name = "T_RAPPID_ACCOUNT")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AccountEntity extends AbstractEntity {

    @Id
    @Column(name = "ID_ACCOUNT", length = 36, nullable = false, updatable = false)
    private String id;

    @Size(min = 2, max = 80)
    @NotNull(groups = {CreateChefGroup.class, UpdateChefGroup.class})
    @Column(name = "FIRST_NAME", length = 80)
    private String firstName;

    @Size(min = 2, max = 80)
    @NotNull(groups = {CreateChefGroup.class, UpdateChefGroup.class})
    @Column(name = "LAST_NAME", length = 80)
    private String lastName;

    @Email
    @NotNull(groups = {CreateChefGroup.class, UpdateChefGroup.class})
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Lob
    @NotNull(groups = {ConfirmChefGroup.class})
    @Column(name = "SECRET")
    private byte[] secret;
}
