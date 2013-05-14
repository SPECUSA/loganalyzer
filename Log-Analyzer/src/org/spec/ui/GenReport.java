/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spec.ui;

import InfoBean.InputUserInfo;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author hduser
 */
public class GenReport extends Thread {
    String query;
    InputUserInfo inputs;
    LogAnalysisJPanel lap;
    public GenReport(){
        
    }
    public GenReport(String str, InputUserInfo info,LogAnalysisJPanel l){
        query=str;
        inputs=info;
        lap=l;
    }
    public void run(){
        try{
                        if(!Thread.currentThread().isInterrupted()){
                        HashMap hm = new HashMap();
                        hm.put("main_tbl_name","tbl_http_log");
                        hm.put("url_keys",inputs.getUrlKeyword());
                        hm.put("main_from_date",inputs.getFromDate()+" "+inputs.getFromTime());
                        hm.put("main_to_date",inputs.getToDate()+" "+inputs.getToTime());
                        hm.put("main_chart_limit",Integer.parseInt(inputs.getTop()));
                        hm.put("main_where_condition",query);
                        hm.put("viewer_type",inputs.getViewerType());
                        hm.put("file_path",inputs.getFilepath());
                        hm.put("report_type",inputs.getReportType());
                        hm.put("order_by_bytes_or_hints",inputs.getOrderby());
                        hm.put("order_by_total_mb_or_total_hints",inputs.getOrderbyvalue());
                        lap.jTextArea1.setText("");
                        //lap.jTextArea1.append(process);
                        Date fdate=new Date(lap.jDateChooserFromDate.getDate().getYear(),lap.jDateChooserFromDate.getDate().getMonth(),lap.jDateChooserFromDate.getDate().getDate());
                        Date tdate=new Date(lap.jDateChooserToDate.getDate().getYear(),lap.jDateChooserToDate.getDate().getMonth(),lap.jDateChooserToDate.getDate().getDate());
                        if(tdate.after(fdate)||tdate.equals(fdate)){
                        //if(inputs.isFlag()){
                        TestReport tr=new TestReport();
                        int a=tr.getReport(hm); 
                        if(a==1) lap.jtxtprogress.setText("Report generated");
                        else lap.jtxtprogress.setText("");
                        
                        
                        /*}else{
                          JOptionPane.showMessageDialog(null, "Please enter username and password","Log Analyzer",JOptionPane.INFORMATION_MESSAGE);
                        }*/
                        }else{
                          JOptionPane.showMessageDialog(null, "To date should not be before from date","Log Analyzer",JOptionPane.INFORMATION_MESSAGE);
                        }
                   }
        }catch(Exception e){
            System.out.println("Error - "+e);
        }
    }
}
