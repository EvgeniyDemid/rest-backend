package quru.qa.restbackend.controller;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import quru.qa.restbackend.domain.LoginInfo;
import quru.qa.restbackend.domain.UserInfo;
import quru.qa.restbackend.exception.InvalidUserNameException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {
private Map<String,UserInfo> users = Map.of(
		"Dima", UserInfo.builder().userName("Dima").build(),
		"Olga",UserInfo.builder().userName("Olga").build(),
		"Ivan",UserInfo.builder().userName("Ivan").build()
);

	@PostMapping("user/login")
	@ApiOperation("authorization")
	public UserInfo doLogin(@RequestBody LoginInfo loginInfo) throws InvalidUserNameException {
		if(loginInfo.getUserName().equals("Jone")){
			return UserInfo.builder()
					.loginDate(String.valueOf(new Date()))
					.userName(loginInfo.getUserName())
					.build();
		}else {
			throw new InvalidUserNameException();
		}
	}
	@GetMapping("user/getAll")
	@ApiOperation("getAllUsers")
	public List<UserInfo> getAllUserInfo(){
		List <UserInfo> result = new ArrayList<>();
		for (Map.Entry<String, UserInfo> entry : users.entrySet()) {
			result.add(entry.getValue());
		}


		return users.entrySet()
				.stream()
				.map(Map.Entry::getValue)
				.collect(Collectors.toList());
	}

}
