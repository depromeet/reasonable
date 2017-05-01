from django.contrib import admin
from .models import Festival, FestivalUnit


# Register your models here.

class FestivalAdmin(admin.ModelAdmin):
    list_display = ('name', 'university', 'start_date', 'end_date')
    list_filter = ('name', 'university', 'start_date', 'end_date')
    search_fields = ('university',)


admin.site.register(Festival, FestivalAdmin)


class FestivalUnitAdmin(admin.ModelAdmin):
    list_display = ('artist', 'festival', 'start_date', 'end_date')
    list_filter = ('artist', 'festival', 'start_date', 'end_date')
    search_fields = ('artist',)


admin.site.register(FestivalUnit, FestivalUnitAdmin)
