package com.car.rental.helper;

import java.util.UUID;

public class RandomIdGenerator {
	
	public static String generateRandomId() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
}
