package com.eitan;

import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.RegionEvent;
import org.apache.geode.pdx.PdxInstance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class MyCacheListener implements CacheListener<Long, PdxInstance>, Declarable {

  Logger logger = LogManager.getLogger();

  @Override
  public void afterCreate(EntryEvent<Long, PdxInstance> event) {
    logger.info("Created instance: "+event.getNewValue());
  }

  @Override
  public void afterUpdate(EntryEvent<Long, PdxInstance> event) {

  }

  @Override
  public void afterInvalidate(EntryEvent<Long, PdxInstance> event) {

  }

  @Override
  public void afterDestroy(EntryEvent<Long, PdxInstance> event) {

  }

  @Override
  public void afterRegionInvalidate(RegionEvent<Long, PdxInstance> event) {

  }

  @Override
  public void afterRegionDestroy(RegionEvent<Long, PdxInstance> event) {

  }

  @Override
  public void afterRegionClear(RegionEvent<Long, PdxInstance> event) {

  }

  @Override
  public void afterRegionCreate(RegionEvent<Long, PdxInstance> event) {

  }

  @Override
  public void afterRegionLive(RegionEvent<Long, PdxInstance> event) {

  }

  @Override
  public void close() {

  }

  @Override
  public void init(Properties props) {

  }
}
