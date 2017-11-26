/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib2017.model;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import lib2017.utils.HelloService;

/**
 *
 * @author danecek
 */
public class MainW extends JFrame {

    volatile HelloService dg;

    public MainW() throws HeadlessException {
        JLabel l;
        add(l = new JLabel("xxxx"), BorderLayout.NORTH);
        add(BorderLayout.SOUTH, new JButton(new AbstractAction("Click") {

            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText(dg.hello("Tom"));
            }
        }));
        setBounds(100, 100, 600, 400);
        setVisible(true);
    }

}
