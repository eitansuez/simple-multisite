package com.eitan

import org.apache.geode.cache.client.ClientCacheFactory

class DataLoader {

  static void main(String[] args) {

    def clientCache = new ClientCacheFactory()
        .set("cache-xml-file", "client-cache.xml")
        .create()

    def region = clientCache.getRegion("Customer")
    region.removeAll(region.keySetOnServer())

    def random = new Random()
    def customer = new Customer(firstName: 'Eitan', lastName: 'Suez')

    region.put(random.nextLong(), customer)

  }
}
