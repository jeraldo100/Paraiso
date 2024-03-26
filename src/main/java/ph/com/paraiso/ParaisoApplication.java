package ph.com.paraiso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ph.com.paraiso.*")
@EntityScan("ph.com.cpi.paraiso")
@EnableJpaRepositories("ph.com.paraiso.repository")
public class ParaisoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParaisoApplication.class, args);
	}

}
