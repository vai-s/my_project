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
apk = sys.argv[1]
version = sys.argv[2]

theurl = "http://172.18.220.70/android/" + version + "/"
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


latestApkUrl = theurl + apk
print "latestApkUrl = ",latestApkUrl
UrlDownloadFile(latestApkUrl, apk)

