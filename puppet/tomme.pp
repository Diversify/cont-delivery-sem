package { [ 'jetty', 'libjetty-extra-java' ]: ensure => absent }
package { [ 'tomcat6' ]: ensure => absent }

class tomee {


 file {"/opt/tomee-1.5.2":
    ensure => directory,
    recurse => true,
 } ->

 exec { "download-tomee" :
    command => "/usr/bin/wget http://apache.mirror3.ip-only.net/tomee/tomee-1.5.2/apache-tomee-1.5.2-webprofile.tar.gz -O /tmp/tomee-1.5.2.tar.gz",
    creates => "/tmp/tomee-1.5.2.tar.gz",
 } ->

 exec { "unpack-tomee" : 
    command => "/bin/tar -xzf /tmp/tomee-1.5.2.tar.gz -C /opt/tomee-1.5.2 --strip-components=1",
    creates => "/opt/tomee-1.5.2/bin",
 }

 service { "tomee" :
    provider => "init", 
    ensure => running,
    start => "/opt/tomee-1.5.2/bin/startup.sh",
    stop => "/opt/tomee-1.5.2/bin/shutdown.sh",
    status => "",
    restart => "",
    hasstatus => false,
    hasrestart => false,
    require => [ Exec["unpack-tomee"] ],
  }

}

include tomee

