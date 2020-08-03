package com.development.hybrid.universe.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BasePresenter {

    protected BasePresenter(){}

    @CallSuper
    void onCreate(@Nullable final Bundle savedInstanceState) {}

    @CallSuper
    void onSaveInstanceState(@NonNull final Bundle outState) {}

    @CallSuper
    void onStart() {}

    @CallSuper
    void onDestroy() {}

    @CallSuper
    void onPause() {}

    @CallSuper
    void onResume() {}

    @CallSuper
    void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data) {}

    @CallSuper
    void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {}

    @CallSuper
    void onRestoreInstanceState(@NonNull final Bundle savedInstanceState) {}

}