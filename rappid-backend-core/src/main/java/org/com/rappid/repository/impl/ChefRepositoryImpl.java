package org.com.rappid.repository.impl;

import org.com.rappid.domain.Chef;
import org.com.rappid.entity.ChefEntity;
import org.com.rappid.repository.ChefRepository;
import org.com.rappid.repository.jpa.impl.GenericJPARepositoryImpl;
import org.com.rappid.stereotype.Repository;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by PINA on 05/06/2017.
 */
@Repository
@ApplicationScoped
public class ChefRepositoryImpl extends GenericJPARepositoryImpl<Chef, ChefEntity> implements ChefRepository {
}
