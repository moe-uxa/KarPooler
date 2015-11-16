package com.eramo.karpooler.activities;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import com.eramo.karpooler.R;
import com.eramo.karpooler.adapters.InviteMethodsRecyclerViewAdapter;
import com.eramo.karpooler.models.dtos.InviteMethodDTO;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import java.util.ArrayList;
import java.util.List;

public class InviteFriendsActivity extends BaseActivity {

    private InviteMethodsRecyclerViewAdapter inviteMethodsRecyclerViewAdapter;

    // invite methods ids
    private final int SMS_INVITE_METHOD_ID = 0;
    private final int TWITTER_INVITE_METHOD_ID = 1;
    private final int FACEBOOK_INVITE_METHOD_ID = 2;
    private final int GOOGLE_PLUS_INVITE_METHOD_ID = 3;
    private final int EMAIL_INVITE_METHOD_ID = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // set tool bar title
        getSupportActionBar().setTitle(getResources().getString(R.string.invite_friends));

        // prepare invite methods recycler view
        prepareRecyclerView();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }


    private void prepareRecyclerView() {

        RecyclerView inviteMethodsRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_invite_methods);
        inviteMethodsRecyclerView.setHasFixedSize(true);

        // set recycler view divider
        inviteMethodsRecyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .drawable(R.drawable.divider)
                        .build());

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        inviteMethodsRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        inviteMethodsRecyclerViewAdapter = new InviteMethodsRecyclerViewAdapter(getInviteMethodsListItems(), this);
        inviteMethodsRecyclerView.setAdapter(inviteMethodsRecyclerViewAdapter);

    }

    private List<InviteMethodDTO> getInviteMethodsListItems() {

        // get invite friends methods string array
        String[] inviteMethodsArray = getResources().getStringArray(R.array.invite_friends_methods);

        List<InviteMethodDTO> inviteMethodsList = new ArrayList<>();

        for (int index = 0; index < inviteMethodsArray.length; index++) {

            switch (index) {

                case SMS_INVITE_METHOD_ID: // with SMS

                    inviteMethodsList.add(new InviteMethodDTO(SMS_INVITE_METHOD_ID, R.drawable.ic_sms_green_bg, inviteMethodsArray[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }

                    }));

                    break;

                case TWITTER_INVITE_METHOD_ID: // with Twitter

                    inviteMethodsList.add(new InviteMethodDTO(TWITTER_INVITE_METHOD_ID, R.drawable.ic_twitter_blue_bg, inviteMethodsArray[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }

                    }));

                    break;

                case FACEBOOK_INVITE_METHOD_ID: // with Facebook

                    inviteMethodsList.add(new InviteMethodDTO(FACEBOOK_INVITE_METHOD_ID, R.drawable.ic_fb_blue_bg, inviteMethodsArray[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }

                    }));

                    break;

                case GOOGLE_PLUS_INVITE_METHOD_ID: // with Google+

                    inviteMethodsList.add(new InviteMethodDTO(GOOGLE_PLUS_INVITE_METHOD_ID, R.drawable.ic_gmail_red_bg, inviteMethodsArray[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }

                    }));

                    break;

                case EMAIL_INVITE_METHOD_ID: // with Email

                    inviteMethodsList.add(new InviteMethodDTO(EMAIL_INVITE_METHOD_ID, R.drawable.ic_email_berble_bg, inviteMethodsArray[index], new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }

                    }));

                    break;
            }

        }

        return inviteMethodsList;
    }

}
