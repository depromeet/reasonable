from django.conf.urls import url
from .views import UniversityDetail, UniversityList

urlpatterns = [
    # 대학 리스트
    url(r'^list/(?P<page>[0-9]+)$', UniversityList.as_view()),
    # 대학 세부사항
    url(r'^(?P<id>[0-9]+)$', UniversityDetail.as_view()),
    url(r'^$', UniversityDetail.as_view()),

]
