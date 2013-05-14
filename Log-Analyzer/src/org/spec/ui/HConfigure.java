/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spec.ui;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.CommunicationsException;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *
 * @author ishanp
 */
public class HConfigure extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public String process = "";
    public JTextArea jTextArea1 = null;
    public HConfigure() {
        initComponents();
        jTextArea1 = new JTextArea();
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir") + "//config//hadoop.properties"));
            jlblstatus.setText("");
            if (prop.isEmpty()) {
                Setuidisable();
            } else {
                if(Setuienable(prop)==0){
                    jcheckedit.setSelected(true);
                }
                
            }
            Properties config = new Properties();
            config.load(new FileInputStream(System.getProperty("user.dir") + "//config//config.properties"));
            Class.forName(config.getProperty("dbdriver"));
            Connection conn = DriverManager.getConnection(config.getProperty("dbstring"), config.getProperty("dbuser"), config.getProperty("dbpass"));
            PreparedStatement ps = conn.prepareStatement("select count(*) from tbl_http_log limit 1");
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                jbtncleandata.setEnabled(false);
            } else {
                jbtncleandata.setEnabled(true);
            }
        } 
        catch (MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "Unauthorised user", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        catch(SQLException se){
            if(se.getMessage().indexOf("Access denied")>=0){
                JOptionPane.showMessageDialog(null,"Invalid Username or Password","Log Analyzer",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else if (se.getClass().getName().equals("com.mysql.jdbc.CommunicationsException")) {
               JOptionPane.showMessageDialog(null, "Unable to connect to Database Server", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
               System.exit(0);
            }
            else{
               System.out.println(se.getMessage());
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }


    }

    private int Setuienable(Properties prop) {
        int n=1;
        jtxtfsip.setText(prop.getProperty("fs.default.name").split(":")[1].substring(2));
        jtxtfsport.setText(prop.getProperty("fs.default.name").split(":")[2]);
        jtxtsship.setText(prop.getProperty("sship"));
        jtxtsshuser.setText(prop.getProperty("sshuser"));
        jtxtsshpass.setText(prop.getProperty("sshpass"));
        jtxtfsip.setEnabled(false);
        jtxtfsport.setEnabled(false);
        jtxtsship.setEnabled(false);
        jtxtsshuser.setEnabled(false);
        jtxtsshpass.setEnabled(false);
        jbtnsave.setEnabled(false);
        jcheckedit.setEnabled(true);
        jcheckedit.setEnabled(true);
        jbtnbrowse.setEnabled(true);
        jbtnrunjob.setEnabled(true);
        jtxtinputfile.setEnabled(true);
        try {
            Configuration conf = new Configuration();
            if(!Hadoop.flag){
            conf.set("fs.default.name", prop.getProperty("fs.default.name"));
            Hadoop.flag=true;
            }
            FileSystem fs = FileSystem.get(conf);
            if (fs.exists(new Path("/HTTP_LOG/Request"))) {
                jbtnrunjob.setEnabled(true);
            } else {
                jbtnrunjob.setEnabled(false);
                jbtnupload.setEnabled(false);
            }
            fs.close();
        } catch (Exception e) {
            if(e.getClass().getName().equals("java.net.ConnectException")){
                JOptionPane.showMessageDialog(null,"Unable to connect with Hadoop Cluster","Log Analyzer",JOptionPane.INFORMATION_MESSAGE);
                n=0;
            }else{
            System.out.println(e.getClass().getName());
            }
        }
       return n;
    }

    private void Setuidisable() {
        jtxtfsip.setEnabled(true);
        jtxtfsport.setEnabled(true);
        jtxtsship.setEnabled(true);
        jtxtsshuser.setEnabled(true);
        jtxtsshpass.setEnabled(true);
        jbtnsave.setEnabled(true);
        jtxtinputfile.setEnabled(false);
        jcheckedit.setEnabled(false);
        jbtnbrowse.setEnabled(false);
        jbtnrunjob.setEnabled(false);
        jbtnupload.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbtnGroupTypeOfReport = new javax.swing.ButtonGroup();
        jbuttongroupviewer = new javax.swing.ButtonGroup();
        btngroupconsultant = new javax.swing.ButtonGroup();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtfsip = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtfsport = new javax.swing.JTextField();
        jcheckedit = new javax.swing.JCheckBox();
        jtxtsshpass = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jtxtsshuser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtsship = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jbtnsave = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtxtinputfile = new javax.swing.JTextField();
        jlblstatus = new javax.swing.JLabel();
        jbtnrunjob = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jbtnbrowse = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jbtnupload = new javax.swing.JButton();
        jbtncleandata = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 174, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOG");
        jLabel1.setAlignmentX(5.0F);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/spec/ui/spec-logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 149, 217));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ANALYZER ");
        jLabel4.setAlignmentX(5.0F);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hadoop Cluster");

        jLabel5.setText("Hadoop Configuration");

        jLabel6.setText("fs.default.name");

        jtxtfsip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtfsipKeyTyped(evt);
            }
        });

        jLabel7.setText("IP");

        jLabel8.setText("PORT");

        jtxtfsport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtfsportKeyTyped(evt);
            }
        });

        jcheckedit.setText("Edit");
        jcheckedit.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jcheckeditStateChanged(evt);
            }
        });

        jLabel9.setText("Password");

        jtxtsshuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtsshuserKeyTyped(evt);
            }
        });

        jLabel10.setText("Username");

        jtxtsship.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtsshipKeyTyped(evt);
            }
        });

        jLabel11.setText("IP");

        jbtnsave.setText("SAVE");
        jbtnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsaveActionPerformed(evt);
            }
        });

        jLabel14.setText("Map-Reduce Job");

        jLabel13.setText("Select Folder");

        jlblstatus.setText("jLabel2");

        jbtnrunjob.setText("Import Data");
        jbtnrunjob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnrunjobActionPerformed(evt);
            }
        });

        jLabel12.setText("SSH Configuration");

        jbtnbrowse.setText("Browse");
        jbtnbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnbrowseActionPerformed(evt);
            }
        });

        jbtnupload.setText("Upload");
        jbtnupload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnuploadActionPerformed(evt);
            }
        });

        jbtncleandata.setText("Clean Data");
        jbtncleandata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncleandataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcheckedit)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtfsip, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel11)
                                            .addComponent(jtxtsship, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jtxtsshuser, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(42, 42, 42)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jtxtsshpass, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jtxtfsport, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtxtinputfile, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlblstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(jbtnsave)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jbtnupload, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(jbtnrunjob)
                                        .addGap(39, 39, 39)
                                        .addComponent(jbtncleandata)))
                                .addGap(28, 28, 28)
                                .addComponent(jbtnbrowse)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator4)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcheckedit)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtfsip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtfsport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtsship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtsshuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtsshpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jbtnsave)
                .addGap(24, 24, 24)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtxtinputfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnbrowse))
                .addGap(18, 18, 18)
                .addComponent(jlblstatus)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnrunjob)
                    .addComponent(jbtnupload)
                    .addComponent(jbtncleandata))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtfsipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtfsipKeyTyped
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
                || evt.getKeyChar() == '.'
                || (evt.getKeyCode() == evt.VK_DELETE)
                || (evt.getKeyCode() == evt.VK_BACK_SPACE)) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtfsipKeyTyped

    private void jtxtfsportKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtfsportKeyTyped
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
                || (evt.getKeyCode() == evt.VK_DELETE)
                || (evt.getKeyCode() == evt.VK_BACK_SPACE)) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtfsportKeyTyped

    private void jcheckeditStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jcheckeditStateChanged
        if (jcheckedit.isSelected()) {
            jtxtfsip.setEnabled(true);
            jtxtfsport.setEnabled(true);
            jtxtsship.setEnabled(true);
            jtxtsshuser.setEnabled(true);
            jtxtsshpass.setEnabled(true);
            jbtnsave.setEnabled(true);
        }
        if (!jcheckedit.isSelected() && jcheckedit.isEnabled()) {
            jtxtfsip.setEnabled(false);
            jtxtfsport.setEnabled(false);
            jtxtsship.setEnabled(false);
            jtxtsshuser.setEnabled(false);
            jtxtsshpass.setEnabled(false);
            jbtnsave.setEnabled(false);
        }
    }//GEN-LAST:event_jcheckeditStateChanged

    private void jtxtsshuserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtsshuserKeyTyped
        if ((evt.getKeyChar() >= 'A' && evt.getKeyChar() <= 'Z')
                || (evt.getKeyChar() >= 'a' && evt.getKeyChar() <= 'z')
                || (evt.getKeyCode() == evt.VK_DELETE)
                || (evt.getKeyCode() == evt.VK_BACK_SPACE)) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtsshuserKeyTyped

    private void jtxtsshipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtsshipKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtsshipKeyTyped

    private void jbtnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsaveActionPerformed
        try {
            Properties p = new Properties();
            if (jtxtfsip.getText().equals("") || jtxtfsport.getText().equals("") || jtxtsship.getText().equals("") || jtxtsshuser.getText().equals("") || jtxtsshpass.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter values", "Log analyzer", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //System.out.println("Hello" + jtxtfsip.getText());
                p.setProperty("fs.default.name", "hdfs://" + jtxtfsip.getText() + ":" + jtxtfsport.getText());
                p.setProperty("sship", jtxtsship.getText());
                p.setProperty("sshuser", jtxtsshuser.getText());
                p.setProperty("sshpass", jtxtsshpass.getText());
                p.store(new FileOutputStream(new File(System.getProperty("user.dir") + "//config//hadoop.properties")), "Hadoop Configuration");

                Properties prop = new Properties();
                prop.load(new FileInputStream(System.getProperty("user.dir") + "//config//hadoop.properties"));
                if(Setuienable(prop)==0) jcheckedit.setSelected(true);
                else jcheckedit.setSelected(false);
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }//GEN-LAST:event_jbtnsaveActionPerformed

    private void jbtnrunjobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnrunjobActionPerformed
        final long startTime = System.currentTimeMillis();
        new Thread() {
            public void run() {
                jbtnrunjob.setEnabled(false);
                DecimalFormat df = new DecimalFormat("#.##");
                try {
                    String endLineStr = " # ";
                    Properties p = new Properties();
                    p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//config//hadoop.properties")));
                    JSch shell = new JSch();
                    jlblstatus.setText("Connecting to the Hadoop Cluster... ");
                    Session session = shell.getSession(p.getProperty("sshuser"), p.getProperty("sship"), 22);
                    session.setUserInfo(new SSHUserInfo(p.getProperty("sshpass")));
                    session.connect();
                    jbtnbrowse.setEnabled(false);
                    jbtnupload.setEnabled(false);
                    jbtncleandata.setEnabled(false);
                    Channel channel = session.openChannel("shell");
                    channel.connect();

                    DataInputStream dataIn = new DataInputStream(channel.getInputStream());
                    DataOutputStream dataOut = new DataOutputStream(channel.getOutputStream());

                    dataOut.writeBytes("cd /usr/local/hadoop/script\r\n"
                            + "./LogAnalyzer.sh\r\n"
                            + "exit\r\n");
                    dataOut.flush();
                    String line = dataIn.readLine();
                    System.out.println(line);
                    while (!line.endsWith(endLineStr)) {
                        line = dataIn.readLine();
                        System.out.println(line);
                        if(line.indexOf('%')>=0){
                            jlblstatus.setText("Running Map-Reduce job - "+line.substring(line.indexOf("mapred.JobClient:  map")+22,line.indexOf('%')+1));
                            if(line.substring(line.indexOf("mapred.JobClient:  map")+22,line.indexOf('%')+1).trim().equals("100%")){
                              jlblstatus.setText("Map-Reduce job - "+line.substring(line.indexOf("mapred.JobClient:  map")+22,line.indexOf('%')+1)+" Merging Data..");
                            }
                        }
                        else if(line.indexOf("Running colxml")>=0){
                            jlblstatus.setText("Importing Data..");
                        }else if(line.indexOf("Moved to trash:")>=0){
                            jlblstatus.setText("Running Clean up task");
                        }else if(line.indexOf("Total input paths")>=0){
                            jlblstatus.setText("Creating Map-Reduce job");
                        }
                        
                    }
                    dataIn.close();
                    dataOut.close();
                    channel.disconnect();
                    session.disconnect();
                 } catch (NullPointerException e) {
                    jlblstatus.setText("Process Completed  Time Taken - " + df.format(((System.currentTimeMillis() - startTime) * 0.001)) + " sec");
                    jbtnrunjob.setEnabled(false);
                    jbtncleandata.setEnabled(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    if (e.getMessage().indexOf("authentication failures") > 0) {
                        JOptionPane.showMessageDialog(null, "Invalid username and password for SSH", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        }.start();

    }//GEN-LAST:event_jbtnrunjobActionPerformed

    private void jbtnbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnbrowseActionPerformed
        try {
            /*Properties p = new Properties();
             p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//config//hadoop.properties")));*/
            JFileChooser jfile = new JFileChooser();
            jfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int n = jfile.showOpenDialog(this);
            if (n != JFileChooser.CANCEL_OPTION) {
                jtxtinputfile.setText(jfile.getSelectedFile().getAbsolutePath());
                jtxtinputfile.setEditable(false);
                jbtnupload.setEnabled(true);
                jLabel13.setText("Selected Folder");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jbtnbrowseActionPerformed

    private void jbtnuploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnuploadActionPerformed
        if (!jtxtinputfile.getText().equals("")) {
            File folder = new File(jtxtinputfile.getText().trim());
            if (folder.listFiles().length > 0) {
                int a = JOptionPane.showConfirmDialog(null, "Are you sure to upload " + folder.listFiles().length+(folder.listFiles().length==1?" file ?":" files ?"),"Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
                if (a == JOptionPane.YES_OPTION) {
                    try {
                        Configuration conf = new Configuration();
                        Properties p = new Properties();
                        p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//config//hadoop.properties")));
                        conf.set("fs.default.name", p.getProperty("fs.default.name"));
                        final FileSystem fs = FileSystem.get(conf);
                        final long startTime = System.currentTimeMillis();
                        new Thread() {
                            public void run() {
                                try {
                                    File folder = new File(jtxtinputfile.getText().trim());
                                    DecimalFormat df = new DecimalFormat("#.##");
                                    jlblstatus.setText("Please wait file upload is running...");
                                    int fn = 0;
                                    for (File f : folder.listFiles()) {
                                        if (fs.exists(new Path("/HTTP_LOG/Request/" + f.getName()))) {
                                            int a = JOptionPane.showConfirmDialog(null, "File allready exist. Do you want to overwrite ?", "SPEC Hadoop", JOptionPane.INFORMATION_MESSAGE);
                                            if (a == JOptionPane.YES_OPTION) {
                                                fs.copyFromLocalFile(false, true, new Path(f.getAbsolutePath()), new Path("/HTTP_LOG/Request/" + f.getName()));
                                                f.renameTo(new File(System.getProperty("user.dir") + "//backup//" + f.getName()));
                                                //jlblstatus.setText("File uploaded sucessfully.        Time Taken - " + ((System.currentTimeMillis() - startTime) * 0.001) + " sec");
                                                fn++;
                                            }

                                        } else {
                                            fs.copyFromLocalFile(new Path(f.getAbsolutePath()), new Path("/HTTP_LOG/Request/" + f.getName()));
                                            f.renameTo(new File(System.getProperty("user.dir") + "//backup//" + f.getName()));
                                            //jlblstatus.setText("File uploaded sucessfully.        Time Taken - " + ((System.currentTimeMillis() - startTime) * 0.001) + " sec");
                                            fn++;
                                        }
                                    }
                                    jlblstatus.setText(fn +(fn==1?" file":" files")+ " uploaded sucessfully.        Time Taken - " + df.format(((System.currentTimeMillis() - startTime) * 0.001)) + " sec");
                                    jLabel13.setText("Select Folder");
                                    jtxtinputfile.setText("");
                                    jbtnupload.setEnabled(false);
                                    jbtnrunjob.setEnabled(true);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                        }.start();

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Folder is empty", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select folder", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbtnuploadActionPerformed

    private void jbtncleandataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncleandataActionPerformed
        new Thread() {
            public void run() {
                try {
                    Properties config = new Properties();
                    config.load(new FileInputStream(System.getProperty("user.dir") + "//config//config.properties"));
                    Class.forName(config.getProperty("dbdriver"));
                    Connection conn = DriverManager.getConnection(config.getProperty("dbstring"), config.getProperty("dbuser"), config.getProperty("dbpass"));
                    int a = JOptionPane.showConfirmDialog(null, "Are you sure to clean data ?", "Log Analyzer", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        jlblstatus.setText("Cleaning data...");
                        jbtncleandata.setEnabled(false);
                        PreparedStatement ps = conn.prepareStatement("delete from tbl_http_log");
                        int n = ps.executeUpdate();
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Data successfully cleaned", "Log Analyzer", JOptionPane.INFORMATION_MESSAGE);
                            jlblstatus.setText("");
                        }
                    }

                } catch (CommunicationsException ce) {
                    System.out.println(ce.getMessage());
                } catch (Exception e) {
                    System.out.println("Erro - " + e);
                }
            }
        }.start();
    }//GEN-LAST:event_jbtncleandataActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup JbtnGroupTypeOfReport;
    private javax.swing.ButtonGroup btngroupconsultant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbtnbrowse;
    private javax.swing.JButton jbtncleandata;
    private javax.swing.JButton jbtnrunjob;
    private javax.swing.JButton jbtnsave;
    private javax.swing.JButton jbtnupload;
    private javax.swing.ButtonGroup jbuttongroupviewer;
    private javax.swing.JCheckBox jcheckedit;
    private javax.swing.JLabel jlblstatus;
    private javax.swing.JTextField jtxtfsip;
    private javax.swing.JTextField jtxtfsport;
    private javax.swing.JTextField jtxtinputfile;
    private javax.swing.JTextField jtxtsship;
    private javax.swing.JPasswordField jtxtsshpass;
    private javax.swing.JTextField jtxtsshuser;
    // End of variables declaration//GEN-END:variables
}
