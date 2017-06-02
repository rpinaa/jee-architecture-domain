package org.com.rappid.mapper;

import org.com.rappid.domain.Chef;
import org.com.rappid.entity.ChefEntity;
import org.com.rappid.mapper.jpa.impl.GenericMapperImpl;
import org.com.rappid.stereotype.Mapper;

import javax.ejb.Singleton;

/**
 * Created by PINA on 31/05/2017.
 */
@Mapper
@Singleton
public class ChefMapper extends GenericMapperImpl<Chef, ChefEntity> {
}
