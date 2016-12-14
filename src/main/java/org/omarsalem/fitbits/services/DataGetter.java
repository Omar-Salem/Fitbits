package org.omarsalem.fitbits.services;

import org.omarsalem.fitbits.viewmodels.InputViewModel;

import java.util.List;

public interface DataGetter {
    int getLength();

    int getWidth();

    List<InputViewModel> getData();
}
