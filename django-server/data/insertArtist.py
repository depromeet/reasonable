
from artist.models import Artist
f = open('/Users/jtlim/Desktop/12_Depromeet/00_reasonable/reasonable/django-server/data/대학 축제 날짜, 라인업 - Artist.csv', 'r')
for line in f:
    s = line.split(',')
    artist = Artist(name=s[1], naver_link=s[2])
    artist.save()