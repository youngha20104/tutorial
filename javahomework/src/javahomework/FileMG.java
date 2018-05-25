package javahomework;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FileMG extends JFrame implements ActionListener{
	Panel pa1 = new Panel(new BorderLayout());
	Panel pa2 = new Panel(new BorderLayout());
	Panel pa3 = new Panel(new BorderLayout());
	Panel pa4 = new Panel(new BorderLayout());
	TextArea te1 = new TextArea("",20,35,TextArea.SCROLLBARS_NONE);
	Choice ch1 = new Choice();
	Label lab1 = new Label("File Explorer");
	
	JTree tree;
	private DefaultMutableTreeNode leaf3;
	private DefaultTreeModel treeModel;
	private String colName[] = { "Name", "Size", "Modified"};
	private JPanel pan = new JPanel();
	DefaultTableModel model = new DefaultTableModel(colName, 0);
	JTable table = new JTable(model);
	public FileMG() {
		super("/home/");
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("disk drive(C:)");
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		File dir = new File("C:\\");
		File[] files = dir.listFiles(); // 객체로 받옴
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) { // 디렉토리 받기
				return file.isDirectory();
			}
		};
		files = dir.listFiles(fileFilter);
		if (files.length == 0) {
			System.out.println("Either dir does not exist or is not a directory");
		} else {
			for (int i = 0; i < files.length; i++) {
				File filename = files[i];
				if (filename.toString().contains("$") || filename.toString().contains("Recovery")
						|| filename.toString().contains("System") || filename.toString().contains("Temp")
						|| filename.toString().contains("PerfLogs"))

					continue;
				else {	
						Object a = filename;
						String w = a.toString();
						String e[] = w.split("\\\\");
						leaf3 = new DefaultMutableTreeNode(e[1]);
						root.add(leaf3);
					}
				}
			}
		
		DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("disk drive(C:)");
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		File dir1 = new File("D:\\");
		File[] files1 = dir.listFiles(); // 객체로 받옴
		FileFilter fileFilter1 = new FileFilter() {
			public boolean accept(File file) { // 디렉토리 받기
				return file.isDirectory();
			}
		};
		files = dir1.listFiles(fileFilter1);
		if (files.length == 0) {
			System.out.println("Either dir does not exist or is not a directory");
		} else {
			for (int i = 0; i < files.length; i++) {
				File filename = files[i];
				if (filename.toString().contains("$") || filename.toString().contains("Recovery")
						|| filename.toString().contains("System") || filename.toString().contains("Temp")
						|| filename.toString().contains("PerfLogs"))

					continue;
				else {	
						Object a = filename;
						String w = a.toString();
						String e[] = w.split("\\\\");
						leaf3 = new DefaultMutableTreeNode(e[1]);
						root.add(leaf3);
					}
				}
			}
	 	ch1.addItem("English");
		ch1.addItem("한국어");
		String row1[] = new String[3];
		  row1[0] = "app.html";
		  row1[1] = "1.07 KB";
		  row1[2] = "2/3/2017/ 11:37:03";
		  
		String row2[] = new String[3];
			row2[0] = "package.json";
			row2[1] = "384 B";
			row2[2] = "2/4/2017/ 11:47:03"; 
			
		model.addRow(row1);
		model.addRow(row2);
		
		pan.add(new JScrollPane(table));
		
		this.add(pan);		
		add(pa1,BorderLayout.SOUTH);
		add(pa2,BorderLayout.WEST);
		add(pa3,BorderLayout.NORTH);
		add(pa4,BorderLayout.EAST);
		pa1.add(lab1,BorderLayout.WEST);
		pa1.add(ch1,BorderLayout.EAST);
		pa2.add(tree);
		setSize(1000, 700);
		setVisible(true);
		this.setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FileMG();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
			if(arg0.equals(ch1)) {
				
			}
	}
}