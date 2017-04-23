from django.conf.urls import url
from .views import FestivalList, FestivalDetail, FestivalUnitDetail

urlpatterns = [
    # 축제 세부사항

    url(r'^(?P<id>[0-9]+)$', FestivalDetail.as_view()),
    url(r'^$', FestivalDetail.as_view()),
    url(r'^unit/$', FestivalUnitDetail.as_view()),

    url(r'^list/(?P<page>[0-9]+)$', FestivalList.as_view()),

]
