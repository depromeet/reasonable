from rest_framework.response import Response
from rest_framework.decorators import permission_classes
from rest_framework import permissions
from rest_framework.views import APIView
from .models import Artist
from .serializers import ArtistSerializer
from .exceptions import RequestDataError
from rest_framework import status as rest_status


@permission_classes((permissions.AllowAny,))
class ArtistDetail(APIView):
    """
    Get Problem list by page
    """

    def get(self, request, **kwargs):
        id = kwargs['id']
        artist = Artist.objects.filter(id=id).first()
        serializer = ArtistSerializer(artist)
        result = serializer.data
        return Response(result)

    """
    Create new festival
    """

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

        artist = Artist(name=name, naver_link=naver_link, image_link=image_link)
        artist.save()

        artist = ArtistSerializer(artist)
        result = artist.data
        return Response(result, status=rest_status.HTTP_201_CREATED)