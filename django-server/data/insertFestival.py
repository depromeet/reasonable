# date time parsing
import datetime
import re
from django.utils import six
from festival.models import Festival
from university.models import University

FESTIVAL_NAME = 1
UNIV_NAME = 2
START_DATE = 3
END_DATE = 4
# id,festival_name      ,univ_id   ,start_date ,end_date
# 1 ,2016 가톨릭대학교 축제 ,가톨릭대학교  ,2016-05-09 ,2016-05-12

f = open('/Users/jtlim/Desktop/12_Depromeet/00_reasonable/reasonable/django-server/data/대학 축제 날짜, 라인업 - Festival.csv', 'r')
for line in f:
    s = line.split(',')
    if s[0] == 'id':
        continue
    festival_name = s[FESTIVAL_NAME]
    univ_name = s[UNIV_NAME]
    university = University.objects.filter(name=univ_name).first()
    university_id = university.id
    start_date = s[START_DATE]
    datetime_re = re.compile(r'(?P<year>\d{4})-(?P<month>\d{1,2})-(?P<day>\d{1,2})')
    match = datetime_re.match(start_date)
    if match:
        kw = {k: int(v) for k, v in six.iteritems(match.groupdict())}
        start_date = datetime.date(**kw)
        print("start_date"+str(start_date))
    end_date = s[END_DATE]
    datetime_re = re.compile(r'(?P<year>\d{4})-(?P<month>\d{1,2})-(?P<day>\d{1,2})')
    match = datetime_re.match(end_date)
    if match:
        kw = {k: int(v) for k, v in six.iteritems(match.groupdict())}
        end_date = datetime.datetime(**kw)
        print("end_date"+str(end_date))
    festival = Festival(name=festival_name, start_date=start_date, end_date=end_date, university_id=university_id)
    festival.save()