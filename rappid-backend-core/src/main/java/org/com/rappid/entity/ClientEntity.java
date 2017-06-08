package org.com.rappid.entity;

import lombok.*;
import org.com.rappid.group.client.CreateClientGroup;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by PINA on 28/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_RAPPID_CLIENT")
@EqualsAndHashCode(callSuper = true)
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "Client.delete",
            query = "UPDATE T_RAPPID_CLIENT SET DELETED = 1 WHERE ID_CLIENT = ?"
    )
})
public class ClientEntity extends AbstractEntity {

    @Id
    @Column(name = "ID_CLIENT", length = 32, nullable = false, updatable = false)
    private String id;

    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ID_TELEPHONE")
    private TelephoneEntity telephone;

    @NotNull(groups = {CreateClientGroup.class})
    @Column(name = "FIRST_NAME", length = 80)
    private String firstName;

    @NotNull(groups = {CreateClientGroup.class})
    @Column(name = "LAST_NAME", length = 80)
    private String lastName;

    @NotNull(groups = {CreateClientGroup.class})
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Lob
    @NotNull(groups = {CreateClientGroup.class})
    @Column(name = "SECRET")
    private byte[] secret;

    @Column(name = "DELETED")
    private boolean deleted;
}
