/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observableexample.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import observableexample.dal.SomeDAO;

/**
 *
 * @author pgn
 */
public class DataObservable {

    private SomeDAO dao;

    private boolean isRunning = true;

    private List<DataObserver> observers;

    private String state;

    public DataObservable()
    {
        dao = new SomeDAO();
        observers = new ArrayList<>();

        Thread t = new Thread(() ->
        {
            while (isRunning)
            {
                if (dao.hasNewData())
                {
                    setState(dao.getNewData());
                    for(DataObserver observer : observers)
                    {
                        observer.update();
                    }
                }
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(DataObservable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.setDaemon(true); //I mark the thread as a daemon thread so it will be terminated when i exit the app.
        t.start();
    }

    public void setIsRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }

    public void attatch(DataObserver observer)
    {
        this.observers.add(observer);
    }

    public String getState()
    {
        return state;
    }

    private void setState(String newState)
    {
        state = newState;
    }

}