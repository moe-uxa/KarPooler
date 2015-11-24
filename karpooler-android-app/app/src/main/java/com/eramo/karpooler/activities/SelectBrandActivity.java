package com.eramo.karpooler.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import com.eramo.karpooler.R;
import com.eramo.karpooler.adapters.BrandsRecyclerViewAdapter;
import com.eramo.karpooler.application.MyApplication;
import com.eramo.karpooler.helpers.Constants;
import com.eramo.karpooler.models.dtos.BrandDTO;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SelectBrandActivity extends BaseActivity implements SearchView.OnQueryTextListener {

    private BrandsRecyclerViewAdapter brandsRecyclerViewAdapter;

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

        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }

    private void loadBrands() {

        // create test data
        List<BrandDTO> brandDTOList = createTestData();

        brandsRecyclerViewAdapter.setBrands(brandDTOList);
        brandsRecyclerViewAdapter.notifyDataSetChanged();

    }

    private void prepareUIControllers() {

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

    private List<BrandDTO> createTestData() {

        List<BrandDTO> brandDTOList = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {

            BrandDTO brandDTO = new BrandDTO();
            brandDTO.setBrandId(i);

            switch (i) {
                case 1:
                    brandDTO.setBrandName("Aston Martin");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/aston.png"));
                    break;
                case 2:
                    brandDTO.setBrandName("Audi");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/audi.png"));
                    break;
                case 3:
                    brandDTO.setBrandName("BMW");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/bmw.png"));
                    break;
                case 4:
                    brandDTO.setBrandName("Bentley");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/bent.png"));
                    break;
                case 5:
                    brandDTO.setBrandName("Chevrolet");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/c.png"));
                    break;
                case 6:
                    brandDTO.setBrandName("FIAT");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/fiat.png"));
                    break;
                case 7:
                    brandDTO.setBrandName("Ford");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/ford.png"));
                    break;
                case 8:
                    brandDTO.setBrandName("Jaguar");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/jaguar.png"));
                    break;
            }


            brandDTOList.add(brandDTO);

        }

        return brandDTOList;
    }

    private Bitmap getBitmapFromAsset(String strName) {
        AssetManager assetManager = MyApplication.getInstance().getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }
}
