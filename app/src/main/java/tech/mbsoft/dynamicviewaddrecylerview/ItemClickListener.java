package tech.mbsoft.dynamicviewaddrecylerview;

import android.support.v7.widget.RecyclerView;

public interface ItemClickListener {

    void onItemClicked(RecyclerView.ViewHolder vh, Object item, int pos);
}
