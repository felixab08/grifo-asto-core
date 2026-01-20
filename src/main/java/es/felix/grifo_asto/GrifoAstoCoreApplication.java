package es.felix.grifo_asto;

import es.felix.grifo_asto.entity.Persona;
import es.felix.grifo_asto.entity.Role;
import es.felix.grifo_asto.repository.PersonaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GrifoAstoCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrifoAstoCoreApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(PersonaRepository personaRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			// Create admin user if not exists
			if (!personaRepository.findByUsernameOrEmail("admin", "admin@grifo.com").isPresent()) {
				Persona admin = new Persona();
				admin.setNombre("Felix");
				admin.setApellido("ASTO BERROCAL");
				admin.setTelefono("98901031");
				admin.setEmail("admin@grifo.com");
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setRole(Role.ROLE_ADMIN);
				admin.setActivo(true);
				personaRepository.save(admin);
				System.out.println("✓ Usuario admin creado: admin / admin123");
			} else {
				System.out.println("✓ Usuario admin ya existe");
			}
		};
	}

}
