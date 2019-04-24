package uk.os.opendata.zoomstack.android;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.maps.UiSettings;

public class MainActivity extends AppCompatActivity {

  private MapView mapView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
    setContentView(R.layout.activity_main);
    mapView = findViewById(R.id.mapView);
    mapView.onCreate(savedInstanceState);

    mapView.getMapAsync(mapboxMap -> {
      Resources res = getResources();
      UiSettings settings = mapboxMap.getUiSettings();
      settings.setLogoEnabled(false);
      settings.setAttributionEnabled(false);
      mapboxMap.setCameraPosition(new CameraPosition.Builder()
          .zoom(res.getInteger(R.integer.zoom))
          .bearing(res.getInteger(R.integer.bearing))
          .target(
              new LatLng(Double.valueOf(getString(R.string.lat)),
                  Double.valueOf(getString(R.string.lon)))
          )
          .build());
      mapboxMap.setStyle(new Style.Builder().fromUrl(getString(R.string.default_map_style)));
    });
  }

  @Override
  public void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  public void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  public void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
  }
}
