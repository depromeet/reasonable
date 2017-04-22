from django.contrib import admin
from .models import Artist


# Register your models here.
class ArtistAdmin(admin.ModelAdmin):
    list_display = ('id', 'name', 'naver_link')
    list_filter = ('id', 'name', 'naver_link')


admin.site.register(Artist, ArtistAdmin)
