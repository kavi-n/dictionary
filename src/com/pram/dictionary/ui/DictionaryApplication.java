package com.pram.dictionary.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.param.dictionary.bean.Word;
import com.param.dictionary.manage.DictionaryManagement;
import com.param.dictionary.manage.TrieTree;
import com.pram.dictionary.imanage.ITree;

/**
 * 
 * Dictionary application using Swing. - Stand Alone Application
 * 
 * @author kavin.m
 *
 */
public class DictionaryApplication extends JFrame {

	/**
	 * 
	 * Builds the UI for the application
	 * 
	 * @param panel
	 * @param frame
	 */
	private static void placeComponents(JPanel panel, JFrame frame) {

		panel.setLayout(new FlowLayout());
		JLabel userLabel = new JLabel("Word");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		final JTextField userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		Suggestions suggestions = new Suggestions(frame, userText);


		SwingUtilities.invokeLater(suggestions);
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(10, 80, 80, 25);
		panel.add(searchButton);

		final JTextArea ta = new JTextArea(10, 50);
		JScrollPane sp = new JScrollPane(ta);
		panel.add(sp);

		final DictionaryManagement dictManagement = loadDictionaryManagement();
		final Queue<String> searchQueue = searchField(userText, dictManagement, searchButton, ta);

		JLabel recent = new JLabel("Recent");
		recent.setBounds(100, 200, 80, 25);
		panel.add(recent);
		JList searchList = LastSearched.getLastSearchedList(searchQueue);
		searchList.setBounds(100, 200, 75, 75);
		panel.add(searchList);
	}

	private static DictionaryManagement loadDictionaryManagement() {
		// Need to use strategy according to the dictionary type selected. If it a huge
		// better
		// move with DB than having it in memory
		ITree iTree = new TrieTree();
		final DictionaryManagement dictManagement = new DictionaryManagement(iTree);

		try {
			dictManagement.loadData("file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: Need to add a error Dialogue box if this failed
		}
		return dictManagement;
	}

	/**
	 * 
	 * Search button binded with the action to fetch the data from Trie
	 * 
	 * @param userText
	 * @param dictManagement
	 * @param searchButton
	 * @param ta
	 * @return
	 */
	private static Queue<String> searchField(final JTextField userText, final DictionaryManagement dictManagement,
			JButton searchButton, final JTextArea ta) {
		final Queue<String> searchQueue = new LinkedList<String>();
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Word searchWord = dictManagement.searchWord(userText.getText());
				if (searchWord == null) {
					ta.setText("Word not found");
				} else {
					searchQueue.add(searchWord.getSpell());
					ta.setText(searchWord.getSynonyms());
					LastSearched.getLastSearchedList(searchQueue);
				}
			}
		});
		return searchQueue;
	}

	/**
	 * 
	 * Main method to trigger the application
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame dictonaryFrame = new JFrame("Dictionary");
		dictonaryFrame.setSize(700, 700);
		dictonaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel dictonaryPanel = new JPanel();
		dictonaryFrame.add(dictonaryPanel);
		placeComponents(dictonaryPanel, dictonaryFrame);
		dictonaryFrame.setVisible(true);
	}

}
