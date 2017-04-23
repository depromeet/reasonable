from django.conf.urls import url
from .views import UniversityDetail

urlpatterns = [
    # 대학 세부사항
    url(r'^(?P<id>[0-9]+)$', UniversityDetail.as_view()),
    url(r'^$', UniversityDetail.as_view()),
]
