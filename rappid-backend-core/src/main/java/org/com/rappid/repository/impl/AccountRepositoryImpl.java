package org.com.rappid.repository.impl;

import org.com.rappid.domain.Account;
import org.com.rappid.repository.jpa.impl.GenericJPARepositoryImpl;
import org.com.rappid.stereotype.Repository;

import javax.ejb.Singleton;

/**
 * Created by PINA on 24/05/2017.
 */

@Repository
@Singleton
public class AccountRepositoryImpl extends GenericJPARepositoryImpl<Account, Long> {
}
