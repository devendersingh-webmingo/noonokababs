package com.webmingo.noonokababs.Fragments.DrawerLayoutFragment.Address;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.rjesture.startupkit.AppTools;
import com.webmingo.noonokababs.Adapters.SearchAdapter;
import com.webmingo.noonokababs.ModelRepo.RequestRepo.AddAddressRequest;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.AddNewAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.CityRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.CountryRepoID;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.GetUserAddressRepo;
import com.webmingo.noonokababs.ModelRepo.Responsee.UserAddressBook.StateRepoID;
import com.webmingo.noonokababs.R;
import com.webmingo.noonokababs.ViewPresenter.UserAddressBook.AddUserAddressPresenter;

import java.io.IOException;
import java.util.List;

import de.mateware.snacky.Snacky;

public class MapsFragment extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMapLongClickListener,
        GoogleMap.OnMarkerClickListener, AddUserAddressPresenter.AddUserAddressView {


    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
    private double longitude;
    private double latitude;
    private GoogleApiClient googleApiClient;

    private Geocoder geocoder;

    FloatingActionButton fab_home_my_location;

    CardView card_home_details;
    TextView addressTV, confirm_location_proceed;

    String streetAddress, city, state, country, postalCode, knownName;
    String CountryCode;

    RadioButton Billing, Shipping, Yes, No;

    String Addreesstype, setasdefault, Yeskey;

    String cityid,stateid,countryid;



    AddUserAddressPresenter presenter;

    EditText numberET;

    NavController navController;



  /*  private OnMapReadyCallback callback = new OnMapReadyCallback() {


        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        setui(view);
        fab_home_my_location = view.findViewById(R.id.fab_home_my_location);
        card_home_details = view.findViewById(R.id.card_home_details);
        presenter = new AddUserAddressPresenter(this);
        addressTV = view.findViewById(R.id.addressTV);
        Billing = view.findViewById(R.id.Billing);
        Yes = view.findViewById(R.id.Yes);
        No = view.findViewById(R.id.No);
        numberET = view.findViewById(R.id.numberET);
        Shipping = view.findViewById(R.id.Shipping);
        confirm_location_proceed = view.findViewById(R.id.confirm_location_proceed);
        confirm_location_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getContext(), CountryCode + "", Toast.LENGTH_SHORT).show();

                presenter.GetCountryID(getContext(), CountryCode);


                Log.e("taggg",  "\n" + "\n" + city + "\n" + state + "\n" + country );

            }
        });
        fab_home_my_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentLocation();

            }
        });
        return view;

    }

    private void setui(View view) {
        geocoder = new Geocoder(getContext());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Initializing googleApiClient
        googleApiClient = new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        Dexter.withContext(getContext().getApplicationContext())
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        CheckPermission();

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();


                    }
                }).check();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

      /*  if (srf != null) {
            srf.getMapAsync(callback);
        }*/
    }

    public void CheckPermission() {

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }


    }


    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        Log.d(TAG, "onMapLongClick: " + latLng.toString());

        try {
            mMap.clear();


            List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            if (addresses.size() > 0) {
                card_home_details.setVisibility(View.VISIBLE);

                BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.ic_marker);
                Address address = addresses.get(0);
                String streetAddress = address.getAddressLine(0);
                addressTV.setText(streetAddress);


                city = address.getLocality();
                state = address.getAdminArea();
                country = address.getCountryName();
                postalCode = address.getPostalCode();
                knownName = address.getFeatureName();
                CountryCode = addresses.get(0).getCountryCode();

                //DestinationAdreess=streetAddress;
                //Config.getInstance().setDname(streetAddress);
                // placeBean.setLatitude(String.valueOf(place.getLatLng().latitude));
                addressTV.setText(streetAddress);
                //DestinationAdreess=streetAddress;
                //Config.getInstance().setDname(streetAddress);
                // placeBean.setLatitude(String.valueOf(place.getLatLng().latitude));
                Toast.makeText(getContext(), streetAddress, Toast.LENGTH_SHORT).show();
                // placeBean.setLongitude(String.valueOf(place.getLatLng().longi
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Destination Address !!").snippet(streetAddress).icon(icon)
                        .draggable(true)


                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // mMap.addMarker(new MarkerOptions().position(latLng).draggable(true));


    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        getCurrentLocation();

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        card_home_details.setVisibility(View.GONE);

        // Toast.makeText(getContext(), "onMarkerClick", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {
        //  Toast.makeText(getActivity(), "onMarkerDragStart", Toast.LENGTH_SHORT).show();
        card_home_details.setVisibility(View.GONE);

    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {

        //Toast.makeText(getActivity(), "onMarkerDrag", Toast.LENGTH_SHORT).show();
        card_home_details.setVisibility(View.GONE);

    }

    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {
        // getting the Co-ordinates
        latitude = marker.getPosition().latitude;
        longitude = marker.getPosition().longitude;

        //move to current position
        moveMap();
    }


    //Getting current location
    private void getCurrentLocation() {
        mMap.clear();
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (location != null) {
            //Getting longitude and latitude
            longitude = location.getLongitude();
            latitude = location.getLatitude();

            //moving the map to location
            moveMap();
        }
    }

    private void moveMap() {
        /**
         * Creating the latlng object to store lat, long coordinates
         * adding marker to map
         * move the camera with animation
         */

        LatLng latLng = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .draggable(true)
                .title("You are here.....!!"));
      /*  mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        mMap.getUiSettings().setZoomControlsEnabled(true);
*/
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));


        try {
            mMap.clear();
            card_home_details.setVisibility(View.VISIBLE);
            List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            if (addresses.size() > 0) {
                BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.ic_marker);
                Address address = addresses.get(0);
                streetAddress = address.getAddressLine(0);
                //get current province/City
                //get country
                // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                city = address.getLocality();
                state = address.getAdminArea();
                country = address.getCountryName();
                postalCode = address.getPostalCode();
                knownName = address.getFeatureName();
                CountryCode = addresses.get(0).getCountryCode();

                //DestinationAdreess=streetAddress;
                //Config.getInstance().setDname(streetAddress);
                // placeBean.setLatitude(String.valueOf(place.getLatLng().latitude));
                Toast.makeText(getContext(), CountryCode, Toast.LENGTH_SHORT).show();
                addressTV.setText(streetAddress);
                // placeBean.setLongitude(String.valueOf(place.getLatLng().longi
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Destination Address !!").snippet(streetAddress).icon(icon)
                        .draggable(true)


                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // googleMapOptions.mapType(googleMap.MAP_TYPE_HYBRID)
        //    .compassEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng india = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(india).title("Marker in India"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india));
        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapLongClickListener(this);


    }

    @Override
    public void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    @Override
    public void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }


    @Override
    public void onGetUserAddressError(String message) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }

    @Override
    public void onAddAddressSuccess(AddNewAddressRepo response, String message) {


        if (message.equalsIgnoreCase("ok"))
        {
            navController.navigate(R.id.addressBookFragment);
        }

/*

        Toast.makeText(getContext(), message+"", Toast.LENGTH_SHORT).show();

        Snacky.builder()
                .setActivity(getActivity())
                .setText(message)
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
*/

    }

    @Override
    public void onCountrySuccess(CountryRepoID response, String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();


        if (message.equalsIgnoreCase("ok")) {
            countryid= String.valueOf(response.getData().getCountry().getId());
            if (state.equalsIgnoreCase("null"))
            {

                Toast.makeText(getContext(), "State name is not getting", Toast.LENGTH_LONG).show();

            }else {
                presenter.GetStateID(getContext(), state);

            }



        }
    }

    @Override
    public void onStateSuccess(StateRepoID response, String message) {
        if (message.equalsIgnoreCase("ok")) {
            stateid= String.valueOf(response.getData().getState().getId());

            Toast.makeText(getContext(), response.getData().getState().getId() + "", Toast.LENGTH_SHORT).show();

            if (city.equalsIgnoreCase("null"))
            {

                Toast.makeText(getContext(), "City name is not getting", Toast.LENGTH_LONG).show();

            }else {
                presenter.GetCityID(getContext(), city);

            }




        }
    }

    @Override
    public void onCitySuccess(CityRepoID response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            cityid= String.valueOf(response.getData().getCity().getId());

            AddNewAddrees();


        }
    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showRequestDialog(getActivity());

        } else {
            AppTools.hideDialog();

        }
    }

    @Override
    public void onGetUserAddressFailure(Throwable t) {
        Snacky.builder()
                .setActivity(getActivity())
                .setText(t.getLocalizedMessage())
                .setTextColor(getResources().getColor(R.color.white))
                .warning()
                .show();
    }


    public void AddNewAddrees() {

        String number=numberET.getText().toString().trim();
        if (Billing.isChecked()) {

            Addreesstype = "Billing";
        } else if (Shipping.isChecked()) {

            Addreesstype = "Shipping";

        }

        if (Yes.isChecked()) {

            setasdefault = "Yes";
        } else if (No.isChecked()) {

            setasdefault = "No";

        }

        if (number.isEmpty())
        {
            Snacky.builder()
                    .setActivity(getActivity())
                    .setText("Enter Contact Number")
                    .setTextColor(getResources().getColor(R.color.white))
                    .warning()
                    .show();

        }else if (cityid.equalsIgnoreCase("null"))
        {
            Toast.makeText(getContext(), "City name is not getting", Toast.LENGTH_SHORT).show();
        }
        else if (stateid.equalsIgnoreCase("null"))
        {
            Toast.makeText(getContext(), "state name is not getting", Toast.LENGTH_SHORT).show();
        }else if (countryid.equalsIgnoreCase("null"))
        {
            Toast.makeText(getContext(), "country name is not getting", Toast.LENGTH_SHORT).show();
        }else {
            AddAddressRequest addAddressRequest=new AddAddressRequest(streetAddress,number,countryid,stateid,cityid,postalCode,Addreesstype,setasdefault);
            presenter.AddNewAddress(getContext(),addAddressRequest);
        }



        Toast.makeText(getContext(), postalCode, Toast.LENGTH_SHORT).show();


    }
}