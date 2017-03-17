package com.eitan;

import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.RegionEvent;
import org.apache.geode.pdx.PdxInstance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class LoggingCacheListener implements CacheListener<Long, PdxInstance>, Declarable {

  private static final Logger logger = LogManager.getLogger(LoggingCacheListener.class);

  @Override
  public void afterCreate(EntryEvent<Long, PdxInstance> event) {
    logger.info("LoggingCacheListener::afterCreate::Key: " + event.getKey() + "; Value: " + event.getNewValue());
  }

  @Override
  public void afterUpdate(EntryEvent<Long, PdxInstance> event) {
    logger.info("LoggingCacheListener::afterUpdate::Key: " + event.getKey() + "; Updated Value: " + event.getNewValue());
  }

  @Override
  public void afterInvalidate(EntryEvent<Long, PdxInstance> event) {
    logger.info("LoggingCacheListener::afterInvalidate::Key: " + event.getKey());
  }

  @Override
  public void afterDestroy(EntryEvent<Long, PdxInstance> event) {
    logger.info("LoggingCacheListener::afterDestroy::Key: " + event.getKey());
  }

  // region events..
  @Override public void afterRegionInvalidate(RegionEvent<Long, PdxInstance> event) { }
  @Override public void afterRegionDestroy(RegionEvent<Long, PdxInstance> event) { }
  @Override public void afterRegionClear(RegionEvent<Long, PdxInstance> event) { }
  @Override public void afterRegionCreate(RegionEvent<Long, PdxInstance> event) { }
  @Override public void afterRegionLive(RegionEvent<Long, PdxInstance> event) { }

  // declarable interface..
  @Override public void init(Properties props) { }
  @Override public void close() { }
}
