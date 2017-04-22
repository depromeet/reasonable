from django.db import models


# Create your models here.

class Artist(models.Model):
    name = models.CharField(max_length=250)
    naver_link = models.CharField(max_length=250)
    image_link = models.CharField(max_length=250)

    def __str__(self):
        return self.name

    class Meta:
        ordering = ('name',)
