package com.albevia.redis.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subscriber {

	private static Jedis jedis;

	public static void main(String[] args) {
		jedis = new Jedis("localhost");
		System.out.println("Connected to Redis.");
		jedis.subscribe(new JedisPubSub() {

			@Override
			public void onMessage(String channel, String message) {
				System.out.println("received: " + message);
			}
			
		}, "sensor");
	}

}
