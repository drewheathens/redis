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

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //Connect to Redis server using localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection successful");

        //Checking server

        String cacheKey = "languages";
        String json = "{\"movieID\":\"1\",\"title\":\"Alpha Dog\",\"genre\":\"Crime|Drama\"}";

        //Adding a set as value
        jedis.sadd(cacheKey, "Java", "C#", "Python");//SADD

        //Getting all values in the set: SMEMBERS
        System.out.println("Languages: " + jedis.smembers(cacheKey));
        //Adding new values
        jedis.sadd(cacheKey, "Java", "Ruby");
        jedis.rpush("mylist", "4", "7", "seeven"); // insert into key mylist
        //Getting the values... it doesn't allow duplicates
        System.out.println("Languages: " + jedis.smembers(cacheKey));// adds element Ruby to the set

        jedis.sadd(json, json);//SADD


        System.out.println("JSON : " + jedis.smembers(json));

        System.out.println("Getting response from the server: " + jedis.get("key1"));
        System.out.println("response from the server: " + jedis.lrange("mylist", 0, -1));// Returns the specified elements of the list stored at key, was accessed by LRANGE mylist 0 -1(redis-cli)
        // RPUSH mylist "four"



    }

}
