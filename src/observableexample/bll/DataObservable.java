/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observableexample.bll;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import observableexample.dal.SomeDAO;

/**
 *
 * @author pgn
 */
public class DataObservable extends Observable
{

    private SomeDAO dao;
    private boolean isRunning = true;

    public DataObservable()
    {
        dao = new SomeDAO();

        Thread t = new Thread(() ->
        {
            while (isRunning)
            {
                if (dao.hasNewData())
                {
                    setChanged();
                    notifyObservers(dao.getNewData());
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
        t.start();
    }

    public void setIsRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }

}
