package com.sar.user.notes_room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

public class ViewModel extends AndroidViewModel {
    Object object;
    Database database;
    public ViewModel(@NonNull Application application) {

        super(application);
        database=Database.getDatabase(application);
        object=database.object();

    }
    public  void  insert(Table table)
    {
        Log.i("hiiiiii","clea");
        new Asynctask(object).execute(table);
    }


    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     * <p>
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    @Override
    protected void onCleared() {
        Log.i("hiiiiii","cleat");
        super.onCleared();

    }
    private   class Asynctask extends AsyncTask<Table,Void,Void>
    {

        Object ob;

        public Asynctask(Object obj) {
            this.ob = obj;
        }

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param tables The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected Void doInBackground(Table... tables) {
            Log.i("hiioiiii","clt");
            ob.insert(tables[0]);
            return null;
        }
    }
}
