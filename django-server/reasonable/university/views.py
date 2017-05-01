from rest_framework.response import Response
from rest_framework.decorators import permission_classes
from rest_framework import permissions
from rest_framework.views import APIView
from .models import University
from .serializers import UniversitySerializer


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
