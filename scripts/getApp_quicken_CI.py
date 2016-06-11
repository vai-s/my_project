#!/usr/bin/env python
import re
import sys
from operator import itemgetter, attrgetter
import time
import urllib2
import operator
import urllib
import zipfile
import os

class UrlOpener(urllib.FancyURLopener):

    def prompt_user_passwd(self, host, realm):
        return 'press', 'mint5454'


def UrlDownloadFile(url, filename):

    opener = UrlOpener()
    return opener.retrieve(url, filename)


# first get the data 
#theurl = 'http://172.18.220.54/iOS/Quicken/Automation/develop/Quicken/'
#username = 'press'
#password = 'mint5454'


#theurl = 'http://build.quickendev.com/gala/iOS/Quicken/'
#theurl='http://172.18.208.36/gala/iOS/Quicken/builds/release/qmobile-v4.2.0/'
#theurl = 'http://172.18.208.36/gala/iOS/Quicken/Automation/develop/Quicken/'
theurl = 'http://192.168.2.15/gala/ios/Quicken/Automation/develop/Quicken/'

username = 'press'
password = 'mint5454'


passman = urllib2.HTTPPasswordMgrWithDefaultRealm()
passman.add_password(None, theurl, username, password)

authhandler = urllib2.HTTPBasicAuthHandler(passman)

opener = urllib2.build_opener(authhandler)
urllib2.install_opener(opener)
pagehandle = urllib2.urlopen(theurl)
output = pagehandle.read()

lines = output.split('\n')
input = "app"
oldDictionary = {}


for l in lines:
    pattern = '(a href=\".*?\.%s\..*?\")(.*)(\d\d\d\d-\d\d-\d\d \d\d:\d\d)' %input
    m = re.search(pattern, l)
    
    if (m):
        startIndex = m.group(1).find('"')
        endIndex = m.group(1).rfind('"')
        keyText = m.group(1)[startIndex+1:endIndex]        
        oldDictionary[keyText] = m.group(3)
    
print oldDictionary

new_list = []
newDictionary = {}

for k, v in oldDictionary.iteritems():
    valueName = v
    keyName = k
    a = time.strptime(valueName, "%Y-%m-%d %H:%M")[0:6]
    newDictionary[keyName] = a

sortedDictionary = sorted(newDictionary.iteritems(),key=operator.itemgetter(1))

#Gives the last element
lastElement = sortedDictionary[-1]
print "latest one:", lastElement
latestApk = lastElement[0] 
latestApkUrl = theurl + latestApk
print "latestApkUrl = ",latestApkUrl
#UrlDownloadFile(latestApkUrl, latestApk)
u = urllib2.urlopen(latestApkUrl)
localFile = open(latestApk, 'w')
localFile.write(u.read())
localFile.close()

os.system('rm -rf Quicken.app')

print "Unzipping..... " + latestApk
with zipfile.ZipFile(latestApk, "r") as z:
    z.extractall()
