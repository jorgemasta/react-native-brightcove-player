package jp.manse;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;


public class BrightcovePlayerPosterViewManager extends SimpleViewManager<BrightcovePlayerPosterView> {
  public static final String REACT_CLASS = "BrightcovePlayerPosterView";

  private final ReactApplicationContext applicationContext;

  public BrightcovePlayerPosterViewManager(ReactApplicationContext context) {
    this.applicationContext = context;
  }


  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public BrightcovePlayerPosterView createViewInstance(ThemedReactContext ctx) {
    return new BrightcovePlayerPosterView(ctx, applicationContext);
  }

  @ReactProp(name = "accountId")
  public void setAccountId(BrightcovePlayerPosterView view, String accountId) {
    view.setAccountId(accountId);
  }

  @ReactProp(name = "policyKey")
  public void setPolicyKey(BrightcovePlayerPosterView view, String policyKey) {
    view.setPolicyKey(policyKey);
  }

  @ReactProp(name = "videoId")
  public void setVideoId(BrightcovePlayerPosterView view, String videoId) {
    view.setVideoId(videoId);
  }

  @ReactProp(name = "resizeMode")
  public void setResizeMode(BrightcovePlayerPosterView view, String resizeMode) {
    view.setResizeMode(resizeMode);
  }
}
