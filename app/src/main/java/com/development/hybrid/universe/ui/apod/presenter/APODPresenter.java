package com.development.hybrid.universe.ui.apod.presenter;

import com.development.hybrid.universe.base.BasePresenter;
import com.development.hybrid.universe.ui.apod.interfaces.APODInterface;
import com.development.hybrid.universe.ui.apod.model.APODInteractor;
import com.development.hybrid.universe.ui.apod.model.APODModel;

public class APODPresenter extends BasePresenter implements APODInterface.presenter {

    private APODInterface.view view;
    private APODInteractor interactor;

    public APODPresenter(APODInterface.view view, APODInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void fetchData() {
        view.hideApod();
        view.showProgress();
        interactor.onRemoteFetch(this);
    }

    @Override
    public void onSuccess(APODModel apodModel) {
        view.hideProgress();
        view.showApod();
        view.showApodDetails(apodModel);
    }

    @Override
    public void onFailure(String failure) {
        view.showDataFetchError(failure);
        view.hideProgress();
    }
}
