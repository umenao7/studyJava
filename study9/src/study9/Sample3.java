package study9;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sample3 extends JFrame {

	private JPanel pn1, pn2;
	private JLabel lb1, lb2, lb3, lb4;
	private JButton bt;

	public static void main(String[] args) {
		Sample3 sm = new Sample3();
	}

	public Sample3() {
		// タイトルの設定
		super("サンプル");

		// コンポーネントの作成
		lb1 = new JLabel("ファイルを選択してください");
		lb2 = new JLabel();
		lb3 = new JLabel();
		lb4 = new JLabel();

		pn1 = new JPanel();
		pn2 = new JPanel();
		bt = new JButton("選択");

		// コンテナの設定
		pn1.setLayout(new GridLayout(3, 1));

		// コンテナへの追加
		pn1.add(lb2);
		pn1.add(lb3);
		pn1.add(lb4);
		pn2.add(bt);

		add(lb1, BorderLayout.NORTH);
		add(pn1, BorderLayout.CENTER);
		add(pn2, BorderLayout.SOUTH);

		// リスナの登録
		bt.addActionListener(new SampleActionListener());
		addWindowListener(new SampleWindowListener());

		// フレームの設定
		setSize(300, 300);
		setVisible(true);

	}

	class SampleActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Container cnt = getContentPane();
			JFileChooser fc = new JFileChooser();
			int res = fc.showOpenDialog(cnt);

			if (res == JFileChooser.APPROVE_OPTION) {
				File f1 = fc.getSelectedFile();
				lb2.setText("ファイル名は" + f1.getName() + "です。");
				lb3.setText("絶対パスは" + f1.getAbsolutePath() + "です。");
				lb4.setText("サイズは" + f1.length() + "バイトです。");
			}
		}
	}

	class SampleWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}
