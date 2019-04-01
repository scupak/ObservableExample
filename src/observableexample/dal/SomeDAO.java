/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observableexample.dal;

import java.util.Random;

/**
 *
 * @author pgn
 */
public class SomeDAO
{

    private int nr = 0;

    public boolean hasNewData()
    {
        Random rnd = new Random();
        return (rnd.nextInt(100) < 25);
    }

    public String getNewData()
    {
        nr++;
        return "#" + nr;
    }
}
