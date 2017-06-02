package org.com.rappid.mapper.jpa;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.dozer.DozerBeanMapper;

import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by PINA on 25/05/2017.
 */

@Startup
@Singleton
public class DozerMapper {

    @Getter
    @Setter(AccessLevel.NONE)
    private DozerBeanMapper mapper = new DozerBeanMapper();
}
