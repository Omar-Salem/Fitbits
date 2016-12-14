package org.omarsalem.fitbits;

import java.util.List;

/**
 * Created by Omar on 14/12/2016.
 */
public interface DataGetter {
    int getLength();

    int getWidth();

    List<InputViewModel> getData();
}
