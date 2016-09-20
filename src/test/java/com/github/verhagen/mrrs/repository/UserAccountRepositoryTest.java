package com.github.verhagen.mrrs.repository;

import static org.junit.Assert.*;

import java.util.Collection;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.verhagen.mrrs.domain.UserAccount;

public class UserAccountRepositoryTest {
	private UserAccountRepository repo;

	@Rule
	public ExpectedException expExcep = ExpectedException.none();


	@Before
	public void setUp() {
		repo = new UserAccountRepository();
		repo.add(createUserAccount("tintin", "Tintin"));
		repo.add(createUserAccount("haddock", "Captain Haddock"));
//		repo.add(createUserAccount("calculus", "Professor Calculus"));
//		repo.add(createUserAccount("thomson", "Thomson and Thompson"));
	}


	@Test
	public void create() throws Exception {
		assertEquals(2, repo.size());
		UserAccount userAccount = repo.search("Tintin");
		assertEquals(userAccount.getName(), "Tintin");

		Collection<UserAccount> userAccounts = repo.getAll();
		assertEquals(2, userAccounts.size());
	}

	@Test
	public void getById() throws Exception {
		assertEquals(repo.getById("tintin").getName(), "Tintin");
		assertEquals(repo.getById("haddock").getName(), "Captain Haddock");
	}

	@Test
	public void getByIdNull() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("Argument 'id' should not be null."));
		
		repo.getById("\t");
	}

	@Test
	public void getByIdNotKnown() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("Not a known user account id 'snowy'."));
		
		repo.getById("snowy");
	}

	@Test
	public void search() throws Exception {
		assertEquals(repo.search("tintin").getName(), "Tintin");
		assertEquals(repo.search("Captain Haddock").getName(), "Captain Haddock");
		assertEquals(repo.search("haddock").getName(), "Captain Haddock");
	}

	@Test
	public void searchNull() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("Argument 'query' should not be null."));
		
		repo.search("\n");
	}

	@Test
	public void searchUnknown() throws Exception {
		assertNull(repo.search("snowy"));
	}


	private UserAccount createUserAccount(final String id, final String name) {
		return new UserAccount(id, name);
	}

}
