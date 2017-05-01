from django.contrib import admin
from .models import University


# Register your models here.
class UniversityAdmin(admin.ModelAdmin):
    list_display = ('id', 'name', 'naver_link')
    list_filter = ('id', 'name', 'naver_link')
    search_fields = ('name',)


admin.site.register(University, UniversityAdmin)
