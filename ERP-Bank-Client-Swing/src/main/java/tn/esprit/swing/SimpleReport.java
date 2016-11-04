package tn.esprit.swing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import tn.esprit.delegator.GestionTransactionDelegate;
import tn.esprit.entites.Transaction;
import tn.esprit.service.GestionTransaction;

public class SimpleReport {
    DefaultTableModel tableModel;

    public void SimpleReportt() {
        JasperPrint jasperPrint = null;
        TableModelData();
        try {
            JasperCompileManager.compileReportToFile("report1.jrxml");
            jasperPrint = JasperFillManager.fillReport("report1.jasper", new HashMap(),
                    new JRTableModelDataSource(tableModel));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            jasperViewer.setVisible(true);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    private void TableModelData() {
        String[] columnNames = {"Code", "RIB", "Date", "Name"};


        List<Transaction> d = new ArrayList<Transaction>();
        d= GestionTransactionDelegate.findTransaction();

        String[][] data = new String[d.size()][5];

        for(int i =0;i<d.size();i++)
        {
        	data[i][0]=String.valueOf(d.get(i).getId());
        	data[i][1]=String.valueOf(d.get(i).getAccount().getId());
        	data[i][2]=d.get(i).getDate();
        	data[i][3]=d.get(i).getAccount().getClient().getName();

        }
       tableModel = new DefaultTableModel(data, columnNames);
    }



    }