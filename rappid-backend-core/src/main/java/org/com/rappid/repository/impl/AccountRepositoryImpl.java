package org.com.rappid.repository.impl;

import org.com.rappid.entity.AccountEntity;
import org.com.rappid.repository.AccountRepository;
import org.com.rappid.repository.jpa.impl.GenericJPARepositoryImpl;
import org.com.rappid.stereotype.Repository;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by PINA on 24/05/2017.
 */
@Repository
@ApplicationScoped
public class AccountRepositoryImpl extends GenericJPARepositoryImpl<AccountEntity, String> implements AccountRepository {
}
