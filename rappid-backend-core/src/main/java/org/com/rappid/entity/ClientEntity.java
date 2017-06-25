package org.com.rappid.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.com.rappid.constraint.Email;
import org.com.rappid.group.client.CreateClientGroup;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by PINA on 28/05/2017.
 */
@Data
@Entity
@Table(name = "client")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ClientEntity extends AbstractEntity {

    @Id
    @Column(name = "ID_CLIENT", length = 36, nullable = false, updatable = false)
    private String id;

    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ID_TELEPHONE")
    private TelephoneEntity telephone;

    @Size(min = 2, max = 80)
    @NotNull(groups = {CreateClientGroup.class})
    @Column(name = "FIRST_NAME", length = 80)
    private String firstName;

    @Size(min = 2, max = 80)
    @NotNull(groups = {CreateClientGroup.class})
    @Column(name = "LAST_NAME", length = 80)
    private String lastName;

    @Email
    @NotNull(groups = {CreateClientGroup.class})
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Lob
    @NotNull(groups = {CreateClientGroup.class})
    @Column(name = "SECRET")
    private byte[] secret;
}
