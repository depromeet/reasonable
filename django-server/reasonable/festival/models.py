from django.utils import timezone
from django.db import models
from university.models import University
from artist.models import Artist


# Create your models here.
class Festival(models.Model):

    name = models.CharField(max_length=250, default='2017 축제')
    start_date = models.DateTimeField(default=timezone.now, blank=True)
    end_date = models.DateTimeField(default=timezone.now, blank=True)
    poster_link = models.CharField(max_length=250, default='#')

    # relationships

    # foreign key
    university = models.ForeignKey(University, related_name='festivals')

    def __str__(self):
        return self.name


class FestivalUnit(models.Model):
    start_date = models.DateTimeField(auto_now_add=True, null=True)
    end_date = models.DateTimeField(auto_now=True, null=True)

    # relationships

    # foreign key
    artist = models.ForeignKey(Artist, related_name='festival_units', on_delete=models.CASCADE)
    festival = models.ForeignKey(Festival, related_name='festival_units'
                                 , on_delete=models.CASCADE, null=True)

    def __str__(self):
        return self.artist.name
