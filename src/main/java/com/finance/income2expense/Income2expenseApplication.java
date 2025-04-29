package com.finance.income2expense;

/*import com.finance.income2expense.model.UserModel;
import com.finance.income2expense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Income2expenseApplication {

	/*@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;*/

	public static void main(String[] args) {
		SpringApplication.run(Income2expenseApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			UserModel userModel = new UserModel();
			userModel.setUsername("admin");
			userModel.setPassword(passwordEncoder.encode("nimda"));
			userModel.setEnabled(true);

			userRepository.save(userModel);
		};
	}*/
}
