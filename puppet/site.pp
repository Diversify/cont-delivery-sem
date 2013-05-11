package { [ 'jetty', 'libjetty-extra-java' ]: ensure => absent }
package { [ 'tomcat6' ]: ensure => absent }

class jetty {


 file {"/opt/jetty9":
    ensure => directory,
    recurse => true,
    owner=>"ubuntu",
    group=>"ubuntu",
 } ->

 exec { "download-jetty" :
    command => '/usr/bin/wget "http://eclipse.org/downloads/download.php?file=/jetty/stable-9/dist/jetty-distribution-9.0.3.v20130506.tar.gz&r=1" -O /tmp/jetty-distribution-9.0.3.v20130506.tar.gz',
    creates => "/tmp/jetty-distribution-9.0.3.v20130506.tar.gz",
 } ->

 exec { "unpack-jetty" : 
    command => "/bin/tar -xzf /tmp/jetty-distribution-9.0.3.v20130506.tar.gz -C /opt/jetty9 --strip-components=1",
    creates => "/opt/jetty9/bin",
 }

 service { "jetty" :
    provider => "init", 
    ensure => stopped,
    start => "/opt/jetty9/bin/jetty.sh start",
    stop => "/opt/jetty9/bin/jetty.sh stop",
    status => "",
    restart => "",
    hasstatus => false,
    hasrestart => false,
    require => [ Exec["unpack-jetty"] ],
  }

}

include jetty

