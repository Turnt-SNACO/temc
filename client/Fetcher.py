import time
from subprocess import Popen, PIPE, STDOUT, call
import sys
import os
URL = "http://nascloud.myds.me:8080/Temc/getMessage"
uname = ""
exists = os.path.isfile('.temcrc')
if exists:
    f = open('.temcrc',"r")
    contents = f.read()
    #print(contents)
    lines = contents.split()
    for s in lines:
        if 'uname' in s:
            uname = s[6:] 
else:    
    uname = input("You do not have a user profile.  Enter a username:")
    f = open('.temcrc',"w+")
    f.write('uname='+uname)
pid = os.fork()
if pid == 0:
    for i in range(5):
        time.sleep(1)
        cmd = 'curl -s -d \'{"uname":' + uname + '", "pass": "nil" }\' -X POST "'+URL+'"'
        p = Popen(cmd, shell=True, stdin=PIPE, stdout=PIPE, stderr=STDOUT, close_fds=True)
        output = p.stdout.read()
        #call(['clear'])
        print("New message:", output.decode('UTF-8'))
else:
    print('parent done')
