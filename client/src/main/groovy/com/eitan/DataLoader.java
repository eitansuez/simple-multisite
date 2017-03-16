package com.eitan;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

import java.util.Random;

public class DataLoader {

  public static void main(String[] args) {

    ClientCache clientCache = new ClientCacheFactory()
        .set("cache-xml-file", "client-cache.xml")
        .create();

    Region<Long, Customer> region = clientCache.getRegion("Customer");

    region.removeAll(region.keySetOnServer());

    Random random = new Random();
    region.put(random.nextLong(), new Customer("Eitan", "Suez"));

  }
}
