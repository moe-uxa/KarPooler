package com.eramo.karpooler.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.eramo.karpooler.R;
import com.eramo.karpooler.adapters.BrandsRecyclerViewAdapter;
import com.eramo.karpooler.apis.CarSelectionAPI;
import com.eramo.karpooler.helpers.Constants;
import com.eramo.karpooler.models.dtos.BrandDTO;
import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class SelectBrandActivity extends BaseActivity implements SearchView.OnQueryTextListener{

    private BrandsRecyclerViewAdapter brandsRecyclerViewAdapter;
    private CarSelectionAPI carSelectionAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_brand);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // set toolbar title
        getSupportActionBar().setTitle(getResources().getString(R.string.your_car));

        // instantiate car selection API
        carSelectionAPI = new CarSelectionAPI();

        // prepare ui
        prepareUIControllers();

        // load brands
        loadBrands();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_brand_selection, menu);

        // SearchView set on query text listener
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }

    private void loadBrands(){

        carSelectionAPI.loadBrands(new ServiceSuccessCallback<List<BrandDTO>>() {
            @Override
            public void onSuccess(List<BrandDTO> response) {

                brandsRecyclerViewAdapter.setBrands(response);
                brandsRecyclerViewAdapter.notifyDataSetChanged();
            }
        }, new ServiceErrorCallback<ErrorDTO>() {
            @Override
            public void onError(ErrorDTO errorResponse) {

            }
        });

    }

    private void prepareUIControllers(){

        RecyclerView brandRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_brands);
        brandRecyclerView.setHasFixedSize(true);

        // set recycler view divider
        brandRecyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .drawable(R.drawable.divider)
                        .marginResId(R.dimen.dividerLeftMargin, R.dimen.dividerRightMargin)
                        .build());

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        brandRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        brandsRecyclerViewAdapter = new BrandsRecyclerViewAdapter(new ArrayList<BrandDTO>(), this);
        brandRecyclerView.setAdapter(brandsRecyclerViewAdapter);


    }

    public void setSelectedBrand(BrandDTO selectedBrand) {

        Bundle extra = new Bundle();
        extra.putParcelable(Constants.SELECTED_BRAND_EXTRA_KEY, selectedBrand);
        Intent returnIntent = new Intent();
        returnIntent.putExtras(extra);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
