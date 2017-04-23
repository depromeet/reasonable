from rest_framework.response import Response
from rest_framework.decorators import permission_classes
from rest_framework import permissions
from rest_framework.views import APIView
from rest_framework import status as rest_status

from .models import Festival, FestivalUnit
from university.models import University
from artist.models import Artist

from .exceptions import RequestDataError, DateTimeFormatError, InvalidUniversityIdError, InvalidArtistIdError, InvalidFestiavlIdError

# date time parsing
import datetime
import re
from django.utils import six

# Serializer
from .serializers import FestivalListSerializer, FestivalSerializer, FestivalUnitSerializer

# Pagination
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger


# Create your views here.
@permission_classes((permissions.AllowAny,))
class FestivalList(APIView):
    """
    Get festival list
    """

    def get(self, request, **kwargs):

        object_list = Festival.objects.all()
        paginator = Paginator(object_list, 12)
        page = kwargs['page']

        try:
            festivals = paginator.page(page)
        except PageNotAnInteger:
            festivals = paginator.page(1)
        except EmptyPage:
            festivals = paginator.page(paginator.num_pages)

        serializer = FestivalListSerializer(festivals, many=True, context={'num_pages': paginator.num_pages})
        result = serializer.data
        return Response(result)


# Create your views here.
@permission_classes((permissions.AllowAny,))
class FestivalDetail(APIView):
    """
    Get Problem list by page
    """
    def get(self, request, **kwargs):
        id = kwargs['id']
        festival = Festival.objects.filter(id=id).first()

        serializer = FestivalSerializer(festival)
        result = serializer.data
        return Response(result)

    """
    Create new festival
    """
    def post(self, request):
        try:

            data = request.data
            # 1. name
            name = data.get('name')
            if name is None:
                raise RequestDataError

            # 2017-03-03T17:30
            datetime_re = re.compile(
                r'(?P<year>\d{4})-(?P<month>\d{1,2})-(?P<day>\d{1,2})'
                r'[T ](?P<hour>\d{1,2}):(?P<minute>\d{1,2})'
            )

            # 2. start_date
            start_date = data.get('start_date')
            if start_date is None:
                raise RequestDataError

            match = datetime_re.match(start_date)
            if match:
                kw = {k: int(v) for k, v in six.iteritems(match.groupdict())}
                start_date = datetime.datetime(**kw)
            else:
                raise DateTimeFormatError

            # 3. end_date
            end_date = data.get('end_date')
            if end_date is None:
                raise RequestDataError

            match = datetime_re.match(end_date)
            if match:
                kw = {k: int(v) for k, v in six.iteritems(match.groupdict())}
                end_date = datetime.datetime(**kw)
            else:
                raise DateTimeFormatError

            # 4. poster_link
            poster_link = data.get('poster_link')
            if poster_link is None:
                raise RequestDataError

            # 5. university
            university_id = data.get('university_id')
            if university_id is None:
                raise RequestDataError
            university = University.objects.filter(id=university_id)
            if university is None:
                raise InvalidUniversityIdError
            festival = Festival(name=name, start_date=start_date, end_date=end_date, poster_link=poster_link, university_id=university_id)
            festival.save()

            serializer = FestivalSerializer(festival)
            result = serializer.data

        except RequestDataError:
            return Response("request data error", status=rest_status.HTTP_400_BAD_REQUEST)
        except DateTimeFormatError:
            return Response("Date time format error", status=rest_status.HTTP_400_BAD_REQUEST)
        except InvalidUniversityIdError:
            return Response("Invalid university_id error", status=rest_status.HTTP_400_BAD_REQUEST)

        return Response(result, status=rest_status.HTTP_201_CREATED)


# Create your views here.
@permission_classes((permissions.AllowAny,))
class FestivalUnitDetail(APIView):
    """
    Create new festival_unit
    """
    def post(self, request):
        try:

            data = request.data
            # 1. artist
            artist_id = data.get('artist_id')
            if artist_id is None:
                raise RequestDataError
            artist = Artist.objects.filter(id=artist_id).first()
            if artist is None:
                raise InvalidArtistIdError

            # 2. festival
            festival_id = data.get('festival_id')
            if festival_id is None:
                raise RequestDataError
            festival = Festival.objects.filter(id=festival_id).first()
            if festival is None:
                raise InvalidFestiavlIdError

            # 2017-03-03T17:30
            datetime_re = re.compile(
                r'(?P<year>\d{4})-(?P<month>\d{1,2})-(?P<day>\d{1,2})'
                r'[T ](?P<hour>\d{1,2}):(?P<minute>\d{1,2})'
            )

            # 3. start_date
            start_date = data.get('start_date')
            if start_date is None:
                raise RequestDataError
            match = datetime_re.match(start_date)
            if match:
                kw = {k: int(v) for k, v in six.iteritems(match.groupdict())}
                start_date = datetime.datetime(**kw)
            else:
                raise DateTimeFormatError

            # 4. end_date
            end_date = data.get('end_date')
            if end_date is None:
                raise RequestDataError
            match = datetime_re.match(end_date)
            if match:
                kw = {k: int(v) for k, v in six.iteritems(match.groupdict())}
                end_date = datetime.datetime(**kw)
            else:
                raise DateTimeFormatError

            festival_unit = FestivalUnit(artist_id=artist_id, festival_id=festival_id, start_date=start_date, end_date=end_date)
            festival_unit.save()

            serializer = FestivalUnitSerializer(festival_unit)
            result = serializer.data

        except InvalidArtistIdError:
            return Response("Invalid artist_id error", status=rest_status.HTTP_400_BAD_REQUEST)
        except InvalidFestiavlIdError:
            return Response("Invalid festival_id error", status=rest_status.HTTP_400_BAD_REQUEST)
        except DateTimeFormatError:
            return Response("Date time format error", status=rest_status.HTTP_400_BAD_REQUEST)

        return Response(result, status=rest_status.HTTP_201_CREATED)
