package com.murbanob.melichallege.presentation.extension

import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.murbanob.melichallenge.domain.helpers.ErrorResult

fun View.showErrorRequestSnackBar(exception: Exception) {
    Snackbar
        .make(
            this,
            ErrorResult.getException(exception = exception).getMessageToUser(),
            Snackbar.LENGTH_LONG
        )
        .show()
}