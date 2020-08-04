package com.development.hybrid.universe.ui.apod.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.development.hybrid.universe.R;
import com.development.hybrid.universe.base.BaseActivity;
import com.development.hybrid.universe.ui.apod.interfaces.APODInterface;
import com.development.hybrid.universe.ui.apod.model.APODInteractor;
import com.development.hybrid.universe.ui.apod.model.APODModel;
import com.development.hybrid.universe.ui.apod.presenter.APODPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class APODActivity extends BaseActivity<APODPresenter> implements APODInterface.view {

    @BindView(R.id.animation_view)
    private LottieAnimationView animationView;
    @BindView(R.id.linearLayoutError)
    private LinearLayout layoutError;
    @BindView(R.id.imageViewADOPError)
    private ImageView imageViewError;
    @BindView(R.id.textViewErrorAPOD)
    private TextView textViewError;
    @BindView(R.id.linearLayoutInfoAPOD)
    private LinearLayout layoutInfo;
    @BindView(R.id.imageViewIconAPOD)
    private ImageView imageViewIcon;
    @BindView(R.id.textViewTitleAPOD)
    private TextView textViewTitle;
    @BindView(R.id.textViewDateAPOD)
    private TextView textViewDate;
    @BindView(R.id.textViewDetailsAPOD)
    private TextView textViewDetails;

    @NonNull
    @Override
    protected APODPresenter onCreatePresenter(@NonNull Context context) {
        return new APODPresenter(this, new APODInteractor());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_p_o_d);
        ButterKnife.bind(this);
        fetchApodDetails();
    }

    @Override
    public void showProgress() {
        animationView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        animationView.setVisibility(View.GONE);
    }

    @Override
    public void hideApod() {
        layoutInfo.setVisibility(View.GONE);
    }

    @Override
    public void showApod() {
        layoutInfo.setVisibility(View.VISIBLE);
    }

    @Override
    public void showApodDetails(APODModel apodModel) {
        Glide.with(this)
                .load(apodModel.getLowResUrl())
                .apply(RequestOptions.centerCropTransform())
                .into(imageViewIcon);
        textViewTitle.setText(apodModel.getTitle());
        textViewDate.setText(apodModel.getDate());
        textViewDetails.setText(apodModel.getExplanation());

    }

    @Override
    public void fetchApodDetails() {
        mPresenter.fetchData();
    }

    @Override
    public void showDataFetchError(String error) {
        layoutError.setVisibility(View.VISIBLE);
        textViewError.setText(error);
    }

    @Override
    public void onReloadData() {
        layoutError.setVisibility(View.GONE);
        mPresenter.fetchData();
    }

    @OnClick(R.id.imageViewADOPError)
    private void setImageViewIconError(){
        onReloadData();
    }
}