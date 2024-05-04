/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welp;

import java.util.*;

/**
 *
 * @author Admin
 */
public class DL {

    public ArrayList<Model> Accounts = new ArrayList<>();
    Model model1 = new Model();
    Model model2 = new Model();
    Model model3 = new Model();

    public void AccountContent() {

        

        model2.Pin = 12;
        model2.Name = "Shming";
        model2.Money = 500;

        model3.Pin = 123;
        model3.Name = "Eric";
        model3.Money = 500;

        Accounts.add(model1);
        Accounts.add(model2);
        Accounts.add(model3);
    }

      public Model GetModel(int Pin)
        {
            Model foundModel = new Model();
            for (Model element : Accounts)
            {
                if (Pin == element.Pin)
                {
                    foundModel = element;
                }
            }
            return foundModel;
        }
}
