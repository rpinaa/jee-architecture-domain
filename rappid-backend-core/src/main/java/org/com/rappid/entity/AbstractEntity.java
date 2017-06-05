package org.com.rappid.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by PINA on 25/05/2017.
 */
@Data
@MappedSuperclass
public abstract class  AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CHANGE_DATE")
    private Date changeDate;

    @PrePersist
    void createdAt() {
        this.createDate = this.changeDate = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.changeDate = new Date();
    }
}
