package com.eramo.karpooler.fragments;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.directions.route.Route;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.ViewTripActivity;
import com.eramo.karpooler.helpers.GeneratePeopleImageHelper;
import com.eramo.karpooler.models.dtos.DriverDTO;
import com.eramo.karpooler.models.dtos.TripDetailsDTO;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TripDetailsFragment extends Fragment implements OnMapReadyCallback, RoutingListener {

    private GoogleMap mMap;
    private ViewTripActivity activity;
    private TripDetailsDTO tripDetailsDTO;

    // map constants
    private final int MAP_ROUTE_LINE_WIDTH = 10;
    private final int MAP_BOUNDS_WIDTH = 400;
    private final int MAP_BOUNDS_HEIGHT = 300;


    public TripDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trip_details, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get Activity instance
        activity = (ViewTripActivity) getActivity();

        // create Test Data
        createTestData();

        // 1. prepare map
        prepareMap();

        // 2. prepare trip details section
        prepareTripDetailsSection();

        // 3. prepare passengers section
        preparePassengersSection();

        // 4. prepare drivers section
        prepareDriversSection();

    }


    private void prepareMap() {

        // add map fragment to map container
        SupportMapFragment mMapFragment = SupportMapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map_container, mMapFragment);
        fragmentTransaction.commit();

        // get notified when the map is ready to be used.
        mMapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // update camera view
        LatLngBounds area = new LatLngBounds(tripDetailsDTO.getStartPoint(), tripDetailsDTO.getEndPoint());
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(area, MAP_BOUNDS_WIDTH, MAP_BOUNDS_HEIGHT, 0));

        // start routing
        Routing routing = new Routing.Builder()
                .travelMode(Routing.TravelMode.DRIVING)
                .withListener(this)
                .alternativeRoutes(true)
                .waypoints(tripDetailsDTO.getStartPoint(), tripDetailsDTO.getEndPoint())
                .build();
        routing.execute();

    }

    @Override
    public void onRoutingFailure() {

    }

    @Override
    public void onRoutingStart() {

    }

    @Override
    public void onRoutingSuccess(ArrayList<Route> arrayList, int i) {

        // draw route
        PolylineOptions polyOptions = new PolylineOptions();
        polyOptions.color(getResources().getColor(R.color.colorMapRoute));
        polyOptions.width(MAP_ROUTE_LINE_WIDTH);
        polyOptions.addAll(arrayList.get(i).getPoints());
        mMap.addPolyline(polyOptions);

        // marker icon from resource
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker);

        // add marker at start
        mMap.addMarker(new MarkerOptions().position(tripDetailsDTO.getStartPoint()).icon(icon));

        // add marker at end
        mMap.addMarker(new MarkerOptions().position(tripDetailsDTO.getEndPoint()).icon(icon));

    }

    @Override
    public void onRoutingCancelled() {

    }

    private void prepareTripDetailsSection(){

        // view trip from - to location
        TextView fromToLocation = (TextView) activity.findViewById(R.id.tv_from_to_location);
        fromToLocation.setText(tripDetailsDTO.getFrom()+" - "+tripDetailsDTO.getTo());

        // view trip date
        TextView tripDateTime = (TextView) activity.findViewById(R.id.tv_trip_date_time);
        tripDateTime.setText(tripDetailsDTO.getTripDate());

        // view trip number of seats available
        TextView tripSeatsAvail = (TextView) activity.findViewById(R.id.tv_trip_seats_available);
        tripSeatsAvail.setText(tripDetailsDTO.getNumberOfSeatsAvailable()+" "+getResources().getString(R.string.seats_left));
    }

    private void preparePassengersSection(){

        LinearLayout tripPassengersList = (LinearLayout) activity.findViewById(R.id.layout_people);

        // add passengers circle images
        List<Bitmap> passengers = tripDetailsDTO.getPassengers();
        int passengersSize = passengers.size();

        // if number of passengers > 5 just view 4 images
        if (passengersSize > 5)
            passengersSize = 4;

        for (int i = 0; i< passengersSize; i++){

            // get passenger bitmap
            Bitmap bitmap = passengers.get(i);

            // set ImageView src
            CircleImageView circleImageView = GeneratePeopleImageHelper.generateCircleImageView(bitmap, this, R.dimen.card_user_image_size, R.dimen.trip_details_passenger_image_margin_right);
            tripPassengersList.addView(circleImageView);
        }

        if (tripDetailsDTO.getPassengers().size() > 5){

            // view more button with number of more passengers to view
            RelativeLayout moreLayout = GeneratePeopleImageHelper.createMoreButton(passengers.get(4), passengers.size() - 5, this, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar snackbar = Snackbar.make(v, "more friends", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            });

            tripPassengersList.addView(moreLayout);
        }


    }

    private void prepareDriversSection(){

        LinearLayout driversLayout = (LinearLayout) activity.findViewById(R.id.layout_drivers);

        for (DriverDTO driverDTO : tripDetailsDTO.getDrivers()){

            driversLayout.addView(generateDriverLayout(driverDTO));
        }

    }

    private LinearLayout generateDriverLayout(DriverDTO driverDTO){

        // inflate custom layout
        LinearLayout driverLayout = (LinearLayout) getLayoutInflater(null).inflate(R.layout.driver_custom_layout, null);

        // set layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        driverLayout.setLayoutParams(layoutParams);

        // view driver image
        ImageView driverImage = (ImageView) driverLayout.findViewById(R.id.imgv_driver_image);
        driverImage.setImageBitmap(driverDTO.getDriverImage());

        // view driver name
        TextView driverName = (TextView) driverLayout.findViewById(R.id.tv_driver_name);
        driverName.setText(driverDTO.getDriverName());

        return driverLayout;
    }


    private void createTestData(){

        tripDetailsDTO = new TripDetailsDTO();

        // trip map
        tripDetailsDTO.setStartPoint(new LatLng(30.085802, 31.293880));
        tripDetailsDTO.setEndPoint(new LatLng(30.096389, 31.324865));

        // trip details
        tripDetailsDTO.setTripId(1);
        tripDetailsDTO.setTripName("Work Trip");
        tripDetailsDTO.setFrom("Los Angles");
        tripDetailsDTO.setTo("New York");
        tripDetailsDTO.setTripDate("Sat, 10 July (09:00 pm)");
        tripDetailsDTO.setNumberOfSeatsAvailable(4);

        // trip passengers
        List<Bitmap> passengers = new ArrayList<>();
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person4)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person5)).getBitmap());
        passengers.add(((BitmapDrawable) getResources().getDrawable(R.drawable.person6)).getBitmap());
        tripDetailsDTO.setPassengers(passengers);

        // trip drivers
        List<DriverDTO> drivers = new ArrayList<>();

        DriverDTO driverDTO1 = new DriverDTO();
        driverDTO1.setDriverName("Mohamed Ahmed");
        driverDTO1.setDriverImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());

        DriverDTO driverDTO2 = new DriverDTO();
        driverDTO2.setDriverName("Ali Esmael");
        driverDTO2.setDriverImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person5)).getBitmap());

        drivers.add(driverDTO1);
        drivers.add(driverDTO2);

        tripDetailsDTO.setDrivers(drivers);

    }


}
