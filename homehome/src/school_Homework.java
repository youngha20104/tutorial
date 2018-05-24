import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class school_Homework extends JFrame implements ActionListener, WindowListener,TreeSelectionListener {

	JTree tree;
	DefaultTreeModel treeModel;
	JComboBox ch1;
	JLabel label1;
	final String option[] = { "Name", "Size", "Modified"};
	final String option_korean[] = { "이름", "크기", "수정한 날짜"};
	File[] files;
	JScrollPane pane2;
	JTable jtable;
	public school_Homework() {
		super("/home/");
		File dir = new File("C:\\");
		files = dir.listFiles();
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		files = dir.listFiles(fileFilter);
		DefaultMutableTreeNode diskdrive = new DefaultMutableTreeNode("디스크드라이브(C:)");
		for (int i = 0; i < files.length; i++) {
			DefaultMutableTreeNode filename = new DefaultMutableTreeNode(files[i]);
		}
		for (int i = 0; i < files.length; i++) {
			File filename = files[i];
			if (filename.toString().contains("$") || filename.toString().contains("Recovery")
					|| filename.toString().contains("System") || filename.toString().contains("Temp")
					|| filename.toString().contains("PerfLogs")) {
				continue;
			}
			String nodeName = filename.toString();
			String nodeName2 = nodeName.substring(3);
			diskdrive.add(new DefaultMutableTreeNode(nodeName2));
		}

		treeModel = new DefaultTreeModel(diskdrive);
		tree = new JTree(treeModel);
		
		tree.addTreeSelectionListener(this);
		JScrollPane scrollPane = new JScrollPane();
		this.addWindowListener(this);
		
		
		
		
		
		
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new BorderLayout());
		JPanel p3 = new JPanel(new BorderLayout());
		scrollPane.setViewportView(tree);
		p1.add(scrollPane, BorderLayout.CENTER);
		label1 = new JLabel("File Explorer");
		ch1 = new JComboBox();
		ch1.addItem("English");
		ch1.addItem("한국어");
		ch1.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ch1.getSelectedItem() == "한국어") {
					label1.setText("파일 매니져");
					Object filedata[][] = new Object[files.length][3];
					for(int i=0;i<files.length;i=i+1) {
						files[i].getName();
						files[i].length();
						files[i].lastModified();  
					
					filedata[i][0] = files[i].getName();
					filedata[i][1] = files[i].length();
					SimpleDateFormat test = new SimpleDateFormat("d/M/yyyy hh:mm:ss");
					filedata[i][2] = test.format(files[i].lastModified()); }
					JTable jtable = new JTable(filedata,option_korean);

					pane2.setViewportView(jtable);
					
				}
				else {
					label1.setText("File Manager");
					setJTable();
				}
			}     
     });
		pane2 = new JScrollPane();
		setJTable();
		
		pane2.setViewportView(jtable);
		p2.add(pane2,BorderLayout.CENTER);
		p3.add(label1, BorderLayout.WEST);
		p3.add(ch1, BorderLayout.EAST);
		add(p1, BorderLayout.WEST);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		setSize(600, 400);
		setVisible(true);

	}
	void setJTable() {
		Object filedata[][] = new Object[files.length][3];
		for(int i=0;i<files.length;i=i+1) {
			files[i].getName();
			files[i].length();
			files[i].lastModified();  
		
		filedata[i][0] = files[i].getName();
		filedata[i][1] = files[i].length();
		SimpleDateFormat test = new SimpleDateFormat("d/M/yyyy hh:mm:ss");
		filedata[i][2] = test.format(files[i].lastModified()); }
		jtable = new JTable(filedata,option);
		

		pane2.setViewportView(jtable);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new school_Homework();
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		TreePath p = e.getPath();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)p.getLastPathComponent();
		System.out.println(node.toString());
	}	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}