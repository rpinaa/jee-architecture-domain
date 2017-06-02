package org.com.rappid.entity;

import lombok.*;
import org.com.rappid.entity.catalog.TelephoneEnum;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_ACCOUNT")
    @Getter(AccessLevel.NONE)
    private AccountEntity account;

    @Column(name = "NAME", length = 15)
    private String name;

    @Column(name = "LADA", length = 10)
    private String lada;

    @Column(name = "NUMBER", length = 12)
    private String number;

    @Column(name = "TYPE", length = 10)
    @Enumerated(EnumType.STRING)
    private TelephoneEnum telephoneEnum;
}
