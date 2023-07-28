package quru.qa.restbackend;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import quru.qa.restbackend.domain.UserInfo;

import static io.restassured.RestAssured.with;

public class BankControllerTest {


	static {
		RestAssured.baseURI = "http://localhost:8080";
	}

	private final RequestSpecification spec =
			with()
					.baseUri("http://localhost:8080")
					.basePath("/");

	@Test
	void bankControllerTest() {
		UserInfo[] userInfos = spec.get("user/getAll")
				.then()
				.statusCode(200)
				.extract()
				.response()
				.as(UserInfo[].class);
	}
}
