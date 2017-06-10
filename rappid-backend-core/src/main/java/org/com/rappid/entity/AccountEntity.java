package org.com.rappid.entity;

import lombok.*;
import org.com.rappid.constraint.Email;
import org.com.rappid.group.chef.CreateChefGroup;
import org.com.rappid.group.chef.UpdateChefGroup;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by PINA on 25/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_RAPPID_ACCOUNT")
@EqualsAndHashCode(callSuper = true)
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Account.delete",
                query = "UPDATE T_RAPPID_ACCOUNT SET DELETED = 1 WHERE ID_ACCOUNT = ?"
        )
})
public class AccountEntity extends AbstractEntity {

    @Id
    @Column(name = "ID_ACCOUNT", length = 32, nullable = false, updatable = false)
    private String id;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "account", cascade = {CascadeType.REMOVE})
    private Set<TelephoneEntity> telephones;

    @Size(min = 2, max = 80)
    @NotNull(groups = {CreateChefGroup.class})
    @Column(name = "FIRST_NAME", length = 80)
    private String firstName;

    @Size(min = 2, max = 80)
    @NotNull(groups = {CreateChefGroup.class})
    @Column(name = "LAST_NAME", length = 80)
    private String lastName;

    @Email
    @NotNull(groups = {CreateChefGroup.class})
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Lob
    @NotNull(groups = {UpdateChefGroup.class})
    @Column(name = "SECRET")
    private byte[] secret;

    @Column(name = "DELETED")
    private boolean deleted;
}
