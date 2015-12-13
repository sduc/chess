package gui;

import javax.swing.*;

/**
 * Created by sduc on 13/12/15.
 */
public class EndMsg {

    String msg = null;

    public EndMsg(String msg) {
        this.msg = msg;
    }

    public void show() {
        JOptionPane.showMessageDialog(null, msg + " won!!!");
    }

}
