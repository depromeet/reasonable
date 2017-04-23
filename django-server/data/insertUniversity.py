from university.models import University
f = open('/Users/jtlim/Desktop/12_Depromeet/00_reasonable/reasonable/django-server/data/대학 축제 날짜, 라인업 - Univ.csv', 'r')
for line in f:
    s = line.split(',')
    university = University(name=s[1])
    university.save()