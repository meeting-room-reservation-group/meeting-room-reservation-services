package com.github.verhagen.mrrs.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.verhagen.mrrs.domain.UserAccount;
import com.github.verhagen.mrrs.repository.UserAccountRepository;
import com.github.verhagen.mrrs.repository.csv.CsvUserAccountRepository;

@Path("users")
public class UserAccountService {
	private static Logger logger = LoggerFactory.getLogger(UserAccountService.class);
	private final UserAccountRepository repo;

	
	public UserAccountService() {
		final String filename = "src/test/resources/user-account.csv";
		try {
			repo = CsvUserAccountRepository.importBy(new FileReader(new File(filename)));
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Unable to load '" + filename + "'.", e);
		}
	}


	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Collection<UserAccount> get() {
		return repo.getAll();
	}

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Path("/{id}")
	public UserAccount getById(@PathParam("id") final String id) {
		try {
			UserAccount userAccount = repo.getById(id);
			logger.info("user-account: " + userAccount.getName());
			return userAccount;
		}
		catch (IllegalArgumentException iae) {
			logger.info("user-account: Nothing found for 'id' with value '" + id + "'");
		}
		return null;
	}

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Path("/query")
	public UserAccount search(@QueryParam("name") final String name) {
		UserAccount userAccount = repo.search(name);
		if (userAccount != null) {
			logger.info("user-account: " + userAccount.getName());
		}
		else {
			logger.info("user-account: Nothing found for 'name' with value '" + name + "'");
		}
		return userAccount;
	}

}
