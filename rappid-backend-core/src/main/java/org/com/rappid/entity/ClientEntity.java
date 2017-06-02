package org.com.rappid.entity;

import lombok.*;

import javax.persistence.*;

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
                name = "delete",
                query = "UPDATE T_RAPPID_CLIENT SET DELETE = 1 WHERE ID_CLIENT = ?"
        )
})
public class ClientEntity extends AbstractEntity {

    @Id
    @Column(name = "ID_CLIENT", length = 32, nullable = false, updatable = false)
    private String id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ID_TELEPHONE")
    private TelephoneEntity telephone;

    @Column(name = "FIRST_NAME", length = 80)
    private String firstName;

    @Column(name = "LAST_NAME", length = 80)
    private String lastName;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Lob
    @Column(name = "SECRET")
    private byte[] secret;

    @Column(name = "DELETE")
    private boolean deleted;
}
