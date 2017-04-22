from rest_framework.response import Response
from rest_framework.decorators import permission_classes
from rest_framework import permissions
from rest_framework.views import APIView
from .models import Festival

# Serializer
from .serializers import FestivalListSerializer, FestivalSerializer

# Pagination
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger


# Create your views here.
@permission_classes((permissions.AllowAny,))
class FestivalList(APIView):
    """
    Get Problem list by page
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
