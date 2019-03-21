package helloworld.parts;

import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class SamplePart {

	@Inject
	private MPart part;

	@PostConstruct
	public void createComposite(Composite parent) {

		parent.setLayout(new GridLayout(1, true));
		Composite first = new Composite(parent, SWT.NONE);
		RowLayout rowLayout = new RowLayout();
		first.setLayout(rowLayout);

		Label label = new Label(first, SWT.NONE);
		label.setText("Name:");

		Text text = new Text(first, SWT.BORDER);
		RowData layoutData = new RowData();
		layoutData.width = 150;

		Button button1 = new Button(first, SWT.CHECK);
		button1.setText("orange");

		Composite second = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		second.setLayout(gridLayout);
		gridLayout.numColumns = 2;
		gridLayout.marginLeft = 10;
		gridLayout.marginRight = 5;

		Label label1 = new Label(second, SWT.NONE);
		label1.setText("Surname:");

		Text gridtext = new Text(second, SWT.BORDER);
		gridtext.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, true, false));

		Button button2 = new Button(second, SWT.CHECK);
		button2.setText("red");

		Composite third = new Composite(parent, SWT.NONE);
		third.setLayout(new FillLayout());
		Group group = new Group(third, SWT.NONE);
		group.setText("Table");
		Table table = new Table(group, SWT.BORDER);

		table.setLayout(new GridLayout(1, true));
		table.setSize(400, 150);
		TableColumn column1 = new TableColumn(table, SWT.LEFT);
		TableColumn column2 = new TableColumn(table, SWT.LEFT);
		TableColumn column3 = new TableColumn(table, SWT.LEFT);
		column1.setText("First Name");
		column2.setText("Last Name");
		column3.setText("Address");
		column1.setWidth(120);
		column2.setWidth(120);
		column3.setWidth(160);
		table.setHeaderVisible(true);

		Composite fifth = new Composite(parent, SWT.NONE);
		fifth.setLayout(rowLayout);
		Label label2 = new Label(fifth, SWT.NONE);
		label2.setText("Enter your name:");
		Text text1 = new Text(fifth, SWT.BORDER);
		text.setLayoutData(new RowData(100, SWT.DEFAULT));
		Button ok = new Button(fifth, SWT.PUSH);
		ok.setText("OK");

		Composite sixth = new Composite(parent, SWT.NONE);
		//sixth.setLayout(new FillLayout());
		Tree tree = new Tree(sixth, SWT.BORDER);
		tree.setSize(300, 200);
		for (int i = 1; i < 5; i++) {
			TreeItem iItem = new TreeItem(tree, 0);
			iItem.setText(i+".a");
			for (int j = 1; j < 5; j++) {
				TreeItem jItem = new TreeItem(iItem, 0);
				jItem.setText(j+".b");
				for (int k = 1; k < 5; k++) {
					TreeItem kItem = new TreeItem(jItem, 0);
					kItem.setText(k+".c");
					for (int l = 1; l < 5; l++) {
						TreeItem lItem = new TreeItem(kItem, 0);
						lItem.setText(l+".d");
					}
				}
			}
		}

	}

	@Focus
	public void setFocus() {
		// tableViewer.getTable().setFocus();
	}

	@Persist
	public void save() {
		// part.setDirty(false);
	}

}