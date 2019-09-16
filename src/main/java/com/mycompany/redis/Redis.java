/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.redis;

import redis.clients.jedis.Jedis;

/**
 *
 * @author evans
 */
public class Redis {

    public static void main(String[] args) {
        //Connect to Redis server using localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection successful");

        //Checking server
        System.out.println("Getting response from the server: " + jedis.get("key1"));

        String cacheKey = "languages";

        //Adding a set as value
        jedis.sadd(cacheKey, "Java", "C#", "Python");//SADD

        //Getting all values in the set: SMEMBERS
        System.out.println("Languages: " + jedis.smembers(cacheKey));
        //Adding new values
        jedis.sadd(cacheKey, "Java", "Ruby");
        //Getting the values... it doesn't allow duplicates
        System.out.println("Languages: " + jedis.smembers(cacheKey));
    }

}
