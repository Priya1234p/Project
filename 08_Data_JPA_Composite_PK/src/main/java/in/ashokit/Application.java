package in.ashokit;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Account;
import in.ashokit.entity.AccountPK;
import in.ashokit.repository.AccountRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		AccountRepository accountRepo = context.getBean(AccountRepository.class);
		/*
		 * AccountPK pk = new AccountPK(); pk.setAccId(1); pk.setAccTyp("Current");
		 * pk.setAccNum(189745l);
		 * 
		 * Account ac=new Account(); ac.setHolderName("Raju");
		 * ac.setBranchName("Amerpret"); ac.setAccountPK(pk);
		 * 
		 * accountRepo.save(ac);
		 */
		
		AccountPK pk = new AccountPK();
		pk.setAccId(1);
		pk.setAccTyp("Current");
		pk.setAccNum(189745l);
		Optional<Account> findById = accountRepo.findById(pk);
		System.out.println(findById.get());
	}

}
