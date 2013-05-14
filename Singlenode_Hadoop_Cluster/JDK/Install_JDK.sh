sudo mkdir /usr/lib/jvm
sudo cp jdk-6u39-linux-x64.bin /usr/lib/jvm/
sudo cp Path.txt /usr/lib/jvm/
cd /usr/lib/jvm/
sudo ./jdk-6u39-linux-x64.bin
sudo rm jdk-6u39-linux-x64.bin
sudo mv jdk1.6.0_39  jdk1.6.0
sudo cat Path.txt  >> /home/hduser/.bashrc
sudo rm Path.txt
