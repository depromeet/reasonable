from django.conf.urls import url
from .views import ArtistDetail

urlpatterns = [
    # 아티스트 세부사항
    url(r'^(?P<id>[0-9]+)$', ArtistDetail.as_view()),
    url(r'^$', ArtistDetail.as_view()),
]
