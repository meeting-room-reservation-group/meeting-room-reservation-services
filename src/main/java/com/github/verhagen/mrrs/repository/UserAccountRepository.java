package com.github.verhagen.mrrs.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.mrrs.domain.UserAccount;

public class UserAccountRepository {
	private static Logger logger = LoggerFactory.getLogger(UserAccountRepository.class);
	private Map<String, UserAccount> accountsByName = new HashMap<>();
	private Map<String, UserAccount> accountsById = new HashMap<>();


	public void add(final UserAccount userAccount) {
		accountsByName.put(createKey(userAccount), userAccount);
		accountsById.put(userAccount.getId(), userAccount);
	}


	private String createKey(final UserAccount userAccount) {
		return createKey(userAccount.getName());
	}


	private String createKey(final String name) {
		return name.toLowerCase().replace(' ', '-');
	}


	public int size() {
		return accountsByName.size();
	}


	public UserAccount search(final String query) {
		final String queryCln = StringUtils.trimToNull(query);
		if (queryCln == null) {
			throw new IllegalArgumentException("Argument 'query' should not be null.");
		}
		if (! accountsByName.containsKey(createKey(queryCln))) {
			if (! accountsById.containsKey(queryCln)) {
				logger.info("Not a known user account '" + queryCln + "'");
				return null;
			}

			return accountsById.get(query);
		}

		return accountsByName.get(createKey(query));
	}


	public Collection<UserAccount> getAll() {
		return accountsByName.values();
	}


	public UserAccount getById(final String id) {
		final String idCln = StringUtils.trimToNull(id);
		if (idCln == null) {
			throw new IllegalArgumentException("Argument 'id' should not be null.");
		}
		if (! accountsById.containsKey(idCln)) {
			throw new IllegalArgumentException("Not a known user account id '" + idCln + "'.");
		}

		return accountsById.get(id);
	}

}
