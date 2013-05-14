/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spec.ui;



import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author dashrath
 */
public class TestReport {
    public int getReport(HashMap hm)
    {
                                int i=0;
                        	try
				{
                                                
                                                Properties config=new Properties();
                                                config.load(new FileInputStream(System.getProperty("user.dir")+"//config//config.properties"));
                                                //JOptionPane.showMessageDialog(null,System.getProperty("user.dir"),"LogAnalyzer",JOptionPane.INFORMATION_MESSAGE);
                                                //config.load(new FileInputStream(System.getProperty("java.home")+"//ext//config//config.properties"));
                                                Class.forName(config.getProperty("dbdriver"));
                                                Connection conn = DriverManager.getConnection(config.getProperty("dbstring"),config.getProperty("dbuser"),config.getProperty("dbpass"));
                                                //lap.jTextArea1.append("\nPass - 1 Connection succeed\nReport filling process is running...");
                                                JasperPrint print=null;
                                                if(hm.get("report_type").equals("Summary")){
                                                   //print = JasperFillManager.fillReport(getClass().getResourceAsStream("LOG_MASTER.jasper"),hm,conn);
                                                   print = JasperFillManager.fillReport(System.getProperty("user.dir")+"//config//LOG_MASTER.jasper",hm,conn);
                                                }else{
                                                 //print = JasperFillManager.fillReport(getClass().getResourceAsStream("LOG_DETAIL.jasper"),hm,conn);   
                                                 print = JasperFillManager.fillReport(System.getProperty("user.dir")+"//config//LOG_DETAIL.jasper",hm,conn);
                                                }
                                                //lap.jTextArea1.append("\nPass - 2 Report filling succeed");
                                                if(!print.getPages().isEmpty()){
                                                if(hm.get("viewer_type").equals("PDF")){
                                                //lap.jTextArea1.append("\nReport export is running....");    
						JRExporter exporter = 
						new net.sf.jasperreports.engine.export.JRPdfExporter();
						exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,hm.get("file_path"));
						exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
						exporter.exportReport();
                                                JOptionPane.showMessageDialog(null, "Report generated","Log Analyzer",JOptionPane.INFORMATION_MESSAGE);
                                                i=1;
                                                }else{
                                                //lap.jTextArea1.append("\nReport viewer is opening report wait....");
                                                JasperViewer jv=new JasperViewer(print, false);
                                                //lap.jTextArea1.append("\nReport generated.");
                                                jv.setTitle("Log Analyzer - Report Viewer");
                                                List<Image> icons  = new ArrayList();
                                                icons.add(new ImageIcon(getClass().getResource("icon.png")).getImage());
                                                jv.setIconImages(icons);
                                                jv.setVisible(true);
                                                i=1;
                                                }
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "No data found","Log Analyzer",JOptionPane.INFORMATION_MESSAGE);
                                                }
                                              
							
						
				}catch(MySQLSyntaxErrorException e){
                                      JOptionPane.showMessageDialog(null, "Unauthorised user","Log Analyzer",JOptionPane.INFORMATION_MESSAGE);
                                    System.exit(0);
                                }
				catch (JRException e)
				{
                                    //JOptionPane.showMessageDialog(null, "Error - "+e.getMessage(),"Log Analyzer",JOptionPane.ERROR_MESSAGE);        
                                    e.printStackTrace();
				}
				catch (SQLException se) {
                                     if (se.getMessage().indexOf("Access denied") >= 0) {
                                     JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
                                     System.exit(0);
                                     }
                                     else if (se.getClass().getName().equals("com.mysql.jdbc.CommunicationsException")) {
                                     JOptionPane.showMessageDialog(null, "Unable to connect to Database Server", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
                                     System.exit(0);
                                     }
                                     else{
                                         System.out.println(se.getMessage());
                                     }
                                } catch (Exception e) {
                                     System.out.println(e);
                                }
                                  return i;
	}
    
        public void getHelpReport()
        {
                                try
				{
                                                Properties config=new Properties();
                                                config.load(new FileInputStream(System.getProperty("user.dir")+"//config//config.properties"));
                                                Class.forName(config.getProperty("dbdriver"));
                                                Connection conn = DriverManager.getConnection(config.getProperty("dbstring"),config.getProperty("dbuser"),config.getProperty("dbpass"));
                                                JasperPrint print=JasperFillManager.fillReport(getClass().getResourceAsStream("HELP.jasper"),new HashMap(),conn);
                                                if(!print.getPages().isEmpty()){
                                                  JasperViewer jv=new JasperViewer(print, false);  
                                                  jv.setTitle("Log Analyzer - Report Viewer");
                                                  List<Image> icons  = new ArrayList();
                                                  icons.add(new ImageIcon(getClass().getResource("icon.png")).getImage());
                                                  jv.setIconImages(icons);
                                                  jv.setVisible(true);
                                                }else{
                                                  JOptionPane.showMessageDialog(null, "No data found","Log Analyzer",JOptionPane.INFORMATION_MESSAGE);  
                                                }
                                }
                                catch(MySQLSyntaxErrorException e){
                                    JOptionPane.showMessageDialog(null, "Unauthorised user","Log Analyzer",JOptionPane.INFORMATION_MESSAGE);
                                    System.exit(0);
                                }
                                catch (SQLException se) {
                                     if (se.getMessage().indexOf("Access denied") >= 0) {
                                     JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
                                     System.exit(0);
                                     }
                                     else if (se.getClass().getName().equals("com.mysql.jdbc.CommunicationsException")) {
                                       JOptionPane.showMessageDialog(null, "Unable to connect to Database Server", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
                                       System.exit(0);
                                     }
                                     else{
                                         System.out.println(se.getMessage());
                                     }
                                     
                                } catch (Exception e) {
                                     System.out.println(e);
                                                                       
                                }
        }
           
}
