from rest_framework.response import Response
from rest_framework.decorators import permission_classes
from rest_framework import permissions
from rest_framework.views import APIView
from .models import Artist
from .serializers import ArtistSerializer


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
