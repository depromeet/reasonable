# date time parsing
import datetime
import re
from django.utils import six
from festival.models import Festival, FestivalUnit
from artist.models import Artist
FESTIVAL_NAME = 0
ARTIST_NAME = 1
START_DATE = 2
END_DATE = 3
# festival_name,artist_name,start_time,end_time,festival_id,artist_id
# 2016 가톨릭대학교 축제,델리민주,,,1,1
# 2016 가톨릭대학교 축제,10cm,2016-05-10T20:00:00.000000Z,2016-05-10T21:00:00.000000Z,1,2
f = open('/Users/jtlim/Desktop/12_Depromeet/00_reasonable/reasonable/django-server/data/대학 축제 날짜, 라인업 - FestivalUnit.csv', 'r')
for line in f:
    s = line.split(',')
    if s[0] == 'festival_name':
        continue
    festival_name = s[FESTIVAL_NAME]
    print(festival_name)
    festival = Festival.objects.filter(name=festival_name).first()
    festival_id = festival.id
    artist_name = s[ARTIST_NAME]
    artist = Artist.objects.filter(name=artist_name).first()
    artist_id = artist.id
    start_date = s[START_DATE]
    datetime_re = re.compile(r'(?P<year>\d{4})-(?P<month>\d{1,2})-(?P<day>\d{1,2})[T ](?P<hour>\d{1,2}):(?P<minute>\d{1,2})')
    match = datetime_re.match(start_date)
    if match:
        kw = {k: int(v) for k, v in six.iteritems(match.groupdict())}
        start_date = datetime.datetime(**kw)
        print("start_date"+str(start_date))
    end_date = s[END_DATE]
    match = datetime_re.match(end_date)
    if match:
        kw = {k: int(v) for k, v in six.iteritems(match.groupdict())}
        end_date = datetime.datetime(**kw)
        print("end_date"+str(end_date))
    if start_date == '' or end_date == '':
        festival_unit = FestivalUnit(festival_id=festival_id, artist_id=artist_id)
    else:    
        festival_unit = FestivalUnit(start_date=start_date, end_date=end_date, festival_id=festival_id, artist_id=artist_id)
    festival_unit.save()