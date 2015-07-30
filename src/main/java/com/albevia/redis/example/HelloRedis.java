package com.albevia.redis.example;

import redis.clients.jedis.Jedis;

public class HelloRedis {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connected to Redis.");
		System.out.println("Setting values");
		System.out.println("set city=berlin");
		jedis.set("city", "berlin");
		System.out.println("set temperature=18");
		jedis.set("temperature", Integer.toString(18));
		
		System.out.println("getting values");
		String city = jedis.get("city");
		String temperature = jedis.get("temperature");
		System.out.println("city="+city+", temperature="+temperature);
		
		System.out.println("Done");
		jedis.close();
	}

}
