package com.eitan

import org.apache.geode.cache.CacheListener
import org.apache.geode.cache.Declarable
import org.apache.geode.cache.EntryEvent
import org.apache.geode.cache.RegionEvent
import org.apache.geode.pdx.PdxInstance
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class MyCacheListener implements CacheListener<Long, PdxInstance>, Declarable {

  Logger logger = LogManager.getLogger(MyCacheListener)

  @Override
  void afterCreate(EntryEvent<Long, PdxInstance> event) {
    logger.info "MyCacheListener::afterCreate::Key: ${event.key}; Value: ${event.newValue}"
  }

  @Override
  void afterUpdate(EntryEvent<Long, PdxInstance> event) {
    logger.info "MyCacheListener::afterUpdate::Key: ${event.key}; Updated Value: ${event.newValue}"
  }

  @Override
  void afterInvalidate(EntryEvent<Long, PdxInstance> event) {
    logger.info "MyCacheListener::afterInvalidate::Key: ${event.key}"
  }

  @Override
  void afterDestroy(EntryEvent<Long, PdxInstance> event) {
    logger.info "MyCacheListener::afterDestroy::Key: ${event.key}"
  }

  // region events..
  @Override void afterRegionInvalidate(RegionEvent<Long, PdxInstance> event) { }
  @Override void afterRegionDestroy(RegionEvent<Long, PdxInstance> event) { }
  @Override void afterRegionClear(RegionEvent<Long, PdxInstance> event) { }
  @Override void afterRegionCreate(RegionEvent<Long, PdxInstance> event) { }
  @Override void afterRegionLive(RegionEvent<Long, PdxInstance> event) { }

  // declarable interface..
  @Override void init(Properties props) { }
  @Override void close() { }
}
