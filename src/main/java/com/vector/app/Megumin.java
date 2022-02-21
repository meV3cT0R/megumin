package com.vector.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Megumin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton loadMegumin;
	private JLabel meguminLabel;
	private Elements images;
	private Document document=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(()->{
			try {
				Megumin frame = new Megumin();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Megumin() {
		super("Megumin");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			//
			document = Jsoup.connect("https://www.pinterest.com/meV3cT0R/megumin/").get();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		assert document !=null;
		images = document.select("img");
		
		setBounds(100, 100, 364, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xf4cccc));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLoadMegumin());
		contentPane.add(getMeguminLabel());
		
	}
	private JButton getLoadMegumin() {
		if (loadMegumin == null) {
			loadMegumin = new JButton("megumin");
			loadMegumin.setBackground(new Color(0xf4cccc));
			loadMegumin.setFont(new Font("Rockwell", Font.BOLD, 18));
			loadMegumin.setForeground(new Color(0x000000));
			loadMegumin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.HAND_CURSOR);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.DEFAULT_CURSOR);
				}
			});
			loadMegumin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showMegumin();
				}
			});
			loadMegumin.setBounds(79, 37, 196, 28);
		}
		return loadMegumin;
	}
	private JLabel getMeguminLabel() {
		if (meguminLabel == null) {
			meguminLabel = new JLabel("");
			meguminLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			meguminLabel.setBounds(10, 77, 328, 312);
		}
		return meguminLabel;
	}
	
	private void showMegumin() {
		Random random = new Random();
		String url = images.get(random.nextInt(images.size())).attr("src");
		ImageIcon meguminImage = null;
		try {
//			ImageIcon preImage = new ImageIcon();
//			
//			System.out.println("image Height:"+preImage.getIconHeight());
//			System.out.println("image Width:"+preImage.getIconWidth());
//			System.out.printf("%n");
			
			
//			if((preImage.getIconWidth()-preImage.getIconHeight())> 100) {
//				height = meguminImageHeight-(preImage.getIconWidth()-preImage.getIconHeight());
//				System.out.println("height subtracted:");
//			}
//			if((preImage.getIconHeight()-preImage.getIconWidth())> 100) {
//				width = meguminImageWidth-(preImage.getIconHeight()-preImage.getIconWidth());
//				System.out.println("width subtracted");
//			}
//			System.out.println("after image Height:"+height);
//			System.out.println("after image Width:"+width);
//			System.out.printf("%n%n%n");
//			System.out.printf("---------------------%n");
			meguminImage = new ImageIcon(new URL(url));
			if(meguminImage.getIconHeight() < 100 && meguminImage.getIconWidth() <100) {
				showMegumin();
				return;
			}
		} catch (MalformedURLException exception) {
			
			exception.printStackTrace();
		}
		getMeguminLabel().setIcon(meguminImage);
	}
}
