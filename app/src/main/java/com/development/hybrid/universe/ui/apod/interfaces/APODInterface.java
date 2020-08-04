package com.development.hybrid.universe.ui.apod.interfaces;

import com.development.hybrid.universe.ui.apod.model.APODModel;

public interface APODInterface {

    interface view{
        void showProgress();
        void hideProgress();
        void hideApod();
        void showApod();
        void showApodDetails(APODModel apodModel);
        void fetchApodDetails();
        void showDataFetchError(String error);
        void onReloadData();
    }

    interface presenter{
        void fetchData();
        void onSuccess(APODModel apodModel);
        void onFailure(String failure);
    }

    interface interactor{
        void onRemoteFetch(final APODInterface.presenter listener);
    }

}
