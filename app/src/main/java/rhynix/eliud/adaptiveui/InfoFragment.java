package rhynix.eliud.adaptiveui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InfoFragment extends Fragment {

    SupportMapFragment mapFragment;

    public InfoFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info,container,false);
    }
    private void loadMap(GoogleMap googleMap){
        if (googleMap !=null){
            BitmapDescriptor defaultMarker = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
            LatLng sceneryPosition = new LatLng(44.22438242, 6.944561);
            mapFragment.getMap().addMarker(new MarkerOptions()
            .position(sceneryPosition)
            .icon(defaultMarker));
        }

    }
    private void setUpMapIfNeeded(){
        if (mapFragment == null){
            mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
            if (mapFragment !=null){
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap map) {
                        loadMap(map);
                    }
                });
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpMapIfNeeded();
    }
}
