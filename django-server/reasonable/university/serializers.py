from rest_framework import serializers
from .models import University


class UniversitySerializer(serializers.ModelSerializer):
    class Meta:
        model = University
        # fields = ['start_date', 'end_date', 'artist']
        fields = '__all__'


class UniversityListSerializer(serializers.ModelSerializer):
    class Meta:
        model = University
        # fields = ['id', 'name', 'num_pages', 'naver_link', 'image_link']
        fields = '__all__'
