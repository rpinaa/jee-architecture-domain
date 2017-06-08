package org.com.rappid.entity;

import lombok.*;

import javax.persistence.*;
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

    @Column(name = "FIRST_NAME", length = 80)
    private String firstName;

    @Column(name = "LAST_NAME", length = 80)
    private String lastName;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Lob
    @Column(name = "SECRET")
    private byte[] secret;

    @Column(name = "DELETED")
    private boolean deleted;
}
