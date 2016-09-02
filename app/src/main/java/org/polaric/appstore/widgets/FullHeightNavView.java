/*
 * Copyright (c) 2016 Garret C. Yoder
 *
 *     This file is part of CMLog.
 *
 *     CMLog is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     CMLog is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with CMLog.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.polaric.cluttr.widgets;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;

public class FullHeightNavView extends NavigationView {
    public FullHeightNavView(Context context) {
        super(context);
    }

    public FullHeightNavView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullHeightNavView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, 0);
    }
}
