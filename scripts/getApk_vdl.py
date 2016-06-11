#!/usr/bin/env python
import re
import sys
from operator import itemgetter, attrgetter
import time
import urllib2
import operator
import urllib

class UrlOpener(urllib.FancyURLopener):

    def prompt_user_passwd(self, host, realm):
        return 'test', 'test'


def UrlDownloadFile(url, filename):

    opener = UrlOpener()
    return opener.retrieve(url, filename)


# first get the data 
count = len(sys.argv)
if count!=3:
    sys.stdout.write("Version and Environment not set")
    sys.exit()
version = sys.argv[1]
env = sys.argv[2]

theurl = "http://172.18.220.70/android/" + version + "/mint/" 
print theurl
username = 'test'
password = 'test'

passman = urllib2.HTTPPasswordMgrWithDefaultRealm()
passman.add_password(None, theurl, username, password)

authhandler = urllib2.HTTPBasicAuthHandler(passman)

opener = urllib2.build_opener(authhandler)
urllib2.install_opener(opener)
pagehandle = urllib2.urlopen(theurl)
output = pagehandle.read()

lines = output.split('\n')
input = sys.argv[2]
oldDictionary = {}

for l in lines:
    pattern = '(a href=\".*?\.%s\..*?\")(.*)(\d\d\d\d-\d\d-\d\d \d\d:\d\d)' %input
    m = re.search(pattern, l)
    
    if (m):
        startIndex = m.group(1).find('"')
        endIndex = m.group(1).rfind('"')
        keyText = m.group(1)[startIndex+1:endIndex]        
        oldDictionary[keyText] = m.group(3)
    
#print oldDictionary

new_list = []
newDictionary = {}

for k, v in oldDictionary.iteritems():
    valueName = v
    keyName = k
    if (keyName.find("Quicken")>=0):
        continue
    a = time.strptime(valueName, "%Y-%m-%d %H:%M")[0:6]
    newDictionary[keyName] = a

sortedDictionary = sorted(newDictionary.iteritems(),key=operator.itemgetter(1))

#Gives the last element
lastElement = sortedDictionary[-1]
print "latest one:", lastElement
latestApk = lastElement[0] 
latestApkUrl = theurl + latestApk
print "latestApkUrl = ",latestApkUrl
UrlDownloadFile(latestApkUrl, latestApk)

