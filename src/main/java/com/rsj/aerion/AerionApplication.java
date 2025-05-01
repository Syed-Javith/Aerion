package com.rsj.aerion;

import com.rsj.aerion.inventory.models.OS;
import com.rsj.aerion.inventory.models.PhysicalNode;
import com.rsj.aerion.security.Parser;
import com.rsj.aerion.security.SecurityMapper;
import com.rsj.aerion.security.SecurityParser;
import com.rsj.aerion.security.authorization.AuthorizationParser;
import com.rsj.aerion.security.authorization.RoleMapper;
import com.rsj.aerion.security.utils.Crypto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HexFormat;
import java.util.Map;

@SpringBootApplication
public class AerionApplication {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = SpringApplication.run(AerionApplication.class, args);
		Parser securityParser = context.getBean(SecurityParser.class);
		Parser authorizationParser = context.getBean(AuthorizationParser.class);
		try {
			securityParser.parse();
			authorizationParser.parse();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		Map<String, String> configMap = (Map<String, String>) context.getBean("configMap");
		configMap.forEach((key, value) -> System.out.println(key + " " + value));
		System.out.println(context.getBean(RoleMapper.class));

		//System.out.println(HexFormat.of().formatHex(Crypto.generateKey().getEncoded()));
	}

}
