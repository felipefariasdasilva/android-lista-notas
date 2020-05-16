package com.felipe.ceep.ui.recyclerView.helper.callback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.felipe.ceep.dao.NotaDAO;
import com.felipe.ceep.ui.recyclerView.adapter.ListaNotasAdapter;

public class NotaItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private ListaNotasAdapter adapter;

    public NotaItemTouchHelperCallback(ListaNotasAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int marcarcoesDeDeslize = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(0, marcarcoesDeDeslize);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int posicaoDaNotaDeslizada = viewHolder.getAdapterPosition();
        new NotaDAO().remove(posicaoDaNotaDeslizada);
        adapter.remove(posicaoDaNotaDeslizada);
    }
}
