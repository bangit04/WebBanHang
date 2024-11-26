package vn.bang.WebBanHang;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebBanHangApplication {
	@Value("${jwt.secretKey}")
	private String jwtKey;
	public static void main(String[] args) {
		SpringApplication.run(WebBanHangApplication.class, args);
	}

	@PostConstruct
	public void Test(){
		System.out.println(jwtKey);
	}
}

