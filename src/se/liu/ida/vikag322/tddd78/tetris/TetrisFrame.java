package se.liu.ida.vikag322.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by viktoragbrink on 2015-02-25.
 */
public class TetrisFrame extends JFrame {

    //private JTextArea textArea;
    private Board board;
    private JFrame popupFrame;
    private TetrisComponent tetrisComponent;

    public TetrisFrame(Board board) {
        super("myWindow");
        this.board = board;
	this.tetrisComponent = new TetrisComponent(board);

        this.setLayout(new BorderLayout());
	add(tetrisComponent, BorderLayout.CENTER);
	add(makeMenu(), BorderLayout.PAGE_START);
	requestFocus();

	final Timer clockTimer = new Timer(500, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();

	setVisible(true);
	pack();
    }

    final Action doOneStep = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
	    tetrisComponent.boardChanged();
        }
    };

    public JMenuBar makeMenu(){
	final JMenu file = new JMenu("File");
	JMenuItem exitButton = new JMenuItem("Avsluta");
	file.add(exitButton);

	final ActionListener al = new ActionListener(){
	    public void actionPerformed(ActionEvent e){
		Object[] options = {
			"Yes", "No"
		};
		int optionChosen = JOptionPane.showOptionDialog(popupFrame, "Are you sure you want to exit?", "Exit",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null,
								options, options[1]);
		if(optionChosen == JOptionPane.YES_OPTION){
		    System.exit(0);
		}

	    }
	};

	exitButton.addActionListener(al);

	final JMenuBar bar = new JMenuBar();
	bar.add(file);
	return bar;
    }
}
