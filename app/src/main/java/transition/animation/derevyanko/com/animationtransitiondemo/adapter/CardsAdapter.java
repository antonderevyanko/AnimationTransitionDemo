package transition.animation.derevyanko.com.animationtransitiondemo.adapter;

import android.support.v7.widget.RecyclerView;

/**
 * Created by anton on 6/22/15.
 */
public final class CardsAdapter extends RecyclerView.Adapter<QuoteViewHolder> {

    private List<Quote> quotes;

    public QuotesRecyclerAdapter(List<Quote> quotes) {
        updateData(quotes);
    }

    public void updateData(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @Override
    public QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_widget, parent, false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final QuoteViewHolder holder, int position) {
        holder.setData(quotes.get(position));
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public void removeItem(int itemPosition) {
        notifyItemRemoved(itemPosition);
        quotes.remove(itemPosition);
    }
}
