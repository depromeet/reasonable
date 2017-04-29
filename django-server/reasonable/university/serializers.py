from rest_framework import serializers
from .models import University


class UniversitySerializer(serializers.ModelSerializer):
    max_pages = serializers.SerializerMethodField()

    def get_max_pages(self, obj):
        return self.context['num_pages']

    class Meta:
        model = University
        # fields = ['start_date', 'end_date', 'artist']
        fields = '__all__'


class UniversityListSerializer(serializers.ModelSerializer):
    class Meta:
        model = University
        # class 안에 def 를 넣어야하는거같은데 왜 넣는거지 모르겠음 시간부족해서 못봄... 그냥 일단 만듬
        # fields = ['id', 'name', 'num_pages', 'naver_link', 'image_link']
        fields = '__all__'
