package com.eramo.karpooler.adapters;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.MessageDTO;
import com.eramo.karpooler.models.dtos.TripPersonDTO;
import com.google.android.gms.plus.model.people.Person;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mohamed.Gaber on 11/7/2015.
 */
public class TripPeopleRecyclerViewAdapter extends RecyclerView.Adapter<TripPeopleRecyclerViewAdapter.ViewHolder> {

    private Fragment fragment;
    private List<TripPersonDTO> persons;

    public TripPeopleRecyclerViewAdapter(Fragment fragment, List<TripPersonDTO> persons) {
        this.fragment = fragment;
        this.persons = persons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trip_person, parent, false);

        TripPeopleRecyclerViewAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // get message dto
        TripPersonDTO personDTO = persons.get(position);

        // bind data
        holder.personImage.setImageBitmap(personDTO.getPersonImage());
        holder.personName.setText(personDTO.getPersonName());
        holder.numberOfFriendsInCommon.setText(personDTO.getNumberOfFriendsInCommon()+" "+fragment.getResources().getString(R.string.friends_in_common));

        if (personDTO.isDriver())
            holder.driverIcon.setVisibility(View.VISIBLE);

        for (Bitmap bitmap : personDTO.getFriendsInCommonSocialMedias()){

            holder.socialMediasList.addView(generateSocialMediaImageView(bitmap));
        }

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView personImage;
        public TextView personName;
        public TextView numberOfFriendsInCommon;
        public LinearLayout socialMediasList;
        public ImageView driverIcon;

        public ViewHolder(View view) {
            super(view);

            personImage = (CircleImageView) view.findViewById(R.id.imgv_person_image);
            personName = (TextView) view.findViewById(R.id.tv_person_name);
            numberOfFriendsInCommon = (TextView) view.findViewById(R.id.tv_person_number_of_friends_in_common);
            socialMediasList = (LinearLayout) view.findViewById(R.id.layout_person_common_friends_social_medias);
            driverIcon = (ImageView) view.findViewById(R.id.imgv_driver_icon);
        }
    }

    private ImageView generateSocialMediaImageView(Bitmap bitmap){

        ImageView imageView = new ImageView(fragment.getContext());

        // set src
        imageView.setImageBitmap(bitmap);

        // set layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 30, 0);
        imageView.setLayoutParams(layoutParams);

        return imageView;
    }

    public void addPersons(List<TripPersonDTO> addedPersons){
        persons.addAll(addedPersons);
        notifyDataSetChanged();
    }

    public void addPerson(TripPersonDTO person){
        persons.add(person);
        notifyDataSetChanged();
    }
}
