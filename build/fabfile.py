from fabric.api import run

def stop():
    run('/opt/jetty9/bin/jetty.sh stop')

def start():
    run('nohup /opt/jetty9/bin/jetty.sh start')