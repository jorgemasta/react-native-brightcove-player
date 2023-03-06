package com.matejdr.brightcoveimaplayer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.HashMap;
import java.util.Map;

public class BrightcovePlayerViewManager extends SimpleViewManager<BrightcovePlayerView> {
  public static final String REACT_CLASS = "BrightcovePlayerView";
  public static final int COMMAND_SEEK_TO = 1;
  public static final int COMMAND_PLAY = 2;
  public static final int COMMAND_PAUSE = 3;
  public static final int COMMAND_STOP_PLAYBACK = 4;
  public static final int COMMAND_TOGGLE_FULLSCREEN = 5;
  public static final int COMMAND_TOGGLE_IN_VIEW_PORT = 6;
  public static final String EVENT_ADS_LOADED = "ads_loaded";
  public static final String EVENT_READY = "ready";
  public static final String EVENT_PLAY = "play";
  public static final String EVENT_PAUSE = "pause";
  public static final String EVENT_END = "end";
  public static final String EVENT_PROGRESS = "progress";
  public static final String EVENT_ENTER_FULLSCREEN = "enter_fullscreen";
  public static final String EVENT_EXIT_FULLSCREEN = "exit_fullscreen";
  public static final String EVENT_CHANGE_DURATION = "change_duration";
  public static final String EVENT_UPDATE_BUFFER_PROGRESS = "update_buffer_progress";

  private final ReactApplicationContext applicationContext;

  public BrightcovePlayerViewManager(ReactApplicationContext context) {
    super();
    this.applicationContext = context;
  }

  @Override
  @NonNull
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  @NonNull
  public BrightcovePlayerView createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new BrightcovePlayerView(reactContext, applicationContext);
  }

  @ReactProp(name = "settings")
  public void setSettings(BrightcovePlayerView view, ReadableMap settings) {
    view.setSettings(settings);
  }

  @ReactProp(name = "policyKey")
  public void setPolicyKey(BrightcovePlayerView view, String policyKey) {
    view.setPolicyKey(policyKey);
  }

  @ReactProp(name = "accountId")
  public void setAccountId(BrightcovePlayerView view, String accountId) {
    view.setAccountId(accountId);
  }

  @ReactProp(name = "videoId")
  public void setVideoId(BrightcovePlayerView view, String videoId) {
    view.setVideoId(videoId);
  }

  @ReactProp(name = "autoPlay")
  public void setAutoPlay(BrightcovePlayerView view, boolean autoPlay) {
    view.setAutoPlay(autoPlay);
  }

  @ReactProp(name = "play")
  public void setPlay(BrightcovePlayerView view, boolean play) {
    view.setPlay(play);
  }

  @ReactProp(name = "disableDefaultControl")
  public void setDisableDefaultControl(BrightcovePlayerView view, boolean disableDefaultControl) {
    view.setDisableDefaultControl(disableDefaultControl);
  }

  @ReactProp(name = "volume")
  public void setVolume(BrightcovePlayerView view, float volume) {
    view.setVolume(volume);
  }

  @ReactProp(name = "bitRate")
  public void setBitRate(BrightcovePlayerView view, float bitRate) {
    view.setBitRate((int) bitRate);
  }

  @ReactProp(name = "adVideoLoadTimeout")
  public void setAdVideoLoadTimeout(BrightcovePlayerView view, int adVideoLoadTimeout) {
    view.setAdVideoLoadTimeout((int) adVideoLoadTimeout);
  }

  @ReactProp(name = "playbackRate")
  public void setPlaybackRate(BrightcovePlayerView view, float playbackRate) {
    view.setPlaybackRate(playbackRate);
  }

  @ReactProp(name = "fullscreen")
  public void setFullscreen(BrightcovePlayerView view, boolean fullscreen) {
    view.setFullscreen(fullscreen);
  }

  @Override
  public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of(
      "seekTo",
      COMMAND_SEEK_TO,
      "play",
      COMMAND_PLAY,
      "pause",
      COMMAND_PAUSE,
      "stopPlayback",
      COMMAND_STOP_PLAYBACK,
      "toggleFullscreen",
      COMMAND_TOGGLE_FULLSCREEN,
      "toggleInViewPort",
      COMMAND_TOGGLE_IN_VIEW_PORT
    );
  }

  @Override
  public void receiveCommand(BrightcovePlayerView view, int commandType, @Nullable ReadableArray args) {
    Assertions.assertNotNull(view);
    Assertions.assertNotNull(args);
    switch (commandType) {
      case COMMAND_SEEK_TO: {
        view.seekTo((int) (args.getDouble(0) * 1000));
        return;
      }
      case COMMAND_PLAY: {
        view.play();
        return;
      }
      case COMMAND_PAUSE: {
        view.pause();
        return;
      }
      case COMMAND_STOP_PLAYBACK: {
        view.stopPlayback();
        return;
      }
      case COMMAND_TOGGLE_FULLSCREEN: {
        view.toggleFullscreen((boolean) (args.getBoolean(0)));
        return;
      }
      case COMMAND_TOGGLE_IN_VIEW_PORT: {
        view.toggleInViewPort((boolean) (args.getBoolean(0)));
        return;
      }
    }
  }

  @Override
  public @Nullable
  Map<String, Object> getExportedCustomDirectEventTypeConstants() {
    Map<String, Object> map = new HashMap<>();
    map.put(EVENT_ADS_LOADED, (Object) MapBuilder.of("registrationName", "onAdsLoaded"));
    map.put(EVENT_READY, (Object) MapBuilder.of("registrationName", "onReady"));
    map.put(EVENT_PLAY, (Object) MapBuilder.of("registrationName", "onPlay"));
    map.put(EVENT_PAUSE, (Object) MapBuilder.of("registrationName", "onPause"));
    map.put(EVENT_END, (Object) MapBuilder.of("registrationName", "onEnd"));
    map.put(EVENT_PROGRESS, (Object) MapBuilder.of("registrationName", "onProgress"));
    map.put(EVENT_CHANGE_DURATION, (Object) MapBuilder.of("registrationName", "onChangeDuration"));
    map.put(EVENT_UPDATE_BUFFER_PROGRESS, (Object) MapBuilder.of("registrationName", "onUpdateBufferProgress"));
    map.put(EVENT_ENTER_FULLSCREEN, (Object) MapBuilder.of("registrationName", "onEnterFullscreen"));
    map.put(EVENT_EXIT_FULLSCREEN, (Object) MapBuilder.of("registrationName", "onExitFullscreen"));
    return map;
  }
}
