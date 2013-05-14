Wel-Come to Log Analyzer Cluster Setup

Please follow given step to create Hadoop Cluster for Log Analyzer

1. Create new group
   $ sudo addgroup hadoop
  
2. Create new user
   $ sudo adduser -ingroup hadoop  hduser
   
3. Add hduser to sudoers list
   $ sudo usermod -a -G sudo hduser
   
4. Add new host to /etc/hosts file
   <ip_address> loganalyzer
   
5. Enable passwordless execution oh hduser
   $ sudo visudo
   Add foolowing line at the end of sudoers.tmp file
   hduser ALL=(ALL) NOPASSWD:ALL   
   
   Ctrl + o - To Save
   Ctrl + x - To Exit
   
6. Login to hduser
   $ su -l hduser
   
7. Install JDK1.6.0 if not installed
   $ install_JDK.sh 

8. Install OpenSSH-server

   openssh-server_5.9_amd64.deb   
  
9. Generate public key for passwordless entry
   $ ssh-keygen
   	 Generating public/private rsa key pair.
     Enter file in which to save the key (/home/hduser/.ssh/id_rsa):<Press enter for default>
		 Enter passphrase (empty for no passphrase):<Press enter if u dont want to enter passpharse>
		 Enter same passphrase again:
		 Your identification has been saved in /home/hduser/.ssh/id_rsa.
	   Your public key has been saved in /home/hduser/.ssh/id_rsa.pub.
   Now add it to authorized keys by executing  following command
   $ cat  ~/.ssh/id_rsa.pub  >> ~/.ssh/authorized_keys
   
10. Setup Hadoop Cluster by running following script
   $ install.sh 
