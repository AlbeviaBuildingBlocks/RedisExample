package com.albevia.redis.example;

import redis.clients.jedis.Jedis;

public class Publisher {

	public static void main(String[] args) {
		new Thread(new Runnable() {		
			private Jedis jedis;
			public void run() {
				jedis = new Jedis("localhost");
				System.out.println("Connected to Redis.");
				int val = 1;
				try {
					while (true) {
						System.out.println("send data=" + val);
						jedis.publish("sensor", Integer.toString(val));
						val++;
						if (val > 40) {
							val = 1;
						}
						Thread.sleep(2000);
					}
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}).start();
	}
}