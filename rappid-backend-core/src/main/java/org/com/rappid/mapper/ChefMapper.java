package org.com.rappid.mapper;

import org.com.rappid.domain.Chef;
import org.com.rappid.entity.ChefEntity;
import org.com.rappid.mapper.jpa.GenericMapper;
import org.mapstruct.Mapper;

/**
 * Created by PINA on 31/05/2017.
 */
@Mapper(componentModel = "cdi")
public interface ChefMapper extends GenericMapper<Chef, ChefEntity> {

    Chef map(final ChefEntity chefEntity);

    ChefEntity map(final Chef chef);
}
