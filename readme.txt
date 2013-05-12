user ubuntu
pass reverse

Klona virtualbox image
/etc/udev/rules.d/70-persistent-net.rules
Släng alla rader

/etc/hostname


puppet-------------------------------------

Starta server
sudo puppet master --mkusers

Testa klient
sudo puppet agent --server puppet --waitforcert 60 --test

sudo puppet cert --list
sudo puppet cert --sign dev



hosts ----------------

192.168.56.2 puppet build
192.168.56.3 systest
192.168.56.4 inttest
192.168.56.5 prod


------------------------------------
jenkins
sudo service start jenkins
http://build:8080/


-----------------------------------
ubuntu flera interface

auto eth1
iface eth1 inet static
address 192.168.56.10
netmask 255.255.255.0

up route add -net 192.168.56.0/24 dev eth1
dns-nameservers 127.0.0.1

------------------------
jetty9 i /opt/jetty9


