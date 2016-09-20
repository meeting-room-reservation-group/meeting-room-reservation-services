package com.github.verhagen.mrrs.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import com.github.verhagen.mrrs.domain.UserAccount;

public class UserAccountServiceTest {
	private UserAccountService service = new UserAccountService();


	@Test
	public void getAll() throws Exception {
		Collection<UserAccount> userAccounts = service.get();

		assertNotNull(userAccounts);
		assertEquals(4, userAccounts.size());
	}


	@Test
	public void getById() throws Exception {
		UserAccount userAccount = service.getById("tintin");

		assertNotNull(userAccount);
		assertEquals("tintin", userAccount.getId());
		assertEquals("Tintin", userAccount.getName());
	}

}
