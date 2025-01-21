echo "# one-forumhub-main" >> README.md
		git init
		git add README.md
		git commit -m "first commit"
		git branch -M main
		git remote add origin https://github.com/deborareverso/one-forumhub-mainDR.git
		git push -u origin mainpackage br.com.soupaulodev.forumhub;
git
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the ForumHub application.
 * <p>
 * This class is responsible for starting the Spring Boot application and initializing the necessary components.
 * It serves as the entry point for the application and configures the application context.
 * </p>
 *
 * @author <a href="https://soupaulodev.com.br">soupaulodev</a>
 */
@SpringBootApplication
public class ForumhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumhubApplication.class, args);
	}

}
