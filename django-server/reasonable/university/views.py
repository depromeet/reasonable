from rest_framework.response import Response
from rest_framework.decorators import permission_classes
from rest_framework import permissions
from rest_framework.views import APIView
from rest_framework import status as rest_status

from .models import University
from .serializers import UniversitySerializer, UniversityListSerializer
from .exceptions import RequestDataError

# Pagination
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger


@permission_classes((permissions.AllowAny,))
class UniversityList(APIView):
    """
    Get University list
    """
    def get(self, request):
        university = University.objects.all()
        serializer = UniversitySerializer(university)
        result = serializer.data
        return Response(result)

@permission_classes((permissions.AllowAny,))
class UniversityDetail(APIView):
    """
    Get Problem list by page
    """

    def get(self, request, **kwargs):
        id = kwargs['id']
        university = University.objects.filter(id=id).first()
        serializer = UniversitySerializer(university)
        result = serializer.data
        return Response(result)

    """
    Create new festival
    """
    def post(self, request):
        try:
            data = request.data
            name = data.get('name')
            if name is None:
                raise RequestDataError

            naver_link = data.get('naver_link')
            if naver_link is None:
                raise RequestDataError

            image_link = data.get('image_link')
            if image_link is None:
                raise RequestDataError

        except RequestDataError:
            return Response("request data error", status=rest_status.HTTP_400_BAD_REQUEST)

        university = University(name=name, naver_link=naver_link, image_link=image_link)
        university.save()

        serializer = UniversitySerializer(university)
        result = serializer.data
        return Response(result, status=rest_status.HTTP_201_CREATED)
